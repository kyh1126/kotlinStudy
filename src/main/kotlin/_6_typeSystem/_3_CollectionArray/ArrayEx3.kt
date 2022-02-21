package _6_typeSystem._3_CollectionArray

fun main() {
    val letters = Array<String>(26) { i -> ('a' + i).toString() }
    println(letters.joinToString(""))

    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray())) // toTypedArray 메소드를 사용하면 쉽게 컬렉션을 배열로 바꿀 수 있다.

    // 크기와 람다를 인자로 받는 생성자를 사용
    val squares = IntArray(5) { i -> (i + 1) * (i + 1) }
    println(squares.joinToString())

    // forEachIndexed: 배열의 모든 원소를 갖고 인자로 받은 람다를 호출해준다.
    squares.forEachIndexed { index, element ->
        println("Argument $index is: $element")
    }
}
