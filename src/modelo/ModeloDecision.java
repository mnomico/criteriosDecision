package modelo;

import modelo.criterios.ICriterio;
import java.util.List;

public class ModeloDecision {
    private MatrizBeneficios matrizBeneficios;
    private List<ICriterio> listaCriterios;

    public void definirTamanioMatriz(int alternativas, int estados){
        if (matrizBeneficios != null
            && matrizBeneficios.getCantidadAlternativas() == alternativas
            && matrizBeneficios.getCantidadEstados() == estados)
        {
            return;
        }
        matrizBeneficios = new MatrizBeneficios(alternativas, estados);
    }

    }

    public void actualizarDato(int decision, int estado, double valor) {
        matrizBeneficios.setValor(decision, estado, valor);
    }

    public void actualizarDecision(int decision, String nombreDecision) {
        matrizBeneficios.setDecision(decision, nombreDecision);
    }

    public void actualizarEstado(int estado, String nombreEstado) {
        matrizBeneficios.setEstado(estado, nombreEstado);
    }

    public void calcularCriterios(List<ICriterio> criteriosElegidos) {
        for (ICriterio criterio : criteriosElegidos) {
            criterio.calcularAlternativa(matrizBeneficios);
        }
    }

}
