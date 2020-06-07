package _8_highOrderFunction._1_highOrderFunctionDefinition

// 컴파일된 코드 안에서 함수 타입은 일반 인터페이스로 바뀐다.
// 함수 타입의 변수는 FunctionN 인터페이스를 구현하는 객체를 저장한다.
// 각 인터페이스에는 invoke 메소드 정의가 하나 들어있어 호출하면 함수를 실행할 수 있다.
// invoke 메소드 본문에는 람다의 본문이 들어간다.

// 자바에서도 자바 8 람다를 넘기면 자동으로 함수타입의 값으로 변환되어 쉽게 호출할 수 있다.
fun processTheAnswer(f: (Int) -> Int) {
    println(f(42))
}