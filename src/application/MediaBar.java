package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;

/**
 * Contains controls of the Video
 *  Extends HBox Class for creating boxes:
 *      - vertical block with Up to Down
 *      - horizontal block with Left to Right
 */
public class MediaBar extends HBox {

    Slider time;        // Slider for the time
    Slider vol;         // Slider for volume

    Button pause;       // Button for the pause
    Label volumeLBL;    // Label for the volume

    MediaPlayer player;

    public MediaBar(MediaPlayer play) {
        player = play;

        vol = new Slider();
        time = new Slider();

        // Style the Controls
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10,10,10,10));
        setStyle("-fx-background-color: whitesmoke");

        pause = new Button("||");
        volumeLBL = new Label("Volume: ");

        // Adding elements to the player interface
        getChildren().add(pause);
        getChildren().add(time);
        getChildren().add(volumeLBL);
        getChildren().add(vol);

        vol.prefWidth(70);
        vol.setMinWidth(30);

        vol.setValue(100);

        pause.setOnAction((e) -> {

            MediaPlayer.Status status = player.getStatus();

            if(status == MediaPlayer.Status.PLAYING) {
                player.pause();
                pause.setText(">");
            } else if(status == MediaPlayer.Status.PAUSED) {
                player.play();
                pause.setText("||");
            }
        });

        // Set volume slider to the current video position
        player.currentTimeProperty().addListener((o) -> {
            time.setValue(player.getCurrentTime().toMillis() / player.getTotalDuration().toMillis()*100);
        });

        // Import time
        time.valueProperty().addListener((o) -> {
            if (time.isPressed())
            player.seek(player.getMedia().getDuration().multiply(time.getValue()/100));
        });

        // Import volume
        vol.valueProperty().addListener((o) -> {
            player.setVolume(vol.getValue()/100);
        });
    }
}
