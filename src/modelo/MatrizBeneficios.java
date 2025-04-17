package modelo;

import java.util.ArrayList;
import java.util.List;

public class MatrizBeneficios {
    private double[][] matriz;
    private final List<String> listaAlternativas;
    private final List<String> listaEstados;

    public MatrizBeneficios(int alternativas, int estados) {
        matriz = new double[alternativas][estados];
        listaAlternativas = new ArrayList<>();
        listaEstados = new ArrayList<>();
    }

    public double getValor(int decision, int estado) {
        return matriz[decision][estado];
    }

    public void setValor(int decision, int estado, double valor) {
        matriz[decision][estado] = valor;
    }

    public void setMatriz(double[][] datos) throws Exception {
        int alternativas = getCantidadAlternativas();
        int estados = getCantidadEstados();
        if (alternativas == datos.length && estados == datos[0].length) {
            matriz = datos;
        } else {
            throw new Exception("El tamaño de la matriz recibida no coincide.\n" +
                    "Alternativas definidas: " + alternativas + "; Alternativas recibidas: " + datos.length + "\n" +
                    "Estados definidos: " + estados + "; Estados recibidos: " + datos[0].length);
        }
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
        return matriz.length;
    }

    public int getCantidadEstados() {
        return matriz[0].length;
    }

}
