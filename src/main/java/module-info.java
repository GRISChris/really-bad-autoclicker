module com.clicky.autoclicker {
    requires javafx.controls;
    requires javafx.fxml;
    requires jnativehook;


    opens com.clicky.autoclicker to javafx.fxml;
    exports com.clicky.autoclicker;
}