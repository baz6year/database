package GUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class GUI extends Application {
    private final Map<String, String> userDatabase = new HashMap<>();
    private final Map<String, String> userRoles = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {

        userDatabase.put("admin", "admin123");
        userDatabase.put("organizer", "organizer123");
        userDatabase.put("student", "student123");
        userDatabase.put("teacher", "teacher123");

        userRoles.put("admin", "Welcome, Admin! Manage your campus effectively.");
        userRoles.put("organizer", "Welcome, Organizer! Plan your events seamlessly.");
        userRoles.put("student", "Welcome, Student! Explore and engage in campus activities.");
        userRoles.put("teacher", "Welcome, Teacher! Manage your lectures and connect with students.");

        primaryStage.setTitle("Campus Event Management System");


        Label loginLabel = new Label("Enter your username and password:");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button loginButton = new Button("Login");

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (authenticateUser(username, password)) {
                openRoleScreen(primaryStage, username);
            } else {
                errorLabel.setText("Invalid username or password!");
            }
        });

        VBox loginLayout = new VBox(10, loginLabel, usernameField, passwordField, loginButton, errorLabel);
        loginLayout.setAlignment(Pos.CENTER);
        Scene loginScene = new Scene(loginLayout, 400, 300);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private boolean authenticateUser(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }

    private void openRoleScreen(Stage primaryStage, String username) {
        String role = username.toLowerCase();
        if (!userRoles.containsKey(role)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unknown role! Please contact support.");
            alert.showAndWait();
            return;
        }

        primaryStage.setTitle("Campus Event Management System - Role");

        Label welcomeLabel = new Label(userRoles.get(role));
        Button actionButton = new Button("Proceed to Menu");

        actionButton.setOnAction(e -> openMenu(primaryStage, role));

        VBox roleLayout = new VBox(10, welcomeLabel, actionButton);
        roleLayout.setAlignment(Pos.CENTER);
        Scene roleScene = new Scene(roleLayout, 400, 300);

        primaryStage.setScene(roleScene);
    }

    private void openMenu(Stage primaryStage, String role) {
        primaryStage.setTitle("Campus Event Management System - Menu");

        Label menuLabel = new Label("Welcome to the Menu! Select an action:");
        Button actionButton = new Button();
        switch (role) {
            case "admin":
                actionButton.setText("Manage Users");
                actionButton.setOnAction(e -> showInfo("Managing users functionality."));
                break;
            case "organizer":
                actionButton.setText("Plan Events");
                actionButton.setOnAction(e -> showInfo("Planning events functionality."));
                break;
            case "student":
                actionButton.setText("View Events");
                actionButton.setOnAction(e -> showInfo("Viewing events functionality."));
                break;
            case "teacher":
                actionButton.setText("Manage Lectures");
                actionButton.setOnAction(e -> showInfo("Managing lectures functionality."));
                break;
        }

        VBox menuLayout = new VBox(10, menuLabel, actionButton);
        menuLayout.setAlignment(Pos.CENTER);
        Scene menuScene = new Scene(menuLayout, 400, 300);

        primaryStage.setScene(menuScene);
    }

    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
