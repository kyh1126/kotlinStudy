package _10_annotationAndReflection._1_annotation

import _10_annotationAndReflection.jkid.JsonExclude
import _10_annotationAndReflection.jkid.JsonName
import _10_annotationAndReflection.jkid.deserialization.deserialize
import _10_annotationAndReflection.jkid.serialization.serialize

// @JsonName(name="first_name")과 같이 표시할 수도 있다.
data class Person(@JsonName("alias") val name: String, @JsonExclude val age: Int? = null)

// @JsonExclude : 직렬화/역직렬화 시 그 프로퍼티를 무시할 수 있다.
// @JsonName : 프로퍼티를 표현하는 키/값 쌍의 키로 프로퍼티 이름 대신 애노테이션이 지정한 이름을 쓰게 할 수 있다.
fun main(args: Array<String>) {
    val person = Person("Jenny", 31)
    // 직렬화
    println(serialize(person))

//    val json = """{"name":"Jenny", "age":31}"""
    val json = """{"alias":"Jenny"}"""
    // 역직렬화
    println(deserialize<Person>(json))
}