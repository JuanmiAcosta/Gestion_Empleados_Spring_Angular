package com.gestion.empleados.gestionempleadosbackend.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //El identificador único y que se genere automáticamente
    private Long Id;

    @Column(name = "nombre", length=25, nullable=false)
    private String nombre;
    @Column(name = "apellido", length=25, nullable = false)
    private String apellido;
    @Column(name = "email", length=50, nullable=false, unique=true)
    private String email;

}
