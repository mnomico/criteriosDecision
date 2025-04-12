package modelo;

import java.util.ArrayList;
import java.util.List;

public class TablaDatos {
    private final double[][] tabla;
    private final List<String> listaDecisiones;
    private final List<String> listaEstados;

    public TablaDatos(int decisiones, int estados) {
        tabla = new double[decisiones][estados];
        listaDecisiones = new ArrayList<>();
        listaEstados = new ArrayList<>();
    }

    public double getValor(int decision, int estado) {
        return tabla[decision][estado];
    }

    public void setValor(int decision, int estado, double valor) {
        tabla[decision][estado] = valor;
    }

    public String getDecision(int decision) {
        return listaDecisiones.get(decision);
    }

    public void setDecision(int decision, String nombreDecision) {
        listaDecisiones.set(decision, nombreDecision);
    }

    public String getEstado(int estado) {
        return listaEstados.get(estado);
    }

    public void setEstado(int estado, String nombreEstado) {
        listaEstados.set(estado, nombreEstado);
    }

    public int getCantidadDecisiones() {
        return tabla.length;
    }

    public int getCantidadEstados() {
        return tabla[0].length;
    }

}
