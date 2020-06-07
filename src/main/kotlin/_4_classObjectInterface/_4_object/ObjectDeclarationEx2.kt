package _4_classObjectInterface._4_object

import java.io.File

fun main(args: Array<String>) {
    // 객체 선언으로 Comparator 구현하기
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(Person("Bob"), Person("Jenny"))
    println(persons.sortedWith(Person.NameComparator))
}