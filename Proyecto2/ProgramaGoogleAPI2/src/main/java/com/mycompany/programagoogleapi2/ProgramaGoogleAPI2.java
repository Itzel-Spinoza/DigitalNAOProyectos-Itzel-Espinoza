/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.programagoogleapi2;


import controlador.GoogleScholarController;
import modelo.DatabaseHelper;
import modelo.GoogleScholarModel;

public class ProgramaGoogleAPI2 {

    public static void main(String[] args) {
        String apiKey = "7e325f00431015f4e78cf62de1808f5e2c0c7defde7f2ac0f9f82f929e081ee2";
        GoogleScholarModel model = new GoogleScholarModel(apiKey);

        // Conexión a la base de datos MySQL
        String url = "jdbc:mysql://localhost:3306/google_scholar";
        String user = "root"; // Usuario de la base de datos
        String password = "12345"; // Contraseña de la base de datos

        DatabaseHelper dbHelper = new DatabaseHelper(url, user, password);

        GoogleScholarController controller = new GoogleScholarController(model, dbHelper);

        String authorId = "LSsXyncAAAAJ";
        controller.obtenerPublicacionesAutor(authorId);
    }
}
