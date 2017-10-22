package com.minesweeper.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.minesweeper.ui.*;

public class EndListener implements ActionListener{

	JFrame container;
	public EndListener(JFrame frame) {
		container = frame;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton endButton= (JButton) e.getSource();
		
		if(endButton.getText()=="New Game") {
			GameUI gui = new GameUI();
			gui.run();
		}
		
		container.dispose();;
		
	}

}
