package _4_classObjectInterface._1_interface;

import org.jetbrains.annotations.NotNull;

public class JavaButton implements View {
    @NotNull
    @Override
    public State getCurrentState() {
        return new ButtonState();
    }

    @Override
    public void restoreState(@NotNull State state) {

    }

    private class ButtonState implements State {
    }
}
