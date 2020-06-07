package _6_typeSystem._1_nullability

fun processNonNullString(s: String) {
    println(s)
}

fun main(args: Array<String>) {
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    // let can be used to invoke one or more functions on results of call chains.
    numbers.map { it.length }.filter { it > 3 }.let(::println)

    val str: String? = "Hello"
    //processNonNullString(str)       // compilation error: str can be null
    // let is often used for executing a code block only with non-null values.
    // To perform actions on a non-null object, use the safe call operator ?. on it and call let with the actions in its lambda.
    val length = str?.let {
        println("let() called on $it")
        processNonNullString(it)      // OK: 'it' is not null inside '?.let { }'
        it.length
    }

    // let is introducing local variables with a limited scope for improving code readability.
    // To define a new variable for the context object, provide its name as the lambda argument so that it can be used instead of the default it.
    val modifiedFirstItem = numbers.first().let { firstItem ->
        println("The first item of the list is '$firstItem'")
        if (firstItem.length >= 5) firstItem else "!" + firstItem + "!"
    }.toUpperCase()
    println("First item after modifications: '$modifiedFirstItem'")
    // let 뒤에 ?: 쓸 수 있음
}

