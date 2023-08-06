package collections;

import java.util.Comparator;

public class TestComparator implements Comparator<Student> {
    @Override
    public int compare(Student obj1, Student obj2) {
        if (obj1 == obj2) {
            return 0;
        }
        if (obj1 == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return obj1.getFirstName().compareTo(obj2.getFirstName());
    }
}
