package coordinate;

import coordinate.model.Figure;
import coordinate.view.InputView;

public class CoordinateMain {
    public static void main(String[] args) {
        Figure figure = InputView.inputCoordinates();
        System.out.println(figure.getAreaInfo());
    }
}
