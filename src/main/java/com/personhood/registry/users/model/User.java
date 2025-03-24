package com.personhood.registry.users.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * La clase User representa a un usuario en el sistema.
 * Esta clase está mapeada a la tabla "users" en la base de datos.
 * Utiliza anotaciones de JPA para definir la estructura de la tabla y Lombok para generar automáticamente
 * los métodos getter, setter y constructores.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * Identificador único del usuario.
     * Este campo es generado automáticamente por la base de datos utilizando una estrategia de identidad.
     */
    @Id
    @Column(length = 10, unique = true, nullable = false)
    private String id;

    /**
     * El nombre del usuario.
     * Este campo es obligatorio y no puede ser nulo.
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * El apellido del usuario.
     * Este campo es obligatorio y no puede ser nulo.
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * La dirección de correo electrónico del usuario.
     * Este campo es obligatorio, no puede ser nulo y debe ser único en la base de datos.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * El número de teléfono del usuario.
     * Este campo es obligatorio, no puede ser nulo y debe ser único en la base de datos.
     */
    @Column(nullable = false, unique = true)
    private String phoneNumber;

    /**
     * El género del usuario.
     * Este campo es obligatorio y se almacena como una cadena de texto que representa un valor enumerado.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
}