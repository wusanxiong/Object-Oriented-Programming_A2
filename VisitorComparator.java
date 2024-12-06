
import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        if (v1.isVIP() != v2.isVIP()) {
            return v2.isVIP() ? 1 : -1;
        }
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}
