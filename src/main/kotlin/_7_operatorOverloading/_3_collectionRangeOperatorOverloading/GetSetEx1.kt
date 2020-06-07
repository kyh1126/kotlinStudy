package _7_operatorOverloading._3_collectionRangeOperatorOverloading

import _7_operatorOverloading._2_comparisonOperatorOverloading.Point

//  Indexed access operator
//  Expression	            Translated to
//  a[i]	                a.get(i)
//  a[i, j]	                a.get(i, j)
//  a[i_1, ..., i_n]	    a.get(i_1, ..., i_n)
//  a[i] = b	            a.set(i, b)
//  a[i, j] = b	            a.set(i, j, b)
//  a[i_1, ..., i_n] = b	a.set(i_1, ..., i_n, b)
// Square brackets are translated to calls to get and set with appropriate numbers of arguments.

// get 연산자 함수 정의.
operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw kotlin.IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

// set 연산자 함수 정의.
operator fun MutablePoint.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun main(args: Array<String>) {
    val p = Point(10, 20)
    println(p[1])

    val mp = MutablePoint(10, 20)
    mp[1] = 13
    println(mp)
}