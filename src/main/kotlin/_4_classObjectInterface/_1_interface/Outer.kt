package _4_classObjectInterface._1_interface

open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3  // 자바에서는 public
    val d = 4  // public by default
    protected val f = 3 // open 이 없으면 final

    protected class Nested {
        public val e: Int = 5
    }

    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }

    class Inner2 {
//        fun getOuterReference(): Outer = this@Outer
    }

}

fun a() {
    var a= Outer()
    a.Inner()
//    Outer.Inner()

    Outer.Inner2()
}