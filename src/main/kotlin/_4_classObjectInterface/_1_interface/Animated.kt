package _4_classObjectInterface._1_interface

// 추상 클래스
abstract class Animated {

    abstract fun animate()

    // Basically non-abstract function is final type,
    // but if you want, then you can permit override.
    open fun stopAnimating() {
        println("open fun stopAnimating")
    }

    fun animateTwice() {
        println("fun animateTwice")
    }
}