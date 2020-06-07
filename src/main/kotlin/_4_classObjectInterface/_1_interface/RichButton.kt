package _4_classObjectInterface._1_interface

open class RichButton : Clickable {
    // final function, cannot override
    fun disable() {}

    // can be override
    open fun animate() {}

    // member marked override is itself open, it may be overridden in subclasses.
    final override fun click() {}
}