package modelo.criterios;

import modelo.MatrizBeneficios;

public class Maximin implements ICriterio {
    private double indicadores[];
    private int mejorAlternativa;

    public int calcularAlternativa(MatrizBeneficios matrizBeneficios) {
        int alternativas = matrizBeneficios.getCantidadAlternativas();
        int estados = matrizBeneficios.getCantidadEstados();
        indicadores = new double[alternativas];
        for (int i = 0; i < alternativas; i++) {
            double minimo = matrizBeneficios.getValor(i, 0);
            for (int j = 1; j < estados; j++) {
                double valorActual = matrizBeneficios.getValor(i, j);
                if (valorActual < minimo) {
                    minimo = valorActual;
                }
            }
            indicadores[i] = minimo;
        }

        double maximo = indicadores[0];
        mejorAlternativa = 0;
        for (int i = 1; i < indicadores.length; i++) {
            if (indicadores[i] > maximo) {
                maximo = indicadores[i];
                mejorAlternativa = i;
            }
        }

        return mejorAlternativa;
    }

    public Object getIndicadores() {
        return indicadores;
    }

    public String toString() {
        return "Maximin";
    }
}
