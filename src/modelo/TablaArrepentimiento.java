package modelo;

public class TablaArrepentimiento {
    private final double tabla[][];

    public TablaArrepentimiento(MatrizBeneficios datos) {
        int filas = datos.getCantidadAlternativas();
        int columnas = datos.getCantidadEstados();
        tabla = new double[filas][columnas];

        // TODO cálculo de arrepentimiento

    }
}
