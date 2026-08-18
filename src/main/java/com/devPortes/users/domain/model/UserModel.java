package com.devPortes.users.domain.model;

import com.devPortes.users.domain.exceptions.EmailInvalidException;
import com.devPortes.users.domain.exceptions.IdentityDocumentInvalidException;
import com.devPortes.users.domain.exceptions.PasswordHashInvalidException;

public class UserModel {
    Long id;
    String name;
    String identityDocument;
    String phoneNumber;
    String email;
    String passwordHash;
    RoleEnum role;

    public UserModel() {
    }

    private UserModel(Long id, String name, String identityDocument, String phoneNumber, String email, String passwordHash, RoleEnum role) {
        this.id = id;
        this.name = name;
        this.identityDocument = identityDocument;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    //Este metodo crea un nuevo model el cual sera usado como principal, hace validaciones y logica pura de Java
    public static UserModel create(String name, String identityDocument, String phoneNumber, String email, String passwordHash, RoleEnum role) {

        if (identityDocument.length() < 10) {
            throw new IdentityDocumentInvalidException(identityDocument);
        }
        if (!email.contains("@") && !email.contains(".com")) {
            throw new EmailInvalidException(email);
        }
        if (passwordHash.isEmpty()) {
            throw new PasswordHashInvalidException();
        }
        if (role.toString().isEmpty()){
            role = RoleEnum.CLIENTE;
        }
        return new UserModel(null, name, identityDocument, phoneNumber, email, passwordHash, role);
    }

    //Este metodo construye un model que viene de base de datos, ya que no necesita validaciones ni nada porque se supone que ya esta bien construido y guardado en db
    public static UserModel reconstitute(Long id, String name, String identityDocument, String phoneNumber, String email, String passwordHash, RoleEnum role) {
        return new UserModel(id, name, identityDocument, phoneNumber, email, passwordHash, role);
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
