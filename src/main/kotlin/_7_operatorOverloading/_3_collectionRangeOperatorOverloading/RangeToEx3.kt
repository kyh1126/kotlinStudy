package _7_operatorOverloading._3_collectionRangeOperatorOverloading

import java.time.LocalDate

// 7.1.1 Arithmetic operators 에 있다.
// 코틀린 표준 라이브러리에는 모든 Comparable 객체에 대해 적용 가능한 rangeTo 함수가 들어있다.
//operator fun <T : Comparable<T>> T.rangeTo(that: T): ClosedRange<T>

fun main(args: Array<String>) {
    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)
    // 날짜가 범위 안에 들어가는지 검사한다.
    println(now.plusWeeks(1) in vacation)

    val range = 0..8 + 1
    // rangeTo 연산자는 다른 산술 연산자보다 우선순위가 낮다.
    println("range: $range / 7 in range: ${7 in range}")

    // 범위 연산자는 우선순위가 낮아서 범위 메소듣 호출하려면 범위를 괄호로 둘러싸야 한다.
//    0..9.forEach { println(it) }
    range.forEach { println(it) }
}