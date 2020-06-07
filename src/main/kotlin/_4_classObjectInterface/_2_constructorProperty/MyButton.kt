package _4_classObjectInterface._2_constructorProperty

import javax.naming.Context
import javax.print.attribute.AttributeSet

class MyButton : SecondaryView {
//    constructor(ctx: Context) : this(ctx, MY_STYLE)
    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr)
}