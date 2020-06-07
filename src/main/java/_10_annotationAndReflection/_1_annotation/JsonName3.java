package _10_annotationAndReflection._1_annotation;

public @interface JsonName3 {
    // 어떤 애노테이션을 적용할 때 value 를 제외한 모든 애트리뷰트에는 이름을 명시해야 한다. 코틀린의 name 프로퍼티.
    String value();
}