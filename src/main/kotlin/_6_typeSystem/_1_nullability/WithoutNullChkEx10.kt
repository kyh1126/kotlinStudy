package _6_typeSystem._1_nullability

fun yellAt(person: JavaPerson) {
    // person.name is null, exception occurred.
    // IllegalStateException : In Kotlin function
    println(person.name.toUpperCase() + "!!!")
}

fun main(args: Array<String>) {
    yellAt(JavaPerson(null))
}