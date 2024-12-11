
module org.example.demo1 {
        requires javafx.controls;
        requires javafx.fxml;
        requires java.sql;

        opens org.example.demo1 to javafx.fxml;
        exports org.example.demo1;

        // Экспортируем пакет GUI для JavaFX
        opens GUI to javafx.graphics;
        }
