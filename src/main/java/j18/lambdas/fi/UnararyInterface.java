package j18.lambdas.fi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnararyInterface {

    public void evaluateSquare(List<Integer> numList) {
	// evaluate square
	// add element in the new list
	List<Integer> squareList = new ArrayList<>();
	UnaryOperator<Integer> square = i -> i^2;
	numList.forEach(i -> squareList.add(square.apply(i)));
	numList.forEach(i -> System.out.println(i*i));
	//squareList.forEach(System.out::println);
    }
    
    public static void main(String[] args) {
	UnararyInterface app = new UnararyInterface();
	List<Integer> numList = Arrays.asList(10,20,30,40);
	app.evaluateSquare(numList);
    }
    
    

}
