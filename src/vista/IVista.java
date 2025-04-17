package vista;

import java.util.ArrayList;

public interface IVista {

    public void mostrarMensaje(String mensaje);

    public void mostrarAnterior();

    public void mostrarSiguiente();

    public String getVentanaActual();

    /// Métodos de Ventanas

    // Métodos de VentanaInicio

    public String getAlternativasVentanaInicio();

    public String getEstadosVentanaInicio();

    // Métodos de VentanaMatriz

    public void armarMatrizVentanaMatriz(int alternativas, int estados);

    public double[][] retornarValoresMatrizVentanaMatriz() throws NumberFormatException;

    // Métodos de VentanaCriterios

    public void mostrarCriterios(ArrayList<String> criterios);

    public ArrayList<String> retornarCriteriosSeleccionados();

}
