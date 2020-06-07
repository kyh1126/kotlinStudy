package _3_function._5_stringAndRegex

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

fun parsePathUsingRegex(path: String) {
    // 마지막 슬래시를 제외한 모든 슬래시 포함한 문자열
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory, name: $fileName, ext: $extension")
    }
}


fun main(args: Array<String>) {
    parsePath("/Users/jenny/test.txt")

    parsePathUsingRegex("/Users/jenny/test.txt")
}