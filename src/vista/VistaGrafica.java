package vista;

import controlador.Controlador;
import modelo.criterios.ICriterio;
import vista.grafica.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaGrafica extends JFrame implements IVista {
    private Controlador controlador;

    private CardLayout cardLayout;
    private JPanel panelContenedor;
    private JPanel panelBotones;
    private JButton botonAnterior;
    private JButton botonSiguiente;

    public VentanaInicio ventanaInicio;
    public VentanaMatriz ventanaMatriz;
    public VentanaCriterios ventanaCriterios;
    public VentanaResultados ventanaResultados;

    public VistaGrafica(Controlador controlador) {
        this.controlador = controlador;

        setTitle("Decisión bajo Incertidumbre");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);

        ventanaInicio = new VentanaInicio();
        ventanaMatriz = new VentanaMatriz();
        ventanaCriterios = new VentanaCriterios();
        ventanaResultados = new VentanaResultados();

        panelContenedor.add(ventanaInicio, "inicio");
        panelContenedor.add(ventanaMatriz, "matriz");
        panelContenedor.add(ventanaCriterios, "criterios");
        panelContenedor.add(ventanaResultados, "resultados");

        ventanaInicio.setName("inicio");
        ventanaMatriz.setName("matriz");
        ventanaCriterios.setName("criterios");
        ventanaResultados.setName("resultados");

        botonAnterior = new JButton("Anterior");
        botonSiguiente = new JButton("Siguiente");

        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(botonAnterior);
        panelBotones.add(botonSiguiente);

        add(panelContenedor, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        botonAnterior.addActionListener(e -> {
            if (controlador != null) {
                controlador.procesarAnteriorVentana();
            }
        });

        botonSiguiente.addActionListener(e -> {
            if (controlador != null) {
                controlador.procesarSiguienteVentana();
            }
        });

        setMinimumSize(new Dimension(400, 300));
        setResizable(true);
        setVisible(true);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void mostrarAnterior() {
        cardLayout.previous(panelContenedor);
    }

    public void mostrarSiguiente() {
        cardLayout.next(panelContenedor);
    }

    public String getVentanaActual() {
        for (Component c : panelContenedor.getComponents()) {
            if (c.isVisible()) {
                 return c.getName();
            }
        }
        return null;
    }

    /// Métodos de Ventanas

    // Métodos de VentanaInicio

    public String getAlternativasVentanaInicio() {
        return ventanaInicio.getAlternativas();
    }

    public String getEstadosVentanaInicio() {
        return ventanaInicio.getEstados();
    }

    // Métodos de VentanaMatriz

    public void armarMatrizVentanaMatriz(int alternativas, int estados) {
        ventanaMatriz.armarMatriz(alternativas, estados);
    }

    public double[][] retornarValoresMatrizVentanaMatriz() throws NumberFormatException {
        return ventanaMatriz.retornarValoresMatriz();
    }

    // Métodos de VentanaCriterios

    public void mostrarCriterios(ArrayList<String> criterios) {
        ventanaCriterios.mostrarCriterios(criterios);
    }

    public ArrayList<String> retornarCriteriosSeleccionados() {
        return ventanaCriterios.retornarCriteriosSeleccionados();
    }

}
