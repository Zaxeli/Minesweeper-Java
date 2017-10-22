package com.minesweeper.ui;

import java.awt.*;
import javax.swing.*;
import com.minesweeper.ui.listeners.*;

public class GameMenu {

	public GameMenu() {
		JFrame menuframe = new JFrame("menu");
		GridBagLayout menuGB = new GridBagLayout();
		GridBagConstraints menuGBC = new GridBagConstraints();
		JPanel menupanel = new JPanel(menuGB);
		//menuGB.
		JButton button[] = new JButton[3];
		//Dimension d = new Dimension(150,70);
		JLabel menu = new JLabel("Menu");
		JLabel chs = new JLabel("Choose Mode:");
		
		String lv,brd;
		int mn;
		
		for(int i=0;i<3;i++) {
			switch(i) {
			case 0:
				lv="Beginner";
				brd="9 x 9";
				mn=10;
				break;
			case 1:
				lv="Intermediate";
				brd="16 x 16";
				mn=40;
				break;
			case 2:
				lv="Advanced";
				brd="16 x 30";
				mn=99;
				break;
			default:
				lv="";
				brd="";
				mn=0;
			}
			
			button[i] = new JButton("<html><u><b>"+lv+"</u></b><br>Board: "+brd+"<br>Mines: "+mn+"</html>");
			button[i].addActionListener(new MenuModeListener(menuframe,i));
			
			button[i].setHorizontalAlignment(SwingConstants.LEFT);
			
			menuGBC.gridx=i;
			menuGBC.gridy=3;
			menupanel.add(button[i],menuGBC);
		}
		menuGBC.gridx=1;
		menuGBC.gridy=0;
		menu.setFont(new Font("Serif", Font.PLAIN, 25));
		menu.setForeground(Color.DARK_GRAY);
		menupanel.add(menu,menuGBC);
		
		menuGBC.gridx=0;
		menuGBC.gridy=1;
		chs.setHorizontalAlignment(SwingConstants.LEFT);
		menupanel.add(chs,menuGBC);
		
		menuframe.add(menupanel);
		menuframe.pack();
		//menuframe.setSize(350,200);
		menuframe.setResizable(false);
		menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuframe.setLocationRelativeTo(null);
		menuframe.setVisible(true);

	}
}

