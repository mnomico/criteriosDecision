package modelo;

import modelo.criterios.ICriterio;
import java.util.List;

public class ModeloDecision {
    private TablaDatos tablaDatos;
    private List<ICriterio> listaCriterios;

    public void definirTamanioTabla(int decisiones, int estados){
        tablaDatos = new TablaDatos(decisiones, estados);

    }

    public void actualizarDato(int decision, int estado, double valor) {
        tablaDatos.setValor(decision, estado, valor);
    }

    public void actualizarDecision(int decision, String nombreDecision) {
        tablaDatos.setDecision(decision, nombreDecision);
    }

    public void actualizarEstado(int estado, String nombreEstado) {
        tablaDatos.setEstado(estado, nombreEstado);
    }

    public List<ICriterio> calcularCriterios(List<ICriterio> criteriosElegidos) {
        for (ICriterio criterio : criteriosElegidos) {
            criterio.calcularDecision(tablaDatos);
        }
        return criteriosElegidos;
    }

}
