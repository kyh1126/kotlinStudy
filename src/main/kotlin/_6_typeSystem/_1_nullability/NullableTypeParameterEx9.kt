package _6_typeSystem._1_nullability

fun <T> printHashCode(t: T) {
    // t can be null, should use safe call.
    println(t?.hashCode())
}

// upper bound 지정하면 null 이 될 수 있는 값을 거부한다.
// The default upper bound (if none specified) is Any?.
fun <T : Any> printHashCodeUpperBound(t: T) {
    println(t.hashCode())
}

fun main() {
    printHashCode(null)
}
