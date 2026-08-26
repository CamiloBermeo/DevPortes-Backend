package com.devPortes.users.model;

import com.devPortes.reservations.model.Reservation;
import com.devPortes.users.exceptions.EmailInvalidException;
import com.devPortes.users.exceptions.IdentityDocumentInvalidException;
import com.devPortes.users.exceptions.PasswordHashInvalidException;

public class UserModel {
    private Long id;
    private String name;
    private String identityDocument;
    private String phoneNumber;
    private String email;
    private String passwordHash;
    private ClasificationEnum classification;
    private int reservationAmount;
    private RoleEnum role;
    private boolean state;

    public UserModel() {
    }

    private UserModel(Long id, String name, String identityDocument, String phoneNumber, String email, String passwordHash, ClasificationEnum classification, int reservationAmount, RoleEnum role,boolean state) {
        this.id = id;
        this.name = name;
        this.identityDocument = identityDocument;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwordHash = passwordHash;
        this.classification = classification;
        this.reservationAmount = reservationAmount;
        this.role = role;
        this.state = state;
    }

    //Este metodo crea un nuevo model el cual sera usado como principal, hace validaciones y logica pura de Java
    public static UserModel create(String name, String identityDocument, String phoneNumber, String email, String passwordHash, RoleEnum role) {

        if (identityDocument.length() < 10) {
            identityDocument = identityDocument.toLowerCase();
        }else {
            throw new IdentityDocumentInvalidException(identityDocument);
        }

        if (!email.contains("@") && !email.contains(".com")) {
            throw new EmailInvalidException(email);
        }else {
            email = email.toLowerCase();
        }
        if (passwordHash.isEmpty()) {
            throw new PasswordHashInvalidException();
        }

        if (role == null){
            role = RoleEnum.CLIENTE;
        }

        return new UserModel(null,name, identityDocument, phoneNumber, email,passwordHash, ClasificationEnum.ESTANDAR,0, role, true);
    }

    //Este metodo construye un model que viene de base de datos, ya que no necesita validaciones ni nada porque se supone que ya esta bien construido y guardado en db
    public static UserModel reconstitute(Long id,String name, String identityDocument, String phoneNumber, String email, String passwordHash, ClasificationEnum classification, int reservationAmount, RoleEnum role, boolean state) {
        return new UserModel(id, name, identityDocument, phoneNumber, email, passwordHash,  classification,  reservationAmount, role, state);
    }

    public RoleEnum getRole() {
        return role;
    }

    public ClasificationEnum getClassification() {
        return classification;
    }

    public int getReservationAmount() {
        return reservationAmount;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    public boolean isState() {
        return state;
    }
}
