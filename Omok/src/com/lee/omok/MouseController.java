package com.lee.omok;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {
	private GameRule gr;
	private MapSize ms;
	private Map m;
	private Run r;
	
	public MouseController(GameRule gr, MapSize ms, Map m, Run r) {
		super();
		this.gr = gr;
		this.ms = ms;
		this.m = m;
		this.r = r;
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		int x = (int)Math.round(event.getX()/(double) ms.getCELL()) - 1;
		int y = (int)Math.round(event.getY()/(double) ms.getCELL()) - 2;
		
		if(gr.checkInput(x, y) == false) {
			return;
		}
		
		Stone stone = new Stone(x, y, gr.getPlayerOrder());
		}
}
