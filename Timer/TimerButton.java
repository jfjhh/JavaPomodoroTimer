package Timer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TimerButton extends JButton implements ActionListener {
	
	public JButton button;
	private String buttonName;
	private int timerID;
	private String toolTip;
	public PomodoroTimer pomTimer;
	
	public TimerButton(String name, int num, String tip) {
		setName(name);
		setTimerID(num);
		setToolTip(tip);
		
        button = new JButton(getName());
		button.setToolTipText(getToolTip());
		button.addActionListener(this);	
	}
	
	public void setTimerID(int num) {
	   	timerID = num;
	}
	
	public int getTimerID() {
		return timerID;
	}
	
	public void setName(String name) {
		buttonName = name;
	}
	
	public String getName() {
		return buttonName;
	}
	
	public void setToolTip(String tip) {
		toolTip = tip;
	}
	
	public String getToolTip() {
		return toolTip;
	}
	
	public String toString() {
		return(String.format("[ TimerButton: {Name: %s}, {ID: %d}, {ToolTip: %s} ]", getName(), getTimerID(), getToolTip()));
	}
	
	@Override
	public void actionPerformed(ActionEvent click) {
		Start.pick.setVisible(false);
		
		pomTimer = new PomodoroTimer(timerID);					
		pomTimer.setVisible(true);
	}
	
}
