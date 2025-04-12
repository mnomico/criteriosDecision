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
}
