package com.devPortes.fields.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fields")
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class FieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
