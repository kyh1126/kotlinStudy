package _6_typeSystem._1_nullability

fun sendEmailTo(p: Person){
    println("### Send Complete")
}

fun verifyUserInput(input: String?) {
    // Doesn't need Safe call operator
    // isNullOrBlank : nullable type's extension function
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields")
    }
}

fun main(args: Array<String>) {
    verifyUserInput(" ")
    verifyUserInput(null)

    val person: Person? = Person("Jenny", Company("Kakao commerce", Address("Pangyo", 123, "Sungnam-si", "Korea")))
    // 코틀린에서는 널이 될 수 있는 타입의 확장 함수 안에서는 this 가 널이 될 수 있다. 그래서 이건 type mis match 오류
//    person.let{ sendEmailTo(it) }
    person?.let{ sendEmailTo(it) }
}