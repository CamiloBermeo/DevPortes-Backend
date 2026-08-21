package com.devPortes.users.infrastructure.output.entities;

import com.devPortes.users.domain.model.RoleEnum;
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
    @Column(nullable = true)
    String classification;
    @Column(nullable = true)
    String reserveAmount;
    @Enumerated(EnumType.STRING)
    @Column
    RoleEnum role;


}
