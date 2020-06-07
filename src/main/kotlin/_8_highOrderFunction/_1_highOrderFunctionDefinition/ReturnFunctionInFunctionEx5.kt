package _8_highOrderFunction._1_highOrderFunctionDefinition

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix = { p: Person -> p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix) }

        // 함수 타입의 변수를 반환한다.
        if (!onlyWithPhoneNumber) return startsWithPrefix

        // 람다를 반환한다.
        return { startsWithPrefix(it) && it.phoneNumber != null }
    }
}

fun main(args: Array<String>) {
    val contacts = listOf(
        Person("Jenny", "Kim", "010-7737-6202"),
        Person("Jane", "Kim", "null")
    )

    val contactListFilters = ContactListFilters()
    with(contactListFilters) {
        prefix = "Je"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(contactListFilters.getPredicate()))
}