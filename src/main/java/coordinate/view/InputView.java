package coordinate.view;

import coordinate.model.Figure;
import coordinate.model.FigureFactory;
import coordinate.model.Pointer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    public static final String ERROR_INVALID_COORDINATES = "올바르지 않은 입력값입니다.";

    public static Figure inputCoordinates(){
        System.out.println("좌표를 입력하세요");

        return inputCoordinates(sc.nextLine());
    }

    private static Figure inputCoordinates(String input) {
        try{
            checkAccuracyOfPoints(input);
            List<Pointer> pointers = generatorPointers(input);
            return FigureFactory.create(pointers);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputCoordinates();
        }
    }

    private static List<Pointer> generatorPointers(String input) {
        String[] inputPoints = input.split("-");
        List<Pointer> pointers = new ArrayList<>();
        for (String inputPoint : inputPoints) {
            pointers.add(generatePointer(inputPoint));
        }
        return pointers;
    }

    private static Pointer generatePointer(String inputPoint) {
        Pattern compile = Pattern.compile("\\(([0-9]{1,2}),([0-9]{1,2})\\)");
        Matcher matcher = compile.matcher(inputPoint);
        if(matcher.find()){
            int x = Integer.valueOf(matcher.group(1));
            int y = Integer.valueOf(matcher.group(2));
            return new Pointer(x, y);
        }
        throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
    }

    private static void checkAccuracyOfPoints(String input) {
        Pattern compile = Pattern.compile("(\\([0-9]{1,2},[0-9]{1,2}\\))(-\\([0-9]{1,2},[0-9]{1,2}\\)){0,3}");
        if(!compile.matcher(input).matches()){
            throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
        }
    }

}
