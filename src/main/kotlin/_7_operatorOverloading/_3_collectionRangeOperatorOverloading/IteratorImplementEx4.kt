package _7_operatorOverloading._3_collectionRangeOperatorOverloading

import java.time.LocalDate

// iterator 메소드를 확장 함수로 정의
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    // 이 객체는 LocalDate 원소에 대한 iterator 를 구현한다.
    object : Iterator<LocalDate> {
        var current = start
        override fun hasNext() =
            // compareTo 관례를 사용해 날짜를 비교한다.
            current <= endInclusive

        // 현재 날짜를 저장한 다음에 날짜를 변경한다. 그 후 저장해둔 날짜를 반환한다.
        override fun next() = current.apply {
            current = plusDays(1)
        }
    }

fun main(args: Array<String>) {
    val newYear = LocalDate.ofYearDay(2021, 1)
    val daysOff = newYear.minusDays(3)..newYear

    // Above iterator operator function returns the given iterator itself.
    // That allows to use an instance of iterator in a for loop.
    for (dayOff in daysOff) {
        println(dayOff)
    }
}