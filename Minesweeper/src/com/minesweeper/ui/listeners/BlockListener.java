package com.minesweeper.ui.listeners;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import com.minesweeper.ui.*;

public class BlockListener implements ActionListener, MouseListener{
	
	GameUI gameUI;
	Block b;
	
	public BlockListener(GameUI incGUI, Block incButton) {
		super();
		gameUI = incGUI;
		b = incButton;
		
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		b.isClicked=true;
		clickBlock(b);
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseclicked");
		if(SwingUtilities.isLeftMouseButton(arg0)) {
			System.out.println("Left mouseclicked");
		}
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseentered");
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseexited");
		
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("mousepressed");
		if(SwingUtilities.isRightMouseButton(arg0)) {
			
			//System.out.println("Left mousepressed \n mark");
			
			if(b.flagged) {
				b.setEnabled(true);
				b.setText(" ");
				b.flagged=false;
			}
			else{
				b.setEnabled(false);
				b.setText("F");
				b.flagged=true;
			}
			
		}
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mousereleased");
		if(SwingUtilities.isLeftMouseButton(arg0)) {
			System.out.println("Left mousereleased");
			//clickBlock();
		}
		
	}
	public void clickBlock(Block clickedBlock) {
		GridBagLayout gb = (GridBagLayout) gameUI.panel.getLayout();
		//Block b = (Block) e.getSource();
		GridBagConstraints gbc = gb.getConstraints(clickedBlock);
		gameUI.uncovered++;
		
		gameUI.l1 = new JLabel("label", SwingConstants.CENTER);
		
		if(gameUI.start==true) {
			gameUI.mapmines(gameUI.mines,gameUI.boardx,gameUI.boardy);
			//int reloc = b.cleararound(blar, gbc.gridx, gbc.gridy);
			//Here TO DO
			
			gameUI.mapmines(clickedBlock.checkaround(gameUI.blar, gbc.gridx, gbc.gridy),gameUI.boardx,gameUI.boardy);
			clickedBlock.cleararound(gameUI.blar, gbc.gridx, gbc.gridy);
			gameUI.start=false;
		}
		
		
		
		if(clickedBlock.checkmine()) {
			gameUI.l1.setText("m");
			gameUI.end(false);
			//Popup: lose
		}
		else{
			//l1.setText(b.getText());
			gameUI.l1.setText(Integer.toString(clickedBlock.checkaround(gameUI.blar, gbc.gridx, gbc.gridy)));
			if(clickedBlock.checkaround(gameUI.blar, gbc.gridx, gbc.gridy)==0) {
				gameUI.l1.setText("0");
				clickAround();
			}
			if(gameUI.checkEnd()) {
				gameUI.end(true);
			}
		}
		
		if(gameUI.start==true) {gameUI.l1.setText("0");}
		
		gameUI.l1.setPreferredSize(gameUI.blockDimensions);		
		
		gameUI.panel.revalidate();
		gameUI.panel.remove(clickedBlock);
		gameUI.panel.add(gameUI.l1,gbc);
		gameUI.frame.repaint();	
		
		System.out.println("button "+clickedBlock.getName()+" clicked");
		
	
	}


	private void clickAround() {
	}

}
