package service;

import java.io.IOException;

/**
 * Servicio que implementa la conversión de las monedas
 */
public class serviceConversion {

    private final conexionApi conexion;

    /**
     * Constructor por defecto para inicializar una nueva conexión
     */
    public serviceConversion() {
        this.conexion = new conexionApi();
    }

    /**
     * @param conexion conexión a la API a utilizar
     */
    public serviceConversion(conexionApi conexion) {
        this.conexion = conexion;
    }

    /**
     * Obtiene la tasa de cambio para una moneda específica
     *
     * @param monedaBase Código de la moneda, (ej. USD, COP)
     * @return String con los datos de la tasa en formato JSON
     * @throws IOException          Si ocurre un error en la comunicación
     * @throws InterruptedException Sí se interrumpe la comunicación
     */
    public String obtenerTasa(String monedaBase) throws IOException, InterruptedException {
        return conexion.ApiGet("/latest/" + monedaBase);
    }

    /**
     * Obtiene la conversion de la moneda
     *
     * @param monedaBase    Código de la moneda base
     * @param monedaDestido Código de la moneda a destino
     * @param cantidad      Cantidad a convertir
     * @return String con las datos de la conversión de moneda
     * @throws IOException          Si ocurre un error en la comunicación
     * @throws InterruptedException Sí se interrumpe la comunicación
     */
    public String convertirMoneda(String monedaBase, String monedaDestido, double cantidad) throws IOException, InterruptedException {
        return conexion.ApiGet("/pair/" + monedaBase + "/" + monedaDestido + "/" + cantidad);
    }

}
