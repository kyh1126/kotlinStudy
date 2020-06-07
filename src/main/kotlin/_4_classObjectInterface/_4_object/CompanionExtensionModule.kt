package _4_classObjectInterface._4_object

fun CompanionExtensionPerson.Companion.fromJSON(json: String): CompanionExtensionPerson {
    return CompanionExtensionPerson(json.substringAfter("name:").replace("}|'".toRegex(), "").trim())
}