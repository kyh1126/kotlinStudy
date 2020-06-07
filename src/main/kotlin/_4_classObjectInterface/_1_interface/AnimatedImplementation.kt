package _4_classObjectInterface._1_interface

class AnimatedImplementation : Animated() {
    override fun animate() {
        println("override fun animate")
    }

    override fun stopAnimating() {
        super.stopAnimating()
        println("override fun stopAnimating")
    }
}