package modelo.criterios;

import modelo.MatrizBeneficios;

public class Maximax implements ICriterio {
    private double indicadores[];
    private int alternativa;

    public int calcularDecision(MatrizBeneficios matrizBeneficios) {
        int alternativas = matrizBeneficios.getCantidadAlternativas();
        int estados = matrizBeneficios.getCantidadEstados();
        indicadores = new double[alternativas];
        for (int i = 0; i < alternativas; i++) {
            double maximo = matrizBeneficios.getValor(i, 0);
            for (int j = 1; j < estados; j++) {
                double valorActual = matrizBeneficios.getValor(i, j);
                if (valorActual > maximo) {
                    maximo = valorActual;
                }
            }
            indicadores[i] = maximo;
        }

        double maximo = indicadores[0];
        for (int i = 1; i < indicadores.length; i++) {
            if (indicadores[i] > maximo) {
                maximo = indicadores[i];
                alternativa = i;
            }
        }

        return alternativa;
    }

    public Object getIndicadores() {
        return indicadores;
    }

    public String toString() {
        return "Maximax";
    }
}
