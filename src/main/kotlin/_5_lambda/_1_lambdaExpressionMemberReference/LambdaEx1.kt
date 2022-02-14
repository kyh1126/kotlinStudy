package _5_lambda._1_lambdaExpressionMemberReference

fun main() {
    // 코틀린 람다식은 항상 중괄호로 둘러싸여 있고, 인자 목록 주변에 괄호가 없다.
    val people = listOf(Person("Kevin", 22), Person("Alice", 32), Person("Jenny", 31))
    println(people.filter { it.age < 32 }.maxByOrNull { it.age })

    // 람다 식 직접 호출
    val sum1 = { x: Int, y: Int -> x + y }
    println(sum1(2, 3))

    // run 은 코드의 일부분을 블록으로 둘러싸 람다 식 실행
    run { println(sum1(2, 3)) }

    // 정식 람다 식
    println(people.maxByOrNull({ p: Person -> p.age }))
    // 괄호 뒤에 람다를 둘 수 있다.
    println(people.maxByOrNull() { p: Person -> p.age })
    // 람다가 어떤 함수의 유일한 인자이고 괄호 뒤에 람다를 썼다면 호출 시 빈 괄호를 없애도 된다.
    println(people.maxByOrNull { p: Person -> p.age })
    // 람다 파라미터 타입 제거하기
    println(people.maxByOrNull { p -> p.age })
    // 디폴트 이름인 it 으로 바꾸기
    // 람다 안에 람다가 중첩되는 경우 각 람다의 파라미터를 명시하는 편이 낫다.
    // 각각의 it이 어떤 람다에 속헀는지 파악하기 어려울수 있기 때문이다.
    println(people.maxByOrNull { it.age })

    println(people.joinToString(separator = " ", transform = { p: Person -> p.name }))
    // 함수를 괄호 밖으로 뺀 모습
    println(people.joinToString(" ") { p: Person -> p.name })

    val sum2 = { x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }
    println(sum2(1, 2))
}
