/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.programagoogleapi2;

import controlador.GoogleScholarController;
import modelo.GoogleScholarModel;

/**
 *
 * @author itzel
 */
public class ProgramaGoogleAPI2 {

    public static void main(String[] args) {
        String apiKey = "7e325f00431015f4e78cf62de1808f5e2c0c7defde7f2ac0f9f82f929e081ee2";
        GoogleScholarModel model = new GoogleScholarModel(apiKey);
        GoogleScholarController controller = new GoogleScholarController(model);

        String authorId = "LSsXyncAAAAJ";
        controller.obtenerPublicacionesAutor(authorId);
    }
}
