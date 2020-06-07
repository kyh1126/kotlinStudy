package _6_typeSystem._1_nullability

class PersonName(val firstName: String, val lastName: String) {
    override fun equals(o: Any?): Boolean {
        // 타입이 서로 일치하지 않으면 false 반환
        val otherPerson = o as? PersonName ?: return false

        //안전한 캐스트를 하고나면 스마트캐스트 된다
        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 31 + lastName.hashCode()
}