package modelo.criterios;

import modelo.TablaArrepentimiento;
import modelo.TablaDatos;

public class Savage implements ICriterio {
    private TablaArrepentimiento tablaArrepentimiento;

    public void calcularDecision(TablaDatos tablaDatos) {
        tablaArrepentimiento = new TablaArrepentimiento(tablaDatos);
        // TODO implementación
    }

    public String toString() {
        return "Savage";
    }
}
