package _4_classObjectInterface._1_interface

class KotlinButton : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    class ButtonState : State {

    }
}