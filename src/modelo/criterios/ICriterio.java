package modelo.criterios;

import modelo.MatrizBeneficios;

public interface ICriterio {
    public int calcularAlternativa(MatrizBeneficios matrizBeneficios);

    public Object getIndicadores();

    public String toString();
}
