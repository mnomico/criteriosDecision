package modelo;

import java.util.ArrayList;
import java.util.List;

public class MatrizBeneficios {
    private final double[][] tabla;
    private final List<String> listaAlternativas;
    private final List<String> listaEstados;

    public MatrizBeneficios(int alternativas, int estados) {
        tabla = new double[alternativas][estados];
        listaAlternativas = new ArrayList<>();
        listaEstados = new ArrayList<>();
    }

    public double getValor(int decision, int estado) {
        return tabla[decision][estado];
    }

    public void setValor(int decision, int estado, double valor) {
        tabla[decision][estado] = valor;
    }

    public String getDecision(int decision) {
        return listaAlternativas.get(decision);
    }

    public void setDecision(int decision, String nombreDecision) {
        listaAlternativas.set(decision, nombreDecision);
    }

    public String getEstado(int estado) {
        return listaEstados.get(estado);
    }

    public void setEstado(int estado, String nombreEstado) {
        listaEstados.set(estado, nombreEstado);
    }

    public int getCantidadAlternativas() {
        return tabla.length;
    }

    public int getCantidadEstados() {
        return tabla[0].length;
    }

}
