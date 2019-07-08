package GUI;

import Save.Log;

public class Refresh implements Runnable {

    @Override
    public void run() {
        Main.lb2.setText(Main.lb2.getText() + Log.r());
    }
}
