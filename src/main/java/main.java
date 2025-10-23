
import javax.sound.sampled.SourceDataLine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {



    public static void main(String[] args) {

//
//        //Opgave 1
//        Consumer<String> toUpper = x -> System.out.println(x.toUpperCase());
//        toUpper.accept("Viggo");
//
//        Consumer<Long> square = t -> System.out.println(t*t);
//        square.accept(50l);
//
//        Consumer<String> printWithStars = s -> System.out.println("***" + s + "***");
        Consumer<Integer> out = (Integer x) -> System.out.println(x);
//
//
//        //Opgave 2
//        List<String> lstStr = Arrays.asList("hej", "du", "der");
//        forEachString(lstStr, toUpper);
//
//
//
//        forEach(lstStr,printWithStars);
//        forEach(lstStr,toUpper);
//
//        List<Integer> lstInt = Arrays.asList(1,2,3,4,5,65,67);
//        lstInt.forEach(out);
//
//        //Opgave 3
//        ZeroOneTwoArgument.main.TwoArgument twoPlus = (x, y) -> x + y;
//        ZeroOneTwoArgument.main.TwoArgument twoMult = (x,y) -> x* y;
//
//        int pengeDk = valuteOmregner(lstInt, twoMult, 6);
//        System.out.println("du har dk= " + pengeDk );

        //opgave 4

        List<Soldier> soliders = new ArrayList<>();
        soliders.add(new Soldier(1,"Flemming"));
        soliders.add(new Soldier(1,"Carsten"));
        soliders.add(new Soldier(1,"Kino"));
        soliders.add(new Soldier(2,"Ygdrasssss"));
        soliders.add(new Soldier(2,"Nivhaarm"));
        soliders.add(new Soldier(3,"Kovan"));
        soliders.add(new Soldier(4,"Niels"));

        Predicate<Soldier> isHigherRanked = soldier -> soldier.getRank()>=2;

        Stream<Soldier> highRankedSoldiers = soliders.stream().filter(isHigherRanked);





        highRankedSoldiers.forEach(System.out::println);
        System.out.println("------------------");

        System.out.println("------------------");
        Predicate<Soldier> startsWithN = s -> s.getName().startsWith("N");
        Stream<Soldier> highAndNList = soliders.stream().filter(isHigherRanked).filter(startsWithN);
        Function<Soldier, String> getnames = soldier -> soldier.getName();

        List<String> namesListAsStrings = highAndNList.map(getnames).collect(Collectors.toList());

        System.out.println(namesListAsStrings + " navne som liste af Strings");
        System.out.println("__________________________________");

        List<String> namesListAsStringsConc = soliders.stream()
                .filter(s -> s.getRank()>=2)
                .map(Soldier::getName)
                .filter(name -> name.startsWith("N"))
                .collect(Collectors.toList());

        namesListAsStringsConc.forEach(s -> System.out.println(s + " Conc liste af navne som strings"));

        System.out.println("------------------");
        soliders.forEach(System.out::println);


    }


    //til opgave 2
    static void forEachString (List<String> listOfStrings, Consumer<String> consumer){
        listOfStrings.forEach(consumer);
    }

    static <T> void forEach(List<T> lst, Consumer<T> consumer){
        for (T t : lst) {
            consumer.accept(t);
        }
    }

    static int sumTwoArgFunction(List<Integer> list, ZeroOneTwoArgument.main.TwoArgument two){
        int sum = 0;
        for (int t : list) {
            sum += two.myFunc(t,t);
        }
        return sum;
    }

    static int valuteOmregner (List<Integer> list, ZeroOneTwoArgument.main.TwoArgument two, int kurs) {
        int sum = 0;
        for (int t : list){
            sum += two.myFunc(t, kurs);
        }
        return sum;
    }



}
