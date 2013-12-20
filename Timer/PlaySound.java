package Timer;

import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;

public class PlaySound {
    public static void playSound() {
        try {
	        URL url = new URL("http://www.soundjay.com/misc/bell-ringing-04.wav");
	        Clip clip = AudioSystem.getClip();
	        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
	        clip.open(ais);
	        clip.loop(0);
			Thread.sleep(2000);	
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}