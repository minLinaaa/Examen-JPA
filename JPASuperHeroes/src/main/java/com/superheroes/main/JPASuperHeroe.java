/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.superheroes.main;

import com.superheroes.dao.SuperHeroeDAO;
import com.superheroes.model.*;

/**
 *
 * @author anapa
 */
public class JPASuperHeroe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SuperHeroeDAO dao = new SuperHeroeDAO();

        // INSERTAR
        SuperHeroe spiderman = new SuperHeroe(
                "Spiderman",
                Universo.MARVEL,
                new IdentidadSecreta("Peter Parker", "New York", "Fotógrafo"),
                "Un gran poder conlleva una gran responsabilidad"
        );

        SuperHeroe batman = new SuperHeroe(
                "Batman",
                Universo.DC,
                new IdentidadSecreta("Bruce Wayne", "Gotham", "Empresario"),
                "Soy la venganza"
        );

        dao.insertar(spiderman);
        dao.insertar(batman);

        // LISTAR
        System.out.println("=== LISTA INICIAL ===");
        dao.listar().forEach(System.out::println);

        // ACTUALIZAR
        spiderman.setNombre("Spider-Man");
        dao.actualizar(spiderman);

        System.out.println("=== DESPUÉS DE ACTUALIZAR ===");
        dao.listar().forEach(System.out::println);

        // ELIMINAR
        dao.eliminar(batman.getId());

        System.out.println("=== DESPUÉS DE ELIMINAR ===");
        dao.listar().forEach(System.out::println);
    
    }
    
}
