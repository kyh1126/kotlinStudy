package _7_operatorOverloading._2_comparisonOperatorOverloading

import java.time.LocalDateTime

//  Comparison operators
//  Expression	Translated to
//  a > b	    a.compareTo(b) > 0
//  a < b	    a.compareTo(b) < 0
//  a >= b	    a.compareTo(b) >= 0
//  a <= b	    a.compareTo(b) <= 0

class Person(val firstName: String, val lastName: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        // compareValuesBy 는 두 객체가 같지 않다는 결과가 나오면 그 결과 값을 즉시 반환하고 같으면 0을 리턴값으로 대소비교 한다.
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}

fun main(args: Array<String>) {
    val p1 = Person("Alice", "Smith")
    val p2 = Person("Bob", "Johnson")
    println(p1 < p2)
//    println(p1.compareTo(p2))
}