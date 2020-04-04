package application;

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

    Slider time; // Slider for the time
    Slider vol;  // Slider for volume

    MediaPlayer player;

    public MediaBar(MediaPlayer play) {
        player = play;

        vol = new Slider();
        time = new Slider();

        getChildren().add(time);
        getChildren().add(vol);

        vol.prefWidth(70);
        vol.setMinWidth(30);

        vol.setValue(100);

        // Set volume slider to the current video position
        player.currentTimeProperty().addListener((o) -> {
            // System.out.println(player.getCurrentTime().toMillis() / player.getTotalDuration().toMillis()*100);
            time.setValue(player.getCurrentTime().toMillis() / player.getTotalDuration().toMillis()*100);
        });

        // Import time
        time.valueProperty().addListener((o) -> {
            // System.out.println(player.getMedia().getDuration().multiply(time.getValue()/100));
            player.seek(player.getMedia().getDuration().multiply(time.getValue()/100));
        });

        // Import volume
        vol.valueProperty().addListener((o) -> {
            // System.out.println(vol.getValue()/100);
            player.setVolume(vol.getValue()/100);
        });
    }
}
