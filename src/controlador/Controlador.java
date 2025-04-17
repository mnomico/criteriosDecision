package controlador;

import modelo.IModeloDecision;
import modelo.ModeloDecision;
import vista.IVista;
import vista.VistaGrafica;

import java.util.ArrayList;

public class Controlador {
    private IVista vista;
    private IModeloDecision modelo;

    public Controlador() {
        vista = new VistaGrafica(this);
        modelo = new ModeloDecision();
    }

    public void procesarAnteriorVentana() {
        String ventanaActual = vista.getVentanaActual();

        switch(ventanaActual) {
            case "matriz", "criterios", "resultados" :
                vista.mostrarAnterior();
                break;
        }
    }

    public void procesarSiguienteVentana() {
        String ventanaActual = vista.getVentanaActual();

        switch(ventanaActual) {
            case "inicio" :
                procesarVentanaInicio();
                break;
            case "matriz"  :
                procesarVentanaMatriz();
                break;
            case "criterios" :
                procesarVentanaCriterios();
                break;
            case "resultados" :
                procesarVentanaResultados();
                break;
        }

    }

    public void procesarVentanaInicio() {
        try {
            int alternativas = Integer.parseInt(vista.getAlternativasVentanaInicio());
            int estados = Integer.parseInt(vista.getEstadosVentanaInicio());
            if (alternativas < 1 || estados < 1) {
                vista.mostrarMensaje("Los valores deben ser mayores a 0.");
                return;
            }
            modelo.definirTamanioMatriz(alternativas, estados);
            vista.armarMatrizVentanaMatriz(alternativas, estados);
            vista.mostrarSiguiente();

        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Ingrese valores numéricos mayores a 0.");
        }
    }

    public void procesarVentanaMatriz() {
        try {
            double[][] matriz = vista.retornarValoresMatrizVentanaMatriz();
            modelo.cargarMatriz(matriz);
            vista.mostrarCriterios(modelo.getCriterios());
            vista.mostrarSiguiente();

        } catch (Exception e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    public void procesarVentanaCriterios() {
        ArrayList<String> criterios = vista.retornarCriteriosSeleccionados();
        if (criterios.isEmpty()) {
            vista.mostrarMensaje("No se ha seleccionado ningún criterio.");
        } else {
            try {
                modelo.calcularCriterios(criterios);
            } catch (Exception e) {
                vista.mostrarMensaje(e.getMessage());
            }
        }
        vista.mostrarSiguiente();
    }

    public void procesarVentanaResultados() {

    }

}
