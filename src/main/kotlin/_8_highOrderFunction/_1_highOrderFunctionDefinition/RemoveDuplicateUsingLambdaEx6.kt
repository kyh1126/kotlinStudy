package _8_highOrderFunction._1_highOrderFunctionDefinition

data class SiteVisit(val path: String, val duration: Double, val os: OS)

enum class OS {
    WINDOWS, LINUX, MAC, IOS, ANDROID
}

// 2. 중복 코드를 별도 함수롤 추출하는 방법
fun List<SiteVisit>.averageDurationFor(os: OS) = filter { it.os == os }.map(SiteVisit::duration).average()

// 3. 고차 함수를 사용해 중복 제거하기
fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()

fun main(args: Array<String>) {
    val log = listOf(
        SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.WINDOWS),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID)
    )

    // 1. 평균을 filter 하드코딩으로 수행
    val averageWindowsDuration = log
        .filter { it.os == OS.WINDOWS } // it.os in setOf(OS.IOS, OS.ANDROID) 같이도 가능
        .map(SiteVisit::duration)
        .average()  // average 함수를 사용해 쉽게 수행 가능
    println(averageWindowsDuration)
    println("----------")
    println(log.averageDurationFor(OS.WINDOWS))
    println(log.averageDurationFor(OS.MAC))
    println("----------")
    println(log.averageDurationFor{it.os in setOf(OS.IOS, OS.ANDROID)})

}