package com.minesweeper.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import com.minesweeper.ui.listeners.EndListener;

public class GameEnd {
	public GameEnd(String s) {
		
		JFrame endFrame = new JFrame(s);
		JPanel endPanel= new JPanel(new GridBagLayout());
		
		JLabel label = new JLabel(s);
		JButton restart,exit;
		
		GridBagConstraints gbc = new GridBagConstraints();
		Dimension d = new Dimension(100,20);
		
		endFrame.setTitle(s);
		
		restart = new JButton("New Game");
		exit = new JButton("Exit");
		restart.setPreferredSize(d);
		exit.setPreferredSize(d);
		
		restart.addActionListener(new EndListener(endFrame));
		exit.addActionListener(new EndListener(endFrame));
		
		gbc.gridwidth=2;
		gbc.gridx=0;
		gbc.gridy=0;
		endPanel.add(label,gbc);
		
		gbc.gridwidth=1;
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.weightx=1;
		
		endPanel.add(restart,gbc);
		gbc.gridx=1;
		gbc.gridy=1;
		endPanel.add(exit,gbc);
		//->>>>>>>> fix panel
		
		endFrame.add(endPanel);
		endFrame.pack();
		endFrame.setResizable(false);
		endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		endFrame.setLocationRelativeTo(null);;
		endFrame.setVisible(true);
	}
}
