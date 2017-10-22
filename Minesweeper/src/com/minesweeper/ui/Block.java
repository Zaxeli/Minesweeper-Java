package com.minesweeper.ui;


import javax.swing.JButton;

public class Block extends JButton{

	private static final long serialVersionUID = 1L;
	private boolean isMine=false;
	private int x,y;
	public boolean flagged=false;
	public boolean isClicked=false;
	
	public Block(String s) {		
		super(s);
	}
	public void setpos(int a, int b) {
		x=a;
		y=b;
	}
	public int getposx() {
		return x;
	}
	public int getposy() {
		return y;
	}
	public void setmine(boolean type) {
		isMine = type; 
	}
	public boolean checkmine() {
		return isMine; 
	}
	public int checkaround(Block[][] blar, int posi, int posj) {
		//includes self position
		
		int MinesAround=0;
		for(int i=posi-1;i<=posi+1;i++) {
			for(int j=posj-1;j<=posj+1;j++) {
				try {
					if(blar[i][j].isMine==true) {
						MinesAround++;
					}
				}catch(Exception e) {e.printStackTrace();System.out.println("oob");}
			}
		}
		
		return MinesAround;
	}
	public int cleararound(Block[][] blar, int posi, int posj) {
		//clears self as well
		
		int MinesAround=0;
		for(int i=posi-1;i<=posi+1;i++) {
			for(int j=posj-1;j<=posj+1;j++) {
				
				
				try {
					if(blar[i][j].isMine==true) {
						blar[i][j].setmine(false);
						MinesAround++;
					}
				}catch(Exception e) {e.printStackTrace();System.out.println("oob");}	
				
			}
		}
		return MinesAround;
	}
}
