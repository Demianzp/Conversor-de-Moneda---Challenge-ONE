import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConversorMoneda {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/548cb40c0e093575f0641080/latest/ARS";

    public void iniciar() {
        try {
            Map<String, Double> tasasCambio = obtenerTasasCambio();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n=== Conversor de Monedas ===");
                System.out.println("1. Peso Argentino (ARS)");
                System.out.println("2. Dólar Estadounidense (USD)");
                System.out.println("3. Real Brasileño (BRL)");
                System.out.println("4. Salir");
                System.out.print("Elige la moneda de origen (1-4): ");

                int opcionOrigen = scanner.nextInt();

                if (opcionOrigen == 4) {
                    System.out.println("Saliendo del conversor. ¡Hasta pronto!");
                    break;
                }

                System.out.print("Elige la moneda de destino (1-3): ");
                int opcionDestino = scanner.nextInt();

                if (opcionDestino == 4) {
                    System.out.println("Saliendo del conversor. ¡Hasta pronto!");
                    break;
                }

                String monedaOrigen = obtenerCodigoMoneda(opcionOrigen);
                String monedaDestino = obtenerCodigoMoneda(opcionDestino);

                if (monedaOrigen == null || monedaDestino == null) {
                    System.out.println("Selección inválida. Intenta de nuevo.");
                    continue;
                }

                System.out.print("Introduce la cantidad a convertir: ");
                double cantidad = scanner.nextDouble();

                double tasaOrigen = tasasCambio.get(monedaOrigen);
                double tasaDestino = tasasCambio.get(monedaDestino);
                double resultado = convertir(cantidad, tasaOrigen, tasaDestino);

                System.out.printf("%.2f %s equivalen a %.2f %s%n" , cantidad ,monedaOrigen , resultado , monedaDestino);
            }

            scanner.close();

        } catch (IOException e) {
            System.err.println("Error al obtener las tasas de cambio: " + e.getMessage());
        }
    }

    private Map<String, Double> obtenerTasasCambio() throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        try (InputStreamReader lector = new InputStreamReader(conexion.getInputStream())) {
            Gson gson = new Gson();
            Map<String, Object> respuesta = gson.fromJson(lector, new TypeToken<Map<String, Object>>() {}.getType());
            return (Map<String, Double>) respuesta.get("conversion_rates");
        }
    }

    private String obtenerCodigoMoneda(int opcion) {
        return switch (opcion) {
            case 1 -> "ARS";
            case 2 -> "USD";
            case 3 -> "BRL";
            default -> null;
        };
    }

    private double convertir(double cantidad, double tasaOrigen, double tasaDestino) {
        return cantidad / tasaOrigen * tasaDestino;
    }
}
