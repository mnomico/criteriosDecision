package vista.grafica;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaMatriz extends JPanel {
    private JTable matrizBeneficios;
    private DefaultTableModel modeloMatriz;
    private JScrollPane scrollPane;

    public void armarMatriz(int alternativas, int estados) {
        if (modeloMatriz != null
            && modeloMatriz.getRowCount() == alternativas + 1
            && modeloMatriz.getColumnCount() == estados + 1)
        {
            return;
        }

        if (scrollPane != null) {
            remove(scrollPane); // Elimina el JScrollPane antiguo
        }

        modeloMatriz = new DefaultTableModel(alternativas + 1, estados + 1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return row != 0 || column != 0;
            }
        };

        modeloMatriz.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // Este método se llama cuando una celda cambia
                int fila = e.getFirstRow();
                int columna = e.getColumn();
                modeloMatriz.getValueAt(fila, columna);
            }
        });

        for (int i = 1; i <= alternativas; i++) {
            modeloMatriz.setValueAt("Alternativa " + i, i, 0);
        }

        for (int j = 1; j <= estados; j++) {
            modeloMatriz.setValueAt("Estado " + j, 0, j);
        }

        matrizBeneficios = new JTable(modeloMatriz);
        matrizBeneficios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        matrizBeneficios.setRowHeight(40);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < matrizBeneficios.getColumnCount(); i++) {
            matrizBeneficios.getColumnModel().getColumn(i).setCellRenderer(renderer);
            matrizBeneficios.getColumnModel().getColumn(i).setMinWidth(100);
        }
        matrizBeneficios.setTableHeader(null);

        scrollPane = new JScrollPane(matrizBeneficios);
        scrollPane.setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.revalidate();
        scrollPane.repaint();
        revalidate();
        repaint();
    }

    public double[][] retornarValoresMatriz() throws NumberFormatException {
        int alternativas = modeloMatriz.getRowCount() - 1;
        int estados = modeloMatriz.getColumnCount() - 1;
        double[][] valoresMatriz = new double[alternativas][estados];

        for (int i = 1; i < alternativas + 1; i++) {
            for (int j = 1; j < estados + 1; j++) {
                Object valor = modeloMatriz.getValueAt(i, j);
                if (valor == null || valor.toString().isBlank()) {
                    throw new NumberFormatException("Dato inválido en la celda " + i + "," + j);
                }
                try {
                    valoresMatriz[i - 1][j - 1] = Double.parseDouble(valor.toString());
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Dato inválido en la celda " + i + "," + j);
                }
            }
        }
        return valoresMatriz;
    }

}
