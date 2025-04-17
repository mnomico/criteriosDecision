package vista.grafica;

import javax.swing.*;
import java.awt.*;

public class VentanaInicio extends JPanel {
    private JTextField tfAlternativas, tfEstados;
    private JLabel lblTitulo, lblDescripcion, lblAlternativas, lblEstados;
    private JLabel lblImagen;
    private JPanel filaAlternativas, filaEstados;

    public VentanaInicio() {
        setLayout(new BorderLayout(10, 10));

        lblTitulo = new JLabel("Decisión bajo Incertidumbre", JLabel.CENTER);
        lblTitulo.setFont(new Font("Courier", Font.BOLD, 18));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel para los campos de alternativas y estados
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));

        lblDescripcion = new JLabel(
                "<html><div style='width:300px; text-align: justify;'>"
                        + "Para poder calcular las mejores alternativas, primero debe especificar la cantidad de alternativas y de estados de la naturaleza. "
                        + "Luego deberá completar la matriz de beneficios y por último podrá especificar bajo cuáles criterios se resolverá el problema."
                        + "</div></html>"
        );
        lblDescripcion.setFont(new Font("Arial", Font.BOLD, 15));
        panelCentral.add(lblDescripcion);
        panelCentral.add(Box.createVerticalStrut(30));

        // Fila de alternativas
        filaAlternativas = new JPanel();
        filaAlternativas.setLayout(new FlowLayout(FlowLayout.CENTER));
        lblAlternativas = new JLabel("Cantidad de alternativas: ");
        tfAlternativas = new JTextField(10);
        tfAlternativas.setMaximumSize(new Dimension(150, tfAlternativas.getPreferredSize().height));
        filaAlternativas.add(lblAlternativas);
        filaAlternativas.add(tfAlternativas);

        // Fila de estados
        filaEstados = new JPanel();
        filaEstados.setLayout(new FlowLayout(FlowLayout.CENTER));
        lblEstados = new JLabel("Cantidad de estados: ");
        tfEstados = new JTextField(10);
        tfEstados.setMaximumSize(new Dimension(150, tfEstados.getPreferredSize().height));
        filaEstados.add(lblEstados);
        filaEstados.add(tfEstados);

        // Agregar las filas al panel central
        panelCentral.add(filaAlternativas);
        panelCentral.add(Box.createVerticalStrut(10)); // Espacio entre los campos
        panelCentral.add(filaEstados);

        // Añadir el panel central al centro de la ventana
        add(panelCentral, BorderLayout.CENTER);

        // Configuración de la ventana
        setPreferredSize(new Dimension(400, 300)); // Tamaño preferido
        setVisible(true);
    }

    public String getAlternativas() {
        return tfAlternativas.getText();
    }

    public String getEstados() {
        return tfEstados.getText();
    }

}
