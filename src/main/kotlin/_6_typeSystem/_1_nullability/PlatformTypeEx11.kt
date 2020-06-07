package _6_typeSystem._1_nullability

// A public function/method returning an expression of a platform type must declare its Kotlin type explicitly
//fun apiCall(): String = MyJavaApi.getProperty("name")

// Any property (package-level or class-level) initialised with an expression of a platform type must declare its Kotlin type explicitly
//class Person {
//    val name: String = MyJavaApi.getProperty("name")
//}

fun yellAtSafe(person: JavaPerson) {
    println((person.name ?: "Anyone").toUpperCase() + "!!!")
}

fun main(args: Array<String>) {
    // A local value initialized with an expression of a platform type may or may not have a type declaration
//    val name = MyJavaApi.getProperty("name")
//    println(name)

    // 자바 코드에서 가져온 타입만 플랫폼 타입이 된다.

    yellAtSafe(JavaPerson(null))
}