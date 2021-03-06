package datatype;

import listener.ButtonListener;
import nxt.NXT;

import java.util.ArrayList;

/**
 * A class for the buttons of the NXT. For further information on how the
 * buttons works, visit the leJos NXJ documentation.
 */
public class NXTButton {

    private static ArrayList<ButtonListener> listeners = new ArrayList<>();

    private int name;
    private NXT nxt;

    /**
     * the constructor of NXTButton
     *
     * @param name the name of the Button; e.g. "LEFT", "RIGHT", "ENTER" or "ESCAPE"
     */
    public NXTButton(int name, NXT nxt) {
        this.name = name;
        this.nxt = nxt;
    }

    /**
     * @return the name of the Button
     */
    public int getName() {
        return name;
    }

    /**
     * add a Listener for this Button
     *
     * @param listener the listener to add
     */
    public void addButtonListener(ButtonListener listener) {
        nxt.getConnection().enqueue(NXTMessage.buttonPressed(this));
        listeners.add(listener);
    }

    /**
     * notifies all listeners, that the button is pressed
     */
    public void buttonPressed() {
        for (ButtonListener l : listeners) {
            l.buttonPressed();
        }
    }
}
