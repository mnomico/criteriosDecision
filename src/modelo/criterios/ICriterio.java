package modelo.criterios;

import modelo.MatrizBeneficios;

public interface ICriterio {
   void calcularAlternativa(MatrizBeneficios matrizBeneficios);

   Object getIndicadores();

   String toString();
}
