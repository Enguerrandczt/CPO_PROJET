package projet_threes;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusiqueMaestro {
    private Clip clip;

    public void play(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
    
    // D'autres méthodes pour gérer la pause, le réglage du volume, etc., si nécessaire
}
