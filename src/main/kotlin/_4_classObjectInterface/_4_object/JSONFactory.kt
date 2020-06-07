package _4_classObjectInterface._4_object

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}