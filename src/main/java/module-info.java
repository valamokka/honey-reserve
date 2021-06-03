module Marton.Szabo {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires org.postgresql.jdbc;
    requires java.sql;

    exports Marton.Szabo.control;
    opens Marton.Szabo.control to javafx.fxml;

}