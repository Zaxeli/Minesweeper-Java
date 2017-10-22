package com.minesweeper.ui;

import java.awt.*;
import javax.swing.*;

import com.minesweeper.ui.listeners.*;

public class GameUI{
	
	public JFrame frame;
	public JPanel panel;
	public Block[][] blar;
	public JLabel l1;
	
	//private int[][] minestatus;
	
	public final Dimension blockDimensions = new Dimension(25,25);
	
	private GridBagConstraints gbc;
	
	public boolean start=true;
	
	public int mines,boardx,boardy;
	public int uncovered=0;
	
	public void run()
	{
		
		new GameMenu();
		//ask for mode
		
		//m 10 , x 9 , y 9;
		//m 40 , x 16 , y 16;
		//m 99 , x 16 , y 30;
		
		//build(10,9,9);
	}
	
	public void build(int minecount,int gx, int gy) {
		boardx = gx;
		boardy = gy;
		mines = minecount;
		
		frame = new JFrame("game");
		
		frame.setSize(100, 100);
		frame.setResizable(false);
		
		
		panel = new JPanel(new GridBagLayout());
		
		gbc = new GridBagConstraints();
		
		blar = new Block[gx][gy];
		//minestatus = new int[5][5];
		
		for(int i=0;i<gx;i++) {
			for(int j=0;j<gy;j++) {
				//String s = Integer.toString((i+1)*100 + j+1);
				gbc.gridx=i;
				gbc.gridy=j;
				blar[i][j] = (Block) new Block(" ");
				
				blar[i][j].setName("btn:"+i+","+j);
				
				blar[i][j].setMargin(new Insets(0, 0, 0, 0));
				blar[i][j].setPreferredSize(blockDimensions);
				blar[i][j].addActionListener(new BlockListener(this,blar[i][j]));
				blar[i][j].addMouseListener(new BlockListener(this,blar[i][j]));
				panel.add(blar[i][j],gbc);
				
			}
		}
		
		/*b1 = new JButton();		
		b1.setText("9");
		b1.addActionListener(this);
		b1.setName("btn1");		
		b2 = new JButton();
		b2.setText("0");		
		panel.add(b1,gbc);
		panel.add(b2);*/
		
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public void mapmines(int a, int gx, int gy) {
		for(int k=0;k<a;k++) {
			int x=(int) (Math.random() * gx);
			int y=(int) (Math.random() * gy);
			if(!blar[x][y].checkmine()) {
				blar[x][y].setmine(true);
			}
			else {k--;}
		}
		
		/*for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				gbc.gridx=i;
				gbc.gridy=j;
			}
		}*/
	}

	
	public boolean checkEnd() {
		if(uncovered == ((boardx*boardy) - mines)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void end(boolean isWin) {
		String s;	
		
		if(isWin) {
			s="You Win!";
		}
		else {
			s="You Lose!";
		}
		
		new GameEnd(s);
		
		frame.dispose();
		
	}
}
