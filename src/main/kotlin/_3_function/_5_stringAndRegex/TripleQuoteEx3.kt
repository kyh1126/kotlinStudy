package _3_function._5_stringAndRegex


fun main(args: Array<String>) {
    // 여러 줄 문자열을 코드에서 더 보기 좋게 표현하기
    // 들여쓰기의 끝부분을 특별한 문자열로 표시하고, trimMargin을 사용해 그 문자열과 그 직전의 공백을 제거한다.
    val kotlinLogo = """|  //
                       .| //
                       .|/ \"""
    println(kotlinLogo.trimMargin("."))

    println("c:\\Users\\yole\\kotlin-book")
    // 여러 줄 문자열에는 \n 같은 특수 문자로 줄바꿈 할 순 없다. 대신 escape 할 필요 없다.
    println("""c:\Users\yole\kotlin-book""")
}
