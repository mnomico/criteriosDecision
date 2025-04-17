package modelo.criterios;

import modelo.MatrizBeneficios;

public class Hurwicz implements ICriterio {
    private final double alfa;
    private double[] indicadores;
    private int mejorAlternativa;

    public Hurwicz(double alfa) {
        this.alfa = alfa;
    }

    public Hurwicz() {
        this.alfa = 0.5;
    }

    public void calcularAlternativa(MatrizBeneficios matrizBeneficios) {
        int alternativas = matrizBeneficios.getCantidadAlternativas();
        int estados = matrizBeneficios.getCantidadEstados();
        indicadores = new double[alternativas];
        for (int i = 0; i < alternativas; i++) {
            double maximo = matrizBeneficios.getValor(i, 0);
            double minimo = maximo;
            for (int j = 1; j < estados; j++) {
                double valorActual = matrizBeneficios.getValor(i, j);
                if (valorActual < minimo) {
                    minimo = valorActual;
                } else if (valorActual > maximo) {
                    maximo = valorActual;
                }
            }
            indicadores[i] = (alfa * maximo) + (1 - alfa) * minimo;
        }

        double maximo = indicadores[0];
        mejorAlternativa = 0;
        for (int i = 1; i < indicadores.length; i++) {
            if (indicadores[i] > maximo) {
                maximo = indicadores[i];
                mejorAlternativa = i;
            }
        }

    }

    public Object getIndicadores() {
        return indicadores;
    }

    public String toString() {
        return "Hurwicz";
    }
}
