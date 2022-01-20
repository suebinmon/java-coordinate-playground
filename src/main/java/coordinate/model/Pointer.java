package coordinate.model;

import java.util.Objects;

public class Pointer {

    public static final int LOWER_LIMIT = 1;
    public static final int UPPER_LIMIT = 24;
    private final int x;
    private final int y;

    public Pointer(int x, int y) {
        checkRangeOf(x, y);
        this.x=x;
        this.y=y;
    }

    private void checkRangeOf(int x, int y) {
        if (outOfRange(x) || outOfRange(y)) {
            throw new IllegalArgumentException("잘못된 범위입니다.");
        }
    }

    private boolean outOfRange(int coordinate) {
        return coordinate < LOWER_LIMIT || coordinate > UPPER_LIMIT;
    }


    public double calculateDistance(Pointer pointer) {
        return Math.sqrt( squareDifference(this.x , pointer.x)
                        + squareDifference(this.y , pointer.y));
    }

    private double squareDifference(int firstValue, int secondValue) {
        return Math.pow(firstValue-secondValue, 2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pointer pointer = (Pointer) o;
        return x == pointer.x && y == pointer.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "coordinate.model.Pointer{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
