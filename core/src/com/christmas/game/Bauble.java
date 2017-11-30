package com.christmas.game;

import com.badlogic.gdx.math.Vector2;

public class Bauble {
	private Vector2 position;
	
	private int speed_y;
	private int speed_x;
	
	public Bauble(int x, int y) {
		position = new Vector2(x,y);
		speed_x = 1;
		speed_y = 2;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public void update(float delta) {
		position.x += speed_x;
		position.y += speed_y;
		
		checkIsHitBorders();
	}
	
	public void checkIsHitBorders() {
		if(position.x>=800||position.x<=0) {
			speed_x *= -1;
		}
		if(position.y>=600) {
			speed_y *= -1;
		}
	}	
}
