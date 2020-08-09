package com.lee.omok;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class Map extends JPanel{
	private MapSize size;
	private GameRule gr;
	private final int STONE_SIZE = 28; // 돌 사이즈 
	
	public Map(MapSize m, GameRule gr) {
		setBackground(new Color(206, 167, 61));
		size = m;
		setLayout(null);
		this.gr = gr;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		board(g);
		drawStone(g);
	}
	public void board(Graphics g) {
		for(int i = 1; i <= size.getSIZE(); i++) {
			g.drawLine(size.getCELL(), i*size.getCELL(), size.getCELL()*size.getSIZE(), i*size.getCELL());
			g.drawLine(i*size.getCELL(), size.getCELL(), i*size.getCELL(), size.getCELL()*size.getSIZE());
		}
	}
	
	public void drawStone(Graphics g) {
		for(int x = 0; x < size.getSIZE(); x++) {
			for(int y = 0; y < size.getSIZE(); y++) {
				if(gr.getMap()[x][y] == 1) {
					drawBlack(g, x, y);
				} else if(gr.getMap()[x][y] == 2) {
					drawWhite(g, x, y);
				}
			}
		}
	}
	
	public void drawBlack(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillOval(x*size.getCELL()+15, y*size.getCELL()-15, STONE_SIZE, STONE_SIZE);
	}
	public void drawWhite(Graphics g, int x, int y) {
		g.setColor(Color.WHITE);
		g.fillOval(x*size.getCELL()+15, y*size.getCELL()-15, STONE_SIZE, STONE_SIZE);
	}
}
