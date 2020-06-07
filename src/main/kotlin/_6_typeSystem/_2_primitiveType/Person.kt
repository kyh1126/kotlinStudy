package _6_typeSystem._2_primitiveType

data class Person(val name: String, val age: Int? = null) {
    fun isOlderThan(other: Person): Boolean? {
        if (age == null || other.age == null) {
            return null
        }
        return age > other.age
    }
}