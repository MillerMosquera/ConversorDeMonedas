import modelo.conversion;
import modelo.conversionDTO;
import service.convertirGson;
import service.serviceConversion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<conversion> conversiones = new ArrayList<>();

        serviceConversion serviceConversion = new serviceConversion();
        convertirGson convertir = new convertirGson();

        while (true) {

            System.out.println("\n Bienvenido al conversor de moneda");
            System.out.println("\n 1. Dolar => Peso colombiano" +
                    "\n 2. Peso colombiano => Dolar" +
                    "\n 3. Dolar => Real Brasileño" +
                    "\n 4. Real brasileño => Dolar" +
                    "\n 5. Dolar => Peso argentino" +
                    "\n 6. Peso argentino => Dolar" +
                    "\n 7. Salir");

            var opcion = scan.nextInt();

            if (opcion == 7) {
                break;
            }
            try {

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese la cantidad a convertir: ");
                        var cantidad = scan.nextDouble();
                        conversion resultado = realizarConversion("USD", "COP", cantidad, serviceConversion, convertir);
                        System.out.println(resultado);
                        conversiones.add(resultado);
                        convertir.gaurdarArchivoJson(resultado, "conversion_moneda.json");
                    }
                    case 2 -> {
                        System.out.print("Ingrese la cantidad a convertir: ");
                        var cantidad = scan.nextDouble();
                        conversion resultado = realizarConversion("COP", "USD", cantidad, serviceConversion, convertir);
                        System.out.println(resultado);
                        conversiones.add(resultado);
                        convertir.gaurdarArchivoJson(resultado, "conversion_moneda.json");
                    }
                    case 3 -> {
                        System.out.print("Ingrese la cantidad a convertir: ");
                        var cantidad = scan.nextDouble();
                        conversion resultado = realizarConversion("USD", "BRL", cantidad, serviceConversion, convertir);
                        System.out.println(resultado);
                        conversiones.add(resultado);
                        convertir.gaurdarArchivoJson(resultado, "conversion_moneda.json");
                    }
                    case 4 -> {
                        System.out.print("Ingrese la cantidad a convertir: ");
                        var cantidad = scan.nextDouble();
                        conversion resultado = realizarConversion("BRL", "USD", cantidad, serviceConversion, convertir);
                        System.out.println(resultado);
                        conversiones.add(resultado);
                        convertir.gaurdarArchivoJson(resultado, "conversion_moneda.json");
                    }
                    case 5 -> {
                        System.out.print("Ingrese la cantidad a convertir: ");
                        var cantidad = scan.nextDouble();
                        conversion resultado = realizarConversion("USD", "ARS", cantidad, serviceConversion, convertir);
                        System.out.println(resultado);
                        conversiones.add(resultado);
                        convertir.gaurdarArchivoJson(resultado, "conversion_moneda.json");
                    }
                    case 6 -> {
                        System.out.print("Ingrese la cantidad a convertir: ");
                        var cantidad = scan.nextDouble();
                        conversion resultado = realizarConversion("ARS", "USD", cantidad, serviceConversion, convertir);
                        System.out.println(resultado.toString());
                        conversiones.add(resultado);
                        convertir.gaurdarArchivoJson(resultado, "conversion_moneda.json");
                    }
                    default -> {
                        System.out.println("Error, intenta nuevamente");
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static conversion realizarConversion(
            String monedaBase,
            String monedaDestino,
            double cantidad,
            serviceConversion service,
            convertirGson gson) throws IOException, InterruptedException {

        String json = service.convertirMoneda(monedaBase, monedaDestino, cantidad);
        conversionDTO dto = gson.convertirJson(json);

        return new conversion(dto.base_code(), dto.target_code(), cantidad, dto.conversion_result());
    }

}