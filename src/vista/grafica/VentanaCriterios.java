package vista.grafica;

import modelo.criterios.ListaCriterios;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaCriterios extends JPanel {
    private JLabel lblTitulo, lblDescripcion;
    private boolean creado = false;

    public void mostrarCriterios(ArrayList<String> criterios) {
        if (creado) {
            return;
        }

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        lblTitulo = new JLabel("Selección de criterios", JLabel.CENTER);
        lblTitulo.setFont(new Font("Courier", Font.BOLD, 18));
        add(lblTitulo);

        lblDescripcion = new JLabel("Seleccione los criterios a calcular:");
        lblDescripcion.setFont(new Font("Arial", Font.BOLD, 15));
        add(lblDescripcion);

        for (String criterio : criterios) {
            add(new JCheckBox(criterio));
        }

        creado = true;
    }

    public ArrayList<String> retornarCriteriosSeleccionados() {
        ArrayList<String> criteriosSeleccionados = new ArrayList<>();
        for (Component componente : getComponents()) {
            if (componente instanceof JCheckBox && ((JCheckBox) componente).isSelected()) {
                criteriosSeleccionados.add(((JCheckBox) componente).getText());
            }
        }
        return criteriosSeleccionados;
    }
}
