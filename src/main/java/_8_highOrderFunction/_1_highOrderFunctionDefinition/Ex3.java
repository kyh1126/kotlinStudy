package _8_highOrderFunction._1_highOrderFunctionDefinition;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

import java.util.ArrayList;
import java.util.List;

import static _8_highOrderFunction._1_highOrderFunctionDefinition.FunctionTypeUsageInJavaEx3Kt.processTheAnswer;

public class Ex3 {
    public static void main(String[] args) {
        processTheAnswer(number -> number + 1);

        // 자바 8 이전에서는 필요한 FunctionN 인터페이스의 invoke 메소드를 구현하는 무명 클래스를 넘기면 된다.
        processTheAnswer(
                // 인자가 하나인 함수
                new Function1<Integer, Integer>() {
                    @Override
                    public Integer invoke(Integer number) {
//                        System.out.println(number);
                        return number + 1;
                    }
                }
        );

        // 자바에서 코틀린 표준 라이브러리가 제공하는 람다를 인자로 받는 확장 함수를 쉽게 호출할 수 있다.
        // 하지만 수신 객체를 확장 함수의 첫 번째 인자로 명시적으로 넘겨야 하므로 코틀린에서 확장 함수를 호출할 때처럼 코드가 깔끔하지는 않다.
        List<String> strings = new ArrayList();
        strings.add("42");
        // strings 는 확장 함수의 수신 객체
        CollectionsKt.forEach(strings, s -> {
            System.out.println(s);
            // Unit 타입의 값을 명시적으로 반환해야만 한다.
            return Unit.INSTANCE;
        });
    }
}
