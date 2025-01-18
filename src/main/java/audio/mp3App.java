package audio;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.AudioTrack;

/**
 * @author callumsmith on 2025-01-18
 */
public class mp3App extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Media media = new Media("/resources/audio/music.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

    }
}
