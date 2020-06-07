package _3_function._4_collectionProcess

infix fun Any.to(other: String) = Pair(this, other)

fun main(args: Array<String>) {
    // 1 to "one" : infix call
    // 7.to("seven") : normal call
    // 중위 호출시 객체, 메소드 이름, 유일한 인자 사이에는 공백이 들어가야 한다.
    val map = mutableMapOf(1 to "one", 7.to("seven"))
    map[8] = "eight"
    map.mapValues { println(it) }


    val (number, name) = 1.to("one")
    println("number: $number, name: $name")

    val (number2, name2) = "three".to(3)
    println("number2: $number2, name2: $name2")
}