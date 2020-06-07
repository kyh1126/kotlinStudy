package _8_highOrderFunction._2_inlineFunction

import java.io.BufferedReader
import java.io.FileReader

fun readFirstLineFromFile(path: String): String {
    // use 함수는 closable 자원에 대한 inline 확장함수, 람다 호출 후 자원을 닫아준다.
    // 람다의 본문 안에서 사용한 return 은 넌로컬 return 이다.
    // 이 return 문은 람다가 아니라 readFirstLineFromFile 함수를 끝내면서 값을 반환한다.
    BufferedReader(FileReader(path)).use { br ->
        return br.readLine()
    }
}