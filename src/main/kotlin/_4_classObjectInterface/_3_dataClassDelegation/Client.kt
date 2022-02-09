package _4_classObjectInterface._3_dataClassDelegation

class Client(val name: String, val postalCode: Int) {
    override fun toString(): String {
//        return super.toString()
        return "Client(name=$name, postalCode=$postalCode)"
    }

    override fun equals(other: Any?): Boolean {
//        return super.equals(other)

        // (other == null || other !is Client) 는 other !is Client 로 대체할 수 있다.
        if (other == null || other !is Client)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int {
//        return super.hashCode()
        return name.hashCode() * 31 + postalCode
    }

    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = DataClient(name, postalCode)
}

fun main(){
    println(Client("Jenny", 123))
}
