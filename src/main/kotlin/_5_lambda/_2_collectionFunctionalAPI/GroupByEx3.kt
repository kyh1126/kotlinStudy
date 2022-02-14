package _5_lambda._2_collectionFunctionalAPI

import _5_lambda._1_lambdaExpressionMemberReference.Person

fun main() {
    val people = listOf(Person("Alice", 20), Person("Jenny", 31), Person("Pi", 31))
    // 원소를 구분하는 특성이 키
    // 키 값에 따른 각 그룹이 값 인 맵
    println(people.groupBy { it.age })
    // 멤버 참조 버전
    println(people.groupBy(Person::age))
}
