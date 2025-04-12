package modelo.criterios;

import modelo.TablaDatos;

public interface ICriterio {
    public void calcularDecision(TablaDatos tablaDatos);

    public String toString();
}
