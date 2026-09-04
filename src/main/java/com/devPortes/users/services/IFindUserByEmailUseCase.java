package com.devPortes.users.services;


import com.devPortes.users.model.Client;
import com.devPortes.users.model.IAuthenticated;

import java.util.Optional;

public interface IFindUserByEmailUseCase {
    Optional<IAuthenticated> execute (String email);
    Optional<Client> findClientByEmail (String email);

}
