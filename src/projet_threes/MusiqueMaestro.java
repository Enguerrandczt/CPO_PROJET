package projet_threes;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusiqueMaestro {
    private Clip clip;
    private FloatControl volumeControl; // Ajout du contrôle de volume

    public void play(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            
            // Obtient le contrôle de volume depuis le Clip
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            
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
    
    public void setVolume(float volume) {
        if (volumeControl != null) {
            // Convertit le volume spécifié (0-1) en dB (négatif pour baisser le volume)
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            volumeControl.setValue(dB);
        }
    }
    
   
}
