package com.clicky.autoclicker;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.robot.Robot;
import javafx.util.Duration;

public class HelloController {

    static boolean bh = false;
    static boolean ch = false;
    static volatile int currentTime;

    @FXML
    private TextField tf;

    @FXML
    private Label errors = new Label();

    @FXML
    private Label status = new Label("Disabled");

    @FXML
    private Button fxbtn = new Button("Start Autoclicker");

    public void setErrors(String errors) {
        this.errors.setText(errors);
    }

    public int getTf() {
        try {
            return currentTime;
        } catch (NumberFormatException e)
        {
            e.printStackTrace();

            return 100;
        }
    }

    void autoClick(int time)
    {
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(time), ev -> {
            try {
                if(ch) {
                    click();
                }
            } catch (Exception e) {
                setErrors(e.getMessage());
            }
        }));

        tl.setCycleCount(Animation.INDEFINITE);

        if(ch)
        {
            tl.play();
        }
        else
        {
            tl.stop();
        }
    }

    @FXML
    void updateAC()
    {
        flip();

        if(bh)
        {
            fxbtn.setText("Disable Autoclicker");
            tf.setDisable(true);
            status.setText("Enabled, press MOUSE3 to start/stop clicking");

            currentTime = Integer.parseInt(tf.getText());
            System.out.println(currentTime);
        }
        else
        {
            fxbtn.setText("Start Autoclicker");
            tf.setDisable(false);
            status.setText("Disabled");
        }
    }

    void startClicker(int time)
    {
        if(bh)
        {
            flip2();
            autoClick(time);
        }

    }

    void click()
    {
        Robot mouse = new Robot();
        mouse.mouseClick(MouseButton.PRIMARY);
    }

    void flip()
    {
        bh = !bh;
    }

    void flip2()
    {
        ch = !ch;
    }
}