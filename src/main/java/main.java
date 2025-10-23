
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
public class main {


    //til opgave 2
    static void forEachString (List<String> listOfStrings, Consumer<String> consumer){
        listOfStrings.forEach(consumer);
    }

    static <T> void forEach(List<T> lst, Consumer<T> consumer){
        for (T t : lst) {
            consumer.accept(t);
        }
    }

    public static void main(String[] args) {


        //Opgave 1
        Consumer<String> toUpper = x -> System.out.println(x.toUpperCase());
        toUpper.accept("Viggo");

        Consumer<Long> square = t -> System.out.println(t*t);
        square.accept(50l);


        //Opgave 2
        List<String> lstStr = Arrays.asList("hej", "du", "der");
        forEachString(lstStr, toUpper);

        List<Integer> lstInt = Arrays.asList(1,2,3,4,5,65,67);

        forEach(lstStr,toUpper);





    }




}
