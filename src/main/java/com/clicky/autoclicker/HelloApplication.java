package com.clicky.autoclicker;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader sceneLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(sceneLoader.load(), 240, 240);

        stage.setTitle("AutoClicker");
        stage.setScene(scene);
        stage.show();

        //Stops the globalhook when exiting the app
        stage.setOnCloseRequest(e -> {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws NativeHookException {
        GlobalScreen.registerNativeHook();
        KeyController kc = new KeyController();
        GlobalScreen.addNativeMouseListener(kc);

        launch();

    }


}