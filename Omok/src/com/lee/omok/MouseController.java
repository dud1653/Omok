package com.lee.omok;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

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
	public void mousePressed(MouseEvent event) { // 마우스 클릭 메소드 오버라이드
		int x = (int)Math.round(event.getX()/(double) ms.getCELL()) - 1; 
		int y = (int)Math.round(event.getY()/(double) ms.getCELL()) - 1;
		
		if(gr.checkInput(x, y) == false) { // 만약 돌을 놓을 수 없는 자리면 메소드 종료
			return;
		}
		
		Stone stone = new Stone(x, y, gr.getPlayerOrder()); // 바둑돌 객체 생성
		gr.inputStone(stone); // 바둑판에 돌 놓음
		gr.nextPlayer(); // 다음 플레이어 메소드 호출
		m.repaint(); // 맵 다시 그리기
		if(gr.endGame(stone) == true) {
			String msg;
			if(stone.getColor() == 1) {
				msg = "검은돌 승리!";
			} else {
				msg = "흰색돌 승리!";
			}
			showWin(msg);
			gr.init();
		}
		}
	
	public void showWin(String msg) {
		JOptionPane.showMessageDialog(r, msg, "", JOptionPane.INFORMATION_MESSAGE);
	}
}
