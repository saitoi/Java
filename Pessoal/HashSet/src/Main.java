import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();

        fruits.add("Banana");
        fruits.add("Maçã");
        fruits.add("Limão");
        fruits.add("Banana");

        for(String fruit : fruits) {
           System.out.println(fruit);
        }

    }
}