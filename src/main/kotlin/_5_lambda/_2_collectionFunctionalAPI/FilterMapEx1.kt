package _5_lambda._2_collectionFunctionalAPI

import _5_lambda._1_lambdaExpressionMemberReference.Person

fun main() {
    val people = listOf(Person("Kevin", 22), Person("Alice", 32), Person("Jenny", 31))

    // filter : 람다가 true 를 반환하는 원소만 모은다.
    println(people.filter { it.age > 30 })

    // map : 주어진 람다를 컬렉션의 각 원소에 적용한 결과를 모아서 새 컬렉션을 만든다.
    println(people.map { it.age + 5 })
    // 멤버 참조 버전
    println(people.map(Person::name))


    // not-null assertion (!!) Operator
    // converts any value to a non-null type and throws an NPE if the value is null.
    println(people.filter { it.age == people.maxByOrNull(Person::age)!!.age })

    // 위와 같이 하면 people 이 100명이면 maxBy도 100번 한다. 아래로 하자
    val maxAge = people.maxByOrNull(Person::age)!!.age
    people.filter { it.age == maxAge }

    // 맵에 적용한 버전
    // (filterKeys, mapKeys) & (filterValues, mapValues)
    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })
}
