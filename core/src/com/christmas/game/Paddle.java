package com.christmas.game;

import com.badlogic.gdx.math.Vector2;

public class Paddle {
	private Vector2 position;
	//private int speed_y;
	//private int speed_x;
	public Paddle(int x, int y) {
		position = new Vector2(x,y);
		//speed_x = 1;
		//speed_y = 2;
	}
	
	public Vector2 getPosition() {
		return position;
	}

}
