package _4_classObjectInterface._4_object

fun main(args: Array<String>) {
    val json = "{name: 'Jenny'}"
    val p = CompanionExtensionPerson.fromJSON(json)
    println(p.name)
}