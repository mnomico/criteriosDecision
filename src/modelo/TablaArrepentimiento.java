package modelo;

public class TablaArrepentimiento {
    private final double tablaArrepentimiento[][];

    public TablaArrepentimiento(MatrizBeneficios datos) {
        int alternativas = datos.getCantidadAlternativas();
        int estados = datos.getCantidadEstados();
        tablaArrepentimiento = new double[alternativas][estados];

        for (int i = 0; i < estados; i++) {
            double maximoBeneficio = datos.getValor(0, i);
            for (int j = 1; j < alternativas; j++) {
                double valorActual = datos.getValor(j, i);
                if (valorActual > maximoBeneficio) {
                    maximoBeneficio = valorActual;
                }
            }

            for (int j = 0; j < alternativas; j++) {
                double valorOriginal = datos.getValor(j, i);
                tablaArrepentimiento[j][i] = valorOriginal - maximoBeneficio;
            }
        }
    }

    public double getValor(int alternativa, int estado) {
        return tablaArrepentimiento[alternativa][estado];
    }

}
