package _6_typeSystem._3_CollectionArray

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}

fun main(args: Array<String>) {

}