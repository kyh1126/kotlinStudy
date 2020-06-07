package _7_operatorOverloading._3_collectionRangeOperatorOverloading

import _7_operatorOverloading._2_comparisonOperatorOverloading.Point

//  'In' operator
//  Expression	Translated to
//  a in b	    b.contains(a)
//  a !in b	    !b.contains(a)

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point): Boolean {
    // 범위를 만들고 좌표가 그 범위 안에 있는지 검사한다.
    return p.x in upperLeft.x until lowerRight.x &&
            p.y in upperLeft.y until lowerRight.y
}

fun main(args: Array<String>) {
    val rect = Rectangle(Point(10, 20), Point(50, 50))
    println(Point(20, 20) in rect)
}