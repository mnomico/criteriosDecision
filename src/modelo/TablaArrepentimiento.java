package modelo;

public class TablaArrepentimiento {
    private final double tabla[][];

    public TablaArrepentimiento(TablaDatos datos) {
        int filas = datos.getCantidadDecisiones();
        int columnas = datos.getCantidadEstados();
        tabla = new double[filas][columnas];

        // TODO cálculo de arrepentimiento

    }
}
