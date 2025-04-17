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

    public void actualizarDato(int alternativa, int estado, double valor) {
        matrizBeneficios.setValor(alternativa, estado, valor);
    }

    public void actualizarDecision(int alternativa, String nombreDecision) {
        matrizBeneficios.setDecision(alternativa, nombreDecision);
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
