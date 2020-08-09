package com.lee.omok;

public class GameRule {
	private final int PLAYER_CNT = 2; // 플레이어 수 
	private int playerOrder = 1; // 플레이어 순서
	private int maxSize = 20; // 바둑판 사이
	private int map[][] = new int[maxSize][maxSize]; // 바둑판의 가로세로 길이
	
	public void init() {
		for(int i = 0; i < maxSize; i++) {
			for(int j = 0; j < maxSize; j++) {
				map[i][j] = 0; // map 배열의 모든 인덱스에 0 대입
			}
		}
	}
	
	// 순서 정해주는 메소드
	public void nextPlayer() {
		switch(playerOrder) {
		case 1: playerOrder = 2; break; // 1의 순서가 들어오면 2로 
		case 2: playerOrder = 1; break; // 2의 순서가 들어오면 1로
		default: break;
		}
	}
	
	// 게임이 끝날 상황 메소드
	public boolean endGame(Stone s) {
		int nowColor = s.getColor();
		int dir[][] = { // 가운데 돌을 중심으로 상하좌우 대각선의 방향
				{0,1},{0,-1},
				{-1,0},{1,0},
				{-1,1},{1,-1},
				{1, 1},{-1,-1}
		};
		for(int i = 0; i < dir.length; i+=2) { // 두 개씩 한 묶음으로 처리하기 위해 2씩 증가
			int sameCnt = 1; // 처음에 한개는 무조건 같은 색깔이 1이다.
			int locX = s.getX(); // x좌표를 누적할 변수를 생성
			int locY = s.getY(); // y좌표를 누적할 변수를 생성
			
			for(int j = 0; j < 5; j++) { // 한 쪽 방향 검사
				locX += dir[i][0]; 
				locY += dir[i][1]; 
				if(locX < 0 || locX >= maxSize || locY < 0 || locY >= maxSize) break; // x와 y값이 0보다 작거나 19보다 크면 Cnt를 올리지 않음
				if(nowColor != map[locX][locY]) break; // 현재 색깔과 검사할 색깔이 다르면 Cnt를 올리지않음
				
				sameCnt++; // 같은 돌 갯수가 나오면 1증가
			}
			locX = s.getX(); // 원점으로 돌아가서 검사
			locY = s.getY(); // 원점으로 돌아가서 검사
			
			for(int j = 0; j < 5; j++) { // 반대쪽 방향 검사
				locX += dir[i+1][0]; 
				locY += dir[i+1][1];
				if(locX < 0 || locX >= maxSize || locY < 0 || locY >= maxSize) break; // x와 y값이 0보다 작거나 19보다 크면 Cnt를 올리지 않음
				if(nowColor != map[locX][locY]) break; // 현재 색깔과 검사할 색깔이 다르면 Cnt를 올리지않음
				
				sameCnt++; // 같은 돌 갯수가 나오면 1증가
			}
			if(sameCnt >= 5) {
				return true; // 같은 숫자가 5개 나오면 true
			}
		}
		return false;
	}
	
	public void inputStone(Stone s) { // map 배열의 해당 인덱스에 돌 색깔 숫자 대입
		map[s.getX()][s.getY()] = s.getColor();
	}
	
	public boolean checkInput(int x, int y) { // 돌을 놓을 자리에 돌이 있는지, 바둑판을 안넘어가는지 검사
		if(map[x][y] != 0 || x < 0 || x >= maxSize || y < 0 || y >= maxSize) {
			return false;
		}
		return true;
	}
	public int[][] getMap() {
		return map;
	}
	public int getPlayerOrder() {
		return playerOrder;
	}
	
}
