package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class Main extends Application {

    // Creating/Importing Player, FileChooser, MenuBar, Menu, MenuItem

    Player mediaPlayer;

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

            try {
                System.out.println(mediaFile.toURI().toURL().toExternalForm());
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }

            try {
                mediaPlayer = new Player(mediaFile.toURI().toURL().toExternalForm());
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }
            root.setCenter(mediaPlayer);
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
