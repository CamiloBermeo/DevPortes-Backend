package com.devPortes.users.infrastructure.output.entities;

import com.devPortes.users.domain.model.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    Long id;
    @Column
    String name;
    @Column
    String identityDocument;
    @Column
    String phoneNumber;
    @Column
    String email;
    @Column
    String passwordHash;
    @Column
    RoleEnum role;


}
