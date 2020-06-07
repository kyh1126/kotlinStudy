package _4_classObjectInterface._1_interface

class Subclass : Outer() {
    // a is not visible
    // b, c and d are visible
    // Nested and e are visible
//    fun a(){
//        println(Nested().e)
//    }
    override val b = 5   // 'b' is protected
    // protected 는 이렇게 써야하는듯
    fun printB() = println(b)

    fun b(){
        super.Inner().getOuterReference()
    }
}