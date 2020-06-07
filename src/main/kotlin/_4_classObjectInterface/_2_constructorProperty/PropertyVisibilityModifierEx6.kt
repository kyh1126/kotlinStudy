package _4_classObjectInterface._2_constructorProperty

fun main(args: Array<String>) {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
//    lengthCounter.counter = 3
    println(lengthCounter.counter)
}