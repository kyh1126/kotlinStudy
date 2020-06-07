package _4_classObjectInterface._2_constructorProperty

class LengthCounter {
    var counter: Int = 0
        private set

//    @JvmField 사용 시 아래와 같이 컴파일 해주
//    public final int publicProperty;
//    아니면 private final int publicProperty; 후 public final int getPublicProperty() 제공한다.
    val publicProperty = 0

    fun addWord(word: String) {
        counter += word.length
    }
}