package _3_function.extensions

import _3_function._3_extension.Button
import _3_function._3_extension.View

//fun showOff(view: View) =
//if (view !is Button) println("I'm a view!") else println("I'm a button!")

fun <T> showOff(view: T) = if (view is Button) println("I'm a view!") else print("I'm a button!")
