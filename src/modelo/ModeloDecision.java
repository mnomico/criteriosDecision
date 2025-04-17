package modelo;

import modelo.criterios.ICriterio;
import modelo.criterios.ListaCriterios;

import java.util.ArrayList;

public class ModeloDecision implements IModeloDecision {
    private MatrizBeneficios matrizBeneficios;
    private ArrayList<ICriterio> criteriosCalculados;

    public void definirTamanioMatriz(int alternativas, int estados){
        if (matrizBeneficios != null
            && matrizBeneficios.getCantidadAlternativas() == alternativas
            && matrizBeneficios.getCantidadEstados() == estados)
        {
            return;
        }
        matrizBeneficios = new MatrizBeneficios(alternativas, estados);
    }

    public void cargarMatriz(double[][] datos) throws Exception {
        matrizBeneficios.setMatriz(datos);
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

    public ArrayList<String> getCriterios() {
        ArrayList<String> criterios = new ArrayList<>();
        for (ICriterio criterio : ListaCriterios.getCriterios()) {
            criterios.add(criterio.toString());
        }
        return criterios;
    }

    public void calcularCriterios(ArrayList<String> criteriosSeleccionados) throws Exception {
        criteriosCalculados = new ArrayList<>();
        for (String criterio : criteriosSeleccionados) {
            ICriterio iCriterio = ListaCriterios.buscarCriterio(criterio);
            if (iCriterio == null) {
                throw new Exception("Criterio no encontrado: " + criterio);
            }
            iCriterio.calcularAlternativa(matrizBeneficios);
            criteriosCalculados.add(iCriterio);
        }
    }

}
