package com.clicky.autoclicker;

import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

public class KeyController implements NativeMouseInputListener {
    FXMLLoader controller = new FXMLLoader(getClass().getResource("hello-view.fxml"));

    Parent prnt;
    {
        try {
            prnt = controller.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    HelloController ctrl = controller.<HelloController>getController();

    //todo: keybinding options
    String keybind = "f";

    public void nativeMouseClicked(NativeMouseEvent e)
    {
        System.out.println(e.getButton());

        /*
        BUTTON1 = Left Click
        BUTTON2 = Right Click
        BUTTON3 = Mouse Wheel Click
         */
        if(e.getButton() == NativeMouseEvent.BUTTON3)
        {
            int time = ctrl.getTf();

            ctrl.startClicker(time);
        }
    }
}
