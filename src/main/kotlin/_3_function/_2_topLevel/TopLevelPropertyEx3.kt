package _3_function._3_extension

var opCount = 0
// private static final
val UNIX_LINE_SEPARATOR = "\n"
// public static final
const val UNIX_LINE_SEPARATOR_2 = "\n\n"


fun performOperation() {
    opCount++
}

fun reportOperationCount() {
    println("Operation performed $opCount times")
}

fun main(args: Array<String>) {
    performOperation()
    performOperation()
    reportOperationCount()
    print(UNIX_LINE_SEPARATOR)

    performOperation()
    reportOperationCount()
    print(UNIX_LINE_SEPARATOR_2)

    print("----------")
}