package coordinate.model;

import java.util.List;

public class Line extends AbstractFigure{
    private static final String OUTPUT_AREA_OF_LINE = "두 점 사이의 거리는 %.6f";

    Line(List<Pointer> points) {
        super(points);
    }

    @Override
    public double getArea() {
        return getPoints().get(0).calculateDistance(getPoints().get(1));
    }

    @Override
    public String getName() {
        return "선";
    }

    @Override
    public String getAreaInfo() {
        return String.format(OUTPUT_AREA_OF_LINE, getArea());
    }

}
