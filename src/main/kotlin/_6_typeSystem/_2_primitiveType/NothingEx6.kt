package _6_typeSystem._2_primitiveType

import _6_typeSystem._1_nullability.Company

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun main() {
    // Nothing : 아무 값도 포함하지 않는다. 함수의 반환 타입이나 반환 타입으로 쓰일 타입 파라미터로만 쓸 수 있다.
    // 엘비스 연산자의 우항에 사용해서 전제 조건을 검사할 수 있다.
    val address = Company("Kakao commerce", null).address ?: fail("No address")
    println(address.city)
}
