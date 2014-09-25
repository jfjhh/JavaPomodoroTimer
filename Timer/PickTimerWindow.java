package Timer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class PickTimerWindow extends JFrame {
	
	private Container contentPane;
	private JPanel headPanel;
	private JPanel innerButtonPanel;
	private JPanel mainPanel;
	private JPanel cancelPanel;
	private JLabel label;
	private JLabel pickLabel;
	private TimerButton button1;
	private TimerButton button2;
	private TimerButton button3;
	private JButton cancelButton;
	private JButton cancelInfoButton;
	private Frame about;
	
	public PickTimerWindow() {
		super("Pick Timer");
		setResizable(true);
		
		initUI();
		
		setSize(850, 850);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initUI() {
		// headPanel
		headPanel = new JPanel();		
		headPanel.setLayout(new BoxLayout(headPanel, BoxLayout.PAGE_AXIS));
		headPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		label = new JLabel(
			"<html>" +
				"<h1>What is it?</h1>" +
					"<p>This Application is <b>just a timer</b>, and is based off of the <i>Pomodoro Technique</i>.</p>" +
				"<h2>How do I use it?</h2>" +
					"<p>Simply click on one of the buttons to set the length of a 'Pomodoro.'</p>" +
					"<p>The timer lengths are as follows:" +
						"<ul>" +
							"<li>10 minutes</li>" +
							"<li>15 minutes</li>" +
							"<li>25 minutes</li>" +
						"</ul>" +
					"</p>" +
				"<h4>Its as simple as that!</h4>" +
					"<p>- <i>Alex Striff</i></p>" +
			"</html>"
		);
		
		headPanel.add(label);
		
		// innerButtonPanel
		pickLabel = new JLabel("Pick a timer duration.");
		
		innerButtonPanel = new JPanel();
		innerButtonPanel.setLayout(new GridLayout(0, 1, 0, 5));
		innerButtonPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
			BorderFactory.createEmptyBorder(20, 20, 20, 20)));
		
        button1 = new TimerButton("Short", 10, "10 minutes");
        button2 = new TimerButton("Medium", 15, "15 minutes");
        button3 = new TimerButton("Long", 25, "25 minutes");
		
		innerButtonPanel.add(pickLabel, BorderLayout.CENTER);
		innerButtonPanel.add(button1.button);
		innerButtonPanel.add(button2.button);
		innerButtonPanel.add(button3.button);
		
		// mainPanel
		mainPanel = new JPanel();
		
		mainPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20),
			BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
					BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(20, 20, 20, 20)))));
		
		mainPanel.add(headPanel, BorderLayout.CENTER);
		mainPanel.add(innerButtonPanel, BorderLayout.SOUTH);
		
		// cancelPanel
		cancelPanel = new JPanel();
		cancelPanel.setLayout(new BoxLayout(cancelPanel, BoxLayout.LINE_AXIS));
		cancelPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		
		cancelInfoButton = new JButton("About");
		cancelInfoButton.setToolTipText("More information about the Application");
		cancelInfoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				about = new InfoWindow();
				about.setVisible(true);
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setToolTipText("Quit Application");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				System.exit(0);
			}
		});
		
		cancelPanel.add(Box.createHorizontalGlue());
		cancelPanel.add(cancelInfoButton);
		cancelPanel.add(Box.createRigidArea(new Dimension(5, 0)));
		cancelPanel.add(cancelButton);
		
		// contentPane
		contentPane = getContentPane();
		
		contentPane.add(mainPanel, BorderLayout.CENTER);
		contentPane.add(cancelPanel, BorderLayout.SOUTH);
	}
}
