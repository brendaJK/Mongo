module com.brenda.mongo {
    requires javafx.controls;
    requires javafx.fxml;
    requires mongo.java.driver;


    opens com.brenda.mongo to javafx.fxml;
    exports com.brenda.mongo;
}