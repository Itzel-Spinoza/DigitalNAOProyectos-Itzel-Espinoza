/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author itzel
 */
public class GoogleScholarModel {
    private final String apiKey;

    public GoogleScholarModel(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getAuthorPublications(String authorId) throws IOException {
        String apiUrl = "https://serpapi.com/search.json?engine=google_scholar_author&author_id=" + authorId + "&api_key=" + apiKey;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        StringBuilder jsonResponse = new StringBuilder();
        if (responseCode == 200) { // 200 OK
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    jsonResponse.append(inputLine);
                }
            }
        } else {
            System.err.println("Error en la solicitud: " + responseCode);
        }

        connection.disconnect();
        return jsonResponse.toString();
    }
}