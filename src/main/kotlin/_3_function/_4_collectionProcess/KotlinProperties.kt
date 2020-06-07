package _3_function._4_collectionProcess

// 1. vararg
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts)
        result.add(t)
    return result
}

// 2. infix function
// They must be member functions or extension functions;
// They must have a single parameter;
// The parameter must not accept variable number of arguments and must have no default value.
class MyStringCollection {
    val arr = ArrayList<String>()

    infix fun add(s: String) = arr.add(s)
    //infix fun add2(s1: String, s2: String) = tmp.add(s1)    // Incorrect
    //infix fun add3(s: String = "Kotlin") = tmp.add(s)   // Incorrect

    fun build() {
        this add "abc"   // Correct
        add("abc")       // Correct
        //add "abc"        // Incorrect: the receiver must be specified
    }
}
//infix fun add(s: String) = println(s)   // Incorrect

data class Result(val a: Int, val b: Int)
fun function(): Result = Result(1, 2)

fun main(args: Array<String>) {
    println(asList('a', 'b', 'c'))

    var c = MyStringCollection()
    c.build()
    println(c.arr)

    // 3. destructuring declaration
    val (arr, cnt) = function()
    print("arr: $arr , cnt: $cnt")
}