package _4_classObjectInterface._3_dataClassDelegation

// If some property that does not declared in primary constructor,
// it is not considered to equals, hashCode calculation
data class DataClient(val name: String, val postalCode: Int) {
}