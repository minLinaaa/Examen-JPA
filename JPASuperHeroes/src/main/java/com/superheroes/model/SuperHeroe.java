/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.superheroes.model;

import jakarta.persistence.*;




@Entity
@Table(name = "superheroes")
public class SuperHeroe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    @Enumerated(EnumType.STRING)
    private Universo universo;

    @Embedded
    private IdentidadSecreta identidadSecreta;

    @Transient
    private String fraseIconica;

    public SuperHeroe() {}

    public SuperHeroe(String nombre, Universo universo,
                      IdentidadSecreta identidadSecreta,
                      String fraseIconica) {
        this.nombre = nombre;
        this.universo = universo;
        this.identidadSecreta = identidadSecreta;
        this.fraseIconica = fraseIconica;
    }

    public Long getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Universo getUniverso() { return universo; }
    public void setUniverso(Universo universo) { this.universo = universo; }

    public IdentidadSecreta getIdentidadSecreta() { return identidadSecreta; }
    public void setIdentidadSecreta(IdentidadSecreta identidadSecreta) {
        this.identidadSecreta = identidadSecreta;
    }

    public String getFraseIconica() { return fraseIconica; }
    public void setFraseIconica(String fraseIconica) {
        this.fraseIconica = fraseIconica;
    }

    @Override
    public String toString() {
        return "SuperHeroe{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", universo=" + universo +
                ", nombreReal=" + identidadSecreta.getNombreReal() +
                '}';
    }
}
