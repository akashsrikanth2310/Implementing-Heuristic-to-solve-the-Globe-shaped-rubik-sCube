package Search;
import java.util.Comparator;

public class ComparerClass implements Comparator<Element_Graph> {

    @Override
    public int compare(Element_Graph first, Element_Graph second) {
        if (first.getTotalCost() < second.getTotalCost()) {
            return -1;
        }
        if (first.getTotalCost() > second.getTotalCost()) {
            return 1;
        }
        return 0;
    }
}

