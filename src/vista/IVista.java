package vista;

import java.util.ArrayList;

public interface IVista {

    void mostrarMensaje(String mensaje);

    void mostrarAnterior();

    void mostrarSiguiente();

    String getVentanaActual();

    /// Métodos de Ventanas

    // Métodos de VentanaInicio

    String getAlternativasVentanaInicio();

    String getEstadosVentanaInicio();

    // Métodos de VentanaMatriz

    void armarMatrizVentanaMatriz(int alternativas, int estados);

    double[][] retornarValoresMatrizVentanaMatriz() throws NumberFormatException;

    // Métodos de VentanaCriterios

    void mostrarCriterios(ArrayList<String> criterios);

    ArrayList<String> retornarCriteriosSeleccionados();

}
