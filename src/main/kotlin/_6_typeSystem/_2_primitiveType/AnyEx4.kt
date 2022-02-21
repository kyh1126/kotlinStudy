package _6_typeSystem._2_primitiveType

fun main() {
    // 자바에서 Object 가 클래스 계층의 최상위 타입이듯
    // 코틀린에서 Any 가 모든 null 이 될 수 없는 타입의 조상 타입이다.

    // 자동으로 값을 Any 참조 타입의 객체로 감싼다.
    var answer: Any = 42
//    answer = null

    // 이렇게 하면 null 도 포함 가능하다.
    var answer2: Any? = 42
    answer2 = null
}
