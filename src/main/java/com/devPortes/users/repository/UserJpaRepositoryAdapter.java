package com.devPortes.users.repository;

import com.devPortes.users.entities.AdminEntity;
import com.devPortes.users.exceptions.UserNotFoundException;
import com.devPortes.users.model.Admin;
import com.devPortes.users.model.Client;
import com.devPortes.users.entities.ClientEntity;
import com.devPortes.users.mapper.UserOutMapper;
import com.devPortes.users.model.IAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserJpaRepositoryAdapter {
    private final IClientJpaRepository clientJpa;
    private final IAdminJpaRepository adminJpa;

    public List<ClientEntity> findAllClients() {
        return clientJpa.findAll();
    }

    public Optional<Client> finById(Long id){

        return clientJpa.findById(id).map(UserOutMapper::toClientCompleteModel);
    }
    public Optional<IAuthenticated> findByEmail(String email) {
        Optional<Client> client = clientJpa.findByEmail(email).map(UserOutMapper::toClientCompleteModel);
        if (client.isPresent()) {
            return Optional.of(client.get());
        }
        return adminJpa.findByEmail(email).map(UserOutMapper::toAdminCompleteModel);
    }

    public Optional<Client> findClientByEmail(String email) {
        return clientJpa.findByEmail(email).map(UserOutMapper::toClientCompleteModel);
    }
    public Optional<Admin> findAdminByEmail(String email) {
        return adminJpa.findByEmail(email).map(UserOutMapper::toAdminCompleteModel);
    }

    public Client saveEdit(Long id,Client editClient){
        ClientEntity savedEntity = clientJpa.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.valueOf(id)));

        ClientEntity editEntity = UserOutMapper.toEditClientEntity(savedEntity, editClient);

        return UserOutMapper.toClientCompleteModel(clientJpa.save(editEntity));
    }
    public Client save(Client user) {
        ClientEntity entity = UserOutMapper.toClientEntity(user);
        return UserOutMapper.toClientCompleteModel(clientJpa.save(entity));
    }
}
