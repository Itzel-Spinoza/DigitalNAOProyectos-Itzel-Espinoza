/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import modelo.GoogleScholarModel;

/**
 *
 * @author itzel
 */
public class GoogleScholarController {
    private final GoogleScholarModel model;

    public GoogleScholarController(GoogleScholarModel model) {
        this.model = model;
    }

    public void obtenerPublicacionesAutor(String authorId) {
        try {
            String jsonResponse = model.getAuthorPublications(authorId);
            System.out.println("Publicaciones del autor:");
            System.out.println(jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al obtener las publicaciones del autor.");
        }
    }
}