package modelo;

import java.util.ArrayList;

public interface IModeloDecision {
    void definirTamanioMatriz(int decisiones, int estados);

    void cargarMatriz(double[][] datos) throws Exception;

    void actualizarDato(int decision, int estado, double valor);

    void actualizarDecision(int decision, String nombreDecision);

    void actualizarEstado(int estado, String nombreEstado);

    ArrayList<String> getCriterios();

    void calcularCriterios(ArrayList<String> criteriosSeleccionados) throws Exception;
}
