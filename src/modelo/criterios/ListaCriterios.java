package modelo.criterios;
import java.util.List;

public class ListaCriterios {
    public static List<ICriterio> getCriterios() {
        return List.of(
            new Maximin(),
            new Maximax(),
            new Hurwicz(),
            new Savage()
        );
    }

    public static ICriterio buscarCriterio(String nombre) {
        for (ICriterio criterio : getCriterios()) {
            if (criterio.toString().equalsIgnoreCase(nombre)) {
                return criterio;
            }
        }
        return null;
    }
}
