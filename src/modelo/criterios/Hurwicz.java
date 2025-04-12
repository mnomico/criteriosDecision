package modelo.criterios;

import modelo.TablaDatos;

public class Hurwicz implements ICriterio {
    private final double alfa;

    public Hurwicz(double alfa) {
        this.alfa = alfa;
    }

    public Hurwicz() {
        this.alfa = 0.5;
    }

    public void calcularDecision(TablaDatos tablaDatos) {
        // TODO implementación
    }

    public String toString() {
        return "Hurwicz";
    }
}
