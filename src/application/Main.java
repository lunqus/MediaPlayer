package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    // Importing menuBar, menu, openItem
    MenuBar menu;
    Menu fiileMenu;
    MenuItem openItem;

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 400);

        // Instializing menuBar, fileMenu, openItem
        menu = new MenuBar();
        fiileMenu = new Menu("file");
        openItem = new MenuItem("open");

        // Add openItem to the fileMenu
        fiileMenu.getItems().add(openItem);

        // Add fileMenu to the menu
        menu.getMenus().add(fiileMenu);

        // Action perform when clicked on openItem
        openItem.setOnAction((e) -> {
            System.out.println("clicked open");
        });

        // Add menuBar to the root
        root.setTop(menu);

        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setTitle("Hello World");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
