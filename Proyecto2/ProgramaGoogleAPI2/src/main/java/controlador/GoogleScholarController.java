/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.io.IOException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import modelo.DatabaseHelper;
import modelo.GoogleScholarModel;

public class GoogleScholarController {
    private final GoogleScholarModel model;
    private final DatabaseHelper dbHelper;

    public GoogleScholarController(GoogleScholarModel model, DatabaseHelper dbHelper) {
        this.model = model;
        this.dbHelper = dbHelper;
    }

    public void obtenerPublicacionesAutor(String authorId) {
        try {
            String jsonResponse = model.getAuthorPublications(authorId);
            System.out.println("Publicaciones del autor:");
            System.out.println(jsonResponse);

            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            JsonObject authorObject = jsonObject.getAsJsonObject("author");
            JsonArray publications = jsonObject.getAsJsonArray("articles"); // Cambio aquí

            if (publications != null) {
                for (int i = 0; i < publications.size(); i++) {
                    JsonObject publication = publications.get(i).getAsJsonObject();
                    String title = publication.get("title").getAsString();
                    String publicationDate = publication.get("year").getAsString(); // Cambio aquí
                    String journal = publication.get("publication").getAsString(); // Cambio aquí
                    int citations = publication.has("cited_by") ? publication.get("cited_by").getAsJsonObject().get("value").getAsInt() : 0; // Cambio aquí

                    // Almacenar en la base de datos
                    dbHelper.insertPublication(authorId, title, publicationDate, journal, citations);
                }
            } else {
                System.err.println("No se encontraron publicaciones para este autor.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al obtener las publicaciones del autor.");
        }
    }
}
