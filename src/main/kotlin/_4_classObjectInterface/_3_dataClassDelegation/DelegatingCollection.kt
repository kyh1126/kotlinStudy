package _4_classObjectInterface._3_dataClassDelegation

//class DelegatingCollection<T> : Collection<T> {
//    private val
//    innerList = arrayListOf<T>()
//
//    override val size: Int get() = innerList.size
//    override fun contains(element: T): Boolean = innerList.contains(element)
//    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)
//    override fun isEmpty(): Boolean = innerList.isEmpty()
//    override fun iterator(): Iterator<T> = innerList.iterator()
//}

class DelegatingCollection<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList {
}