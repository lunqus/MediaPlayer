package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    MenuBar menu;
    Menu fiileMenu;

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 400);

        menu = new MenuBar();
        fiileMenu = new Menu("file");

        menu.getMenus().add(fiileMenu);

        root.setTop(menu);

        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setTitle("Hello World");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
