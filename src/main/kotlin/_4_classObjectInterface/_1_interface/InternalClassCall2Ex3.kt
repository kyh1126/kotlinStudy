package _4_classObjectInterface._1_interface

fun main(args: Array<String>) {
    // open class
    val o = Outer()
    println("${o.javaClass.simpleName} can see only o.c:${o.c}, o.d:${o.d}")

    // Outer class 상속받음
    val s = Subclass()
    println("${s.javaClass.simpleName} can see only s.c:${s.c}, s.d:${s.d}")
    s.printB()
}