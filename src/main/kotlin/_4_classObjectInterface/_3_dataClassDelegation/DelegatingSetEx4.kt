package _4_classObjectInterface._3_dataClassDelegation

fun main(args: Array<String>) {
    // by 키워드로 위임하기
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 2, 3))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}