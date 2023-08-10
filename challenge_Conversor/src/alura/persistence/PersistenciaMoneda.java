package alura.persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Se añaden los sig. import del .JAR en /lib en el Path
 */
import org.json.JSONException;
import org.json.JSONObject;

public class PersistenciaMoneda {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/"; // URL de la API de monedas

    public BigDecimal obtenerValorMoneda(String moneda) throws IOException {
        String urlCompleta = API_URL + moneda;
        URL url = new URL(urlCompleta);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject rates = jsonObject.getJSONObject("rates");
            BigDecimal valorMoneda = rates.getBigDecimal(moneda);

            return valorMoneda;
        } catch (JSONException e) {
            throw new IOException("Respuesta inválida de la API", e);
        }
    }
    
    public BigDecimal obtenerValorMonedaOut(String monedaIn, String monedaOut) throws IOException {
        String urlCompleta = API_URL + monedaIn;
        URL url = new URL(urlCompleta);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject rates = jsonObject.getJSONObject("rates");
            BigDecimal valorMoneda = rates.getBigDecimal(monedaOut);

            return valorMoneda;
        } catch (JSONException e) {
            throw new IOException("Respuesta inválida de la API", e);
        }
    }
}

