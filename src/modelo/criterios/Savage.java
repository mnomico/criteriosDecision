package modelo.criterios;

import modelo.TablaArrepentimiento;
import modelo.MatrizBeneficios;

public class Savage implements ICriterio {
    private TablaArrepentimiento tablaArrepentimiento;
    private double[] indicadores;
    private int mejorAlternativa;

    public int calcularAlternativa(MatrizBeneficios matrizBeneficios) {
        tablaArrepentimiento = new TablaArrepentimiento(matrizBeneficios);
        int alternativas = matrizBeneficios.getCantidadAlternativas();
        int estados = matrizBeneficios.getCantidadEstados();
        indicadores = new double[alternativas];
        for (int i = 0; i < alternativas; i++) {
            double maximo = tablaArrepentimiento.getValor(i, 0);
            for (int j = 1; j < estados; j++) {
                double valorActual = tablaArrepentimiento.getValor(i, j);
                if (valorActual > maximo) {
                    maximo = valorActual;
                }
            }
            indicadores[i] = maximo;
        }

        double minimo = indicadores[0];
        mejorAlternativa = 0;
        for (int i = 1; i < alternativas; i++) {
            double valorActual = indicadores[i];
            if (valorActual < minimo) {
                minimo = valorActual;
                mejorAlternativa = i;
            }
        }

        return mejorAlternativa;
    }

    public Object getIndicadores() {
        return indicadores;
    }

    public String toString() {
        return "Savage";
    }
}
