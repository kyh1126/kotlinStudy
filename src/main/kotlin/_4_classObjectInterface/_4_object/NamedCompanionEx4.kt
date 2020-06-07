package _4_classObjectInterface._4_object

fun <T> loadFromJSON(factory: JSONFactory<T>): T {
    return factory.fromJSON("{name: 'Jenny'}")
}

fun main(args: Array<String>) {
//    val person = NamedCompanionPerson.Loader.fromJSON("{name: 'Jenny'}")
//    println(person.name)

    val person2 = NamedCompanionPerson.fromJSON("{name: 'Brent'}")
    println(person2.name)

    // If one class's companion object contains Abstract factory
    // It can be called through it's Class name
    println(loadFromJSON(NamedCompanionPerson).name)
}