package _5_lambda._1_lambdaExpressionMemberReference;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Kevin", 22));
        people.add(new Person("Alice", 32));
        people.add(new Person("Jenny", 33));

        List<String> results = people.stream()
//            .map((Person p) -> p.getName())
//            .map(p -> p.getName())
            .map(Person::getName)
            .collect(Collectors.toList());

        System.out.println(results);
    }
}
