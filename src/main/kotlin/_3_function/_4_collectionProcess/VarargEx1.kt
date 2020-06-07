package _3_function._4_collectionProcess

fun main() {
    val arr = arrayOf(2, 3, 4, 5)

    // spread 연산자가 배열 내용을 펼쳐준다.
    val before = listOf("args: ", arr)
    val after = listOf("args: ", *arr)

    println(before)
    println(after)
}