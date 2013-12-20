package Timer;

import java.net.URL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;


class Surface extends JPanel implements ActionListener {
	
	private int timerID;
	private int permTimerID;
	private String text;
	private long current;
	private long limit;
	private Timer timer;
	private int pomCount;
	private boolean startNextTimer;
	
	public Surface(int time) {
		setBackground(new Color(180, 180, 180));

		text = "";
		pomCount = 0;
		permTimerID = time;
		
		initTimer(permTimerID);
	}
	
	private void initTimer(int time) {
		timerID = time;
		
		current = System.currentTimeMillis();
			
		timer = new Timer(1000, this);
		timer.start();
	}
	
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh =
            new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        g2d.setFont(new Font("Mona Lisa Solid ITC TT", Font.PLAIN, 48));
		if (pomCount % 2 == 0) {
			g2d.drawString("Work", 580, 360);
		} else if (pomCount % 7 == 0) {
			g2d.drawString("Long Break", 580, 360);
		} else {
			g2d.drawString("Break", 580, 360);
		}

        g2d.setFont(new Font("Mona Lisa Solid ITC TT", Font.PLAIN, 48));
        g2d.drawString("Pomodoros: " + Integer.toString(pomCount / 2), 470, 70);      
				 
        g2d.setFont(new Font("Mona Lisa Solid ITC TT", Font.PLAIN, 300));
		g2d.drawString(text, 120, 280);       
        }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (pomCount % 2 == 0) {
			limit = ((permTimerID * 1000) * 60) + 2000; // work (timerID)
		} else if (pomCount % 7 == 0) {
			limit = ((15 * 1000) * 60) + 2000; // long break (15)				
		} else if (pomCount % 2 == 1) {
			limit = ((5 * 1000) * 60) + 2000; // normal break (5)
		}
		
		long time = System.currentTimeMillis();
		long passed = time - current;       
		long remaining = limit - passed;	
	
		if (remaining <= 0) {
			timer.stop();
			pomCount += 1;
			PlaySound.playSound();
			if (pomCount % 2 == 0) {
				initTimer(permTimerID);
			} else if (pomCount % 7 == 0) {
				initTimer(15);
			} else {
				initTimer(5);
			}
		} else {
			long seconds = remaining/1000;
			long minutes = seconds/60;
			long hours = minutes/60;
			text = String.format("%02d:%02d", minutes, seconds % 60);
			repaint();
		}
	}
}

public class PomodoroTimer extends JFrame {
    
	private Surface surface;
	private int timerID;

    public PomodoroTimer(int time) {
		timerID = time;
        initUI();
    }
    
    private void initUI() {
        setTitle("Pomodoro Timer");
		
		surface = new Surface(timerID);
        add(surface);
		
        setSize(760, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);      
    }
}