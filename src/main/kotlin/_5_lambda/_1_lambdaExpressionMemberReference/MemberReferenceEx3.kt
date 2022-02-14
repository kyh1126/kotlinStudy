package _5_lambda._1_lambdaExpressionMemberReference

import _5_lambda.topLevels.salute

fun sendEmail(person: Person, message: String) {
    println("${person.name}의 메일 전송, 내용: ${message}")
}

fun Person.isAdult() = age >= 21

fun main() {
    val people = listOf(Person("Kevin", 22), Person("Alice", 32), Person("Jenny", 31))

    val getAge = { person: Person -> person.age }

    println(people.maxByOrNull(getAge))
    // member reference
    println(people.maxByOrNull(Person::age))
    println(people.maxByOrNull { it.age })

    // can get a reference to top-level function, property
    run(::salute)

    // 다른 함수한테 작업 위임하기
    val action = { person: Person, message: String ->
        sendEmail(person, message)
    }
    action(Person("Jenny", 31), "메일 본문 내용")

    // 생성자 참조(constructor reference)
    val createPerson = ::Person
    val p = createPerson("Jenny", 31)
    println("constructor reference : $p")

    // 확장 함수도 멤버 함수와 같은 방식으로 참조할 수 있다.
    val predicate = Person::isAdult
    println("isAdult? ${predicate(p)}")

    // 바운드 멤버 참조
    // 멤버 참조를 생성할 때 클래스 인스턴스를 함께 저장한 다음 나중에 그 인스턴스에 대해 멤버를 호출해준다.
    // 호출 시 수신 대상 객체를 별도로 지정해 줄 필요가 없다.
    val predicate2 = p::isAdult
    println("bound member reference: isAdult? ${predicate2()}")
}
