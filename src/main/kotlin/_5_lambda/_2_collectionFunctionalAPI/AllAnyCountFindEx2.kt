package _5_lambda._2_collectionFunctionalAPI

import _5_lambda._1_lambdaExpressionMemberReference.Person

fun main(args: Array<String>) {
    // all, any : 컬렉션의 모든, 어떤 원소가 조건을 만족하는지 판단
    // count : 조건을 만족하는 원소의 개수 반환
    // find : 조건을 만족하는 첫 번째 원소 반환
    val canBeInClub27 = { p: Person -> p.age <= 27 }

    val people = listOf(Person("Kevin", 22), Person("Alice", 20), Person("Jenny", 31), Person("Max", 40))

    println("all: ${people.all(canBeInClub27)}")
    println("any: ${people.any(canBeInClub27)}")

    // size 를 하면 조건을 만족하는 원소를 따로 저장하는 중간 컬렉션이 생긴다?
    // count 가 훨씬 더 효율적이다?
    println(people.filter(canBeInClub27).size)
    println(people.count(canBeInClub27))

    println(people.find(canBeInClub27))

    val canBeInClub17 = { p: Person -> p.age <= 17 }
    // 만족하는 원소가 전혀 없는 경우 null 반환.
    println(people.find(canBeInClub17))
    // 만족하는 원소가 없으면 null 이 나온다는 사실을 더 명확히 하고 싶다면 firstOrNull 사용
    println(people.firstOrNull(canBeInClub17))
}