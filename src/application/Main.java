package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    // Importing FileChooser, MenuBar, Menu, MenuItem
    FileChooser mediaChooser;
    MenuBar menu;
    Menu fileMenu;
    MenuItem openItem;

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 400);

        // Initializing mediaChooser, menuBar, fileMenu, openItem
        mediaChooser = new FileChooser();
        menu = new MenuBar();
        fileMenu = new Menu("file");
        openItem = new MenuItem("open");

        // Add fileMenu to the menu & openItem to the fileMenu
        menu.getMenus().add(fileMenu);
        fileMenu.getItems().add(openItem);


        // Action perform when clicked on openItem
        openItem.setOnAction((e) -> {
            // System.out.println("clicked open");
            File mediaFile = mediaChooser.showOpenDialog(primaryStage);
            System.out.println(mediaFile.getAbsolutePath());
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
