package modelo.criterios;

import modelo.MatrizBeneficios;

public interface ICriterio {
    public void calcularDecision(TablaDatos tablaDatos);

    public String toString();
}
