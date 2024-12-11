package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Campus Event Management System");

        // Главный экран с выбором роли
        Label welcomeLabel = new Label("Выберите вашу роль:");
        Button adminButton = new Button("Администратор кампуса");
        Button organizerButton = new Button("Организатор мероприятий");
        Button studentButton = new Button("Студент");
        Button lecturerButton = new Button("Преподаватель/Лектор");

        adminButton.setOnAction(e -> openAdminPanel());
        organizerButton.setOnAction(e -> openOrganizerPanel());
        studentButton.setOnAction(e -> openStudentPanel());
        lecturerButton.setOnAction(e -> openLecturerPanel());

        VBox mainLayout = new VBox(10, welcomeLabel, adminButton, organizerButton, studentButton, lecturerButton);
        Scene mainScene = new Scene(mainLayout, 400, 300);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private void openAdminPanel() {
        Stage adminStage = new Stage();
        adminStage.setTitle("Панель администратора кампуса");

        Label adminLabel = new Label("Добро пожаловать, администратор!");
        // Добавьте другие элементы GUI и функциональность
        VBox adminLayout = new VBox(10, adminLabel);
        Scene adminScene = new Scene(adminLayout, 400, 300);

        adminStage.setScene(adminScene);
        adminStage.show();
    }

    private void openOrganizerPanel() {
        Stage organizerStage = new Stage();
        organizerStage.setTitle("Панель организатора мероприятий");

        Label organizerLabel = new Label("Добро пожаловать, организатор!");
        // Добавьте другие элементы GUI и функциональность
        VBox organizerLayout = new VBox(10, organizerLabel);
        Scene organizerScene = new Scene(organizerLayout, 400, 300);

        organizerStage.setScene(organizerScene);
        organizerStage.show();
    }

    private void openStudentPanel() {
        Stage studentStage = new Stage();
        studentStage.setTitle("Панель студента");

        Label studentLabel = new Label("Добро пожаловать, студент!");
        // Добавьте другие элементы GUI и функциональность
        VBox studentLayout = new VBox(10, studentLabel);
        Scene studentScene = new Scene(studentLayout, 400, 300);

        studentStage.setScene(studentScene);
        studentStage.show();
    }

    private void openLecturerPanel() {
        Stage lecturerStage = new Stage();
        lecturerStage.setTitle("Панель преподавателя");

        Label lecturerLabel = new Label("Добро пожаловать, преподаватель!");
        // Добавьте другие элементы GUI и функциональность
        VBox lecturerLayout = new VBox(10, lecturerLabel);
        Scene lecturerScene = new Scene(lecturerLayout, 400, 300);

        lecturerStage.setScene(lecturerScene);
        lecturerStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
