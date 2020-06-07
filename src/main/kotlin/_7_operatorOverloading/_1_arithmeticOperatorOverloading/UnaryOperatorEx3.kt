package _7_operatorOverloading._1_arithmeticOperatorOverloading

import java.math.BigDecimal

//  Unary prefix operators
//  Expression	Translated to
//  +a	        a.unaryPlus()
//  -a	        a.unaryMinus()
//  !a	        a.not()

//  Increments and decrements
//  Expression	Translated to
//  a++	        a.inc()
//  a--	        a.dec()
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE

fun main(args: Array<String>) {
    val p = Point(10, 20)
    println(-p)

    var bd = BigDecimal.ZERO
    bd = bd.inc()
    println(bd)
    println(++bd)
    bd.dec()
    println(bd)
}