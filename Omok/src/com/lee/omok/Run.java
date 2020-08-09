package com.lee.omok;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Run extends JFrame implements ActionListener {
	private Container c;
	MapSize size = new MapSize(); // MapSize 객체 생성
	GameRule gr = new GameRule(); // GameRule 객체 생성
	
	public Run(String title) {
		setTitle(title); // JFrame 타이틀 설정
		setBounds(200, 20, 650, 750); // 위치 가로, 위치 세로, 가로 크기, 세로 크기
		c = getContentPane(); // 타이틀 밑에 body 부분
		c.setLayout(null);
		Map m = new Map(size, gr); // Map 객체 생성
		setContentPane(m); // 바디에 맵 사이즈, 룰 결정
		MouseController mc = new MouseController(gr, size, m, this); // MouserController 객체 생성
		addMouseListener(mc); // 마우스 이벤트 처리
		setVisible(true); // 화면에 보여짐
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame 종료
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 버튼클릭시 발동되는 메소드
		gr.init();
	}
	
}
