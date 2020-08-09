package com.lee.omok;

public class Stone {
	private int x; // 바둑판의 x축
	private int y; // 바둑판의 y축
	private int color; // 1일 때 검은돌 아닐때 흰돌 
	
	// 생성자
	public Stone(int x, int y, int color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	// 게터세터
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	
	
}
