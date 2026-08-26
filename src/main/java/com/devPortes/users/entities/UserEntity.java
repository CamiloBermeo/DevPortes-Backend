package com.devPortes.users.entities;

import com.devPortes.users.model.ClasificationEnum;
import com.devPortes.users.model.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    ClasificationEnum classification;
    @Column(nullable = true)
    int reserveAmount;
    @Enumerated(EnumType.STRING)
    @Column
    RoleEnum role;

}
