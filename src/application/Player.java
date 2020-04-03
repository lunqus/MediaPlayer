package application;


import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane {

    // Creating/Importing Media, MediaPlayer, MediaView, Pane, MadiaBar
    Media media;
    MediaPlayer player;
    MediaView view;
    Pane mpane;
    MediaBar mediaBar;

    public Player(String file) {

        // Initializing media, player, view, mpane, mediaBar
        media = new Media(file);     // load up a file and understand what kind of media file is it
        player = new MediaPlayer(media);  // play the video
        view = new MediaView(player);    // display the video
        mpane = new Pane();

        mpane.getChildren().add(view);
        setCenter(mpane);

        player.play();

//
//        mediaBar = new MediaBar(player);


    }
}
