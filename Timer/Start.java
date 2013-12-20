package Timer;

import javax.swing.*;


public class Start extends JFrame {
	
	private JPanel panel;
	public static PickTimerWindow pick;
	
	public Start() {
		pick = new PickTimerWindow();
		pick.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Start start = new Start();
			}
		});
	}
}
