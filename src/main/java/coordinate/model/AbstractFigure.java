package coordinate.model;

import java.util.List;
import java.util.Objects;

public abstract class AbstractFigure implements Figure{

    static final String ERROR_FIGURE_NULL = "올바른 Point 값이 아닙니다.";
    private final List<Pointer> points;

    AbstractFigure(List<Pointer> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException(ERROR_FIGURE_NULL);
        }
        this.points = points;
    }
    public List<Pointer> getPoints() {
        return points;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

}
