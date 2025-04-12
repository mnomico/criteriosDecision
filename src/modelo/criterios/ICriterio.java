package modelo.criterios;

import modelo.MatrizBeneficios;

public interface ICriterio {
    public int calcularDecision(MatrizBeneficios matrizBeneficios);

    public Object getIndicadores();

    public String toString();
}
