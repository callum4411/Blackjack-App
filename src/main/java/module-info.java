module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;

    opens blackjack to javafx.fxml;
    exports blackjack;
}