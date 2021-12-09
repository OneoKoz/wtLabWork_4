package by.bsuir.kozyrev.specification;

import java.util.List;

public interface Specification {
    String toSql();

    List<Object> getParameters();
}
