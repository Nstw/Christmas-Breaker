package com.christmas.game;

import java.util.Vector;

import com.badlogic.gdx.math.Vector2;

public class Bauble {
	private Vector2 position;
	
	private int speedY;
	private int speedX;
	
	public Bauble(int x, int y) { //Vector2
		position = new Vector2(x,y);
		speedX = 5;
		speedY = 5;
	}

	public Vector2 getPosition() {
		return position;
	}
	
	public void update(float delta) {
		position.x += speedX;
		position.y += speedY;
		
		checkIsHitBorders();
	}
	
	public void isHitPaddle() {
		position.x -= (speedX * -1);
		speedY *= -1;
		
	}
	
	public void checkIsHitBorders() {
		if(position.x >= 800 || position.x <= 0) {
			speedX *= -1;
		}
		if(position.y >= 600) {
			speedY *= -1;
		}
	}	
	/*
	public void checkIsHitPaddle() {
		if((Math.abs(posXpaddle - this.position.x) <= 40 && Math.abs(posYpaddle - this.position.y) <= 40)) {
			speedX *= -1;
			speedY *= -1;
		}
		
	}
	*/
}
