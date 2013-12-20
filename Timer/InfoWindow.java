package Timer;

import javax.swing.*;
import java.awt.*;


public class InfoWindow extends JFrame {
	
	private Container contentPane;
	private JPanel titlePanel;
	private JPanel iconPanel;
	private JPanel infoPanel;
	private JPanel mainPanel;
	private JLabel iconLabel;
	private JLabel title;
	private JLabel version;
	private JLabel author;
	private Icon icon;
	
	public InfoWindow() {
		super("About");
		setResizable(false);
		
		initUI();
		
		setSize(200, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void initUI() {
		// titlePanel
		titlePanel = new JPanel();
		titlePanel.setLayout(new GridBagLayout());
		titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
			
		title = new JLabel("Pomodoro Timer");
		
		titlePanel.add(title);
		
		// iconPanel
		iconPanel = new JPanel();
		iconPanel.setLayout(new GridBagLayout());
		iconPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0));
		
		icon = new ImageIcon(InfoWindow.class.getResource("icon/pomodoro.png"));
		iconLabel = new JLabel(icon);
		
		iconPanel.add(iconLabel);
		
		
		// infoPanel
		infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(0, 1, 0, 5));
		infoPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		
		version = new JLabel("v.1.0.");
		author = new JLabel("by Alex Striff");
		
		infoPanel.add(version);
		infoPanel.add(author);
		
		// mainPanel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		mainPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10),
			BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
					BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)))));
		
		mainPanel.add(titlePanel, BorderLayout.NORTH);
		mainPanel.add(iconPanel, BorderLayout.CENTER);
		mainPanel.add(infoPanel, BorderLayout.SOUTH);
		
		// contentPane
		contentPane = getContentPane();
		contentPane.add(mainPanel, BorderLayout.CENTER);
	}
}
