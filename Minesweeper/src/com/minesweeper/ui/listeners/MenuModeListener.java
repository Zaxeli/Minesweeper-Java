package com.minesweeper.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.minesweeper.ui.GameUI;

public class MenuModeListener implements ActionListener{

	GameUI gameUI;
	JFrame menuframe;
	int mode;
	
	public MenuModeListener(JFrame frame, int modeNumber) {
		super();
		gameUI = new GameUI();
		menuframe=frame;
		mode = modeNumber;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(mode) {
		case 0:
			gameUI.build(10,9,9);
			break;
		case 1:
			gameUI.build(40,16,16);
			break;
		case 2:
			gameUI.build(99,30,16);
			break;
			
		default:
			System.out.print("What?");
				
		}
		menuframe.dispose();
	}
}
