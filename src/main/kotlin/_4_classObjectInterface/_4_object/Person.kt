package _4_classObjectInterface._4_object

data class Person(val name: String) {
    // 어떤 클래스의 인스턴스를 비교하는 Comparator 는 클래스 내부에 정의하는게 더 바람직하다.
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int = p1.name.compareTo(p2.name)
    }
}
