package com.christmas.game;

import com.badlogic.gdx.math.Vector2;

public class Bauble {
	private Vector2 position;
	
	private int ySpeed;
	private int xSpeed;
	
	private World world;
	
	public Bauble(int x, int y, World world) {
		position = new Vector2(x,y);
		xSpeed = 3;
		ySpeed = 3;
		
		this.world = world;				
	}

	public Vector2 getPosition() {
		return position;
	}
	
	public void update(float delta) {
		position.x += xSpeed;
		position.y += ySpeed;		
		
		checkIsHitBorders();
		isHitPaddle();
	}
	
	public void isHitPaddle() {
		if( ( (this.position.y <= (world.getPaddle().getPosition().y + 2)) && (this.position.y >= (world.getPaddle().getPosition().y -2)) ) &&  
			(this.position.x >= (world.getPaddle().getPosition().x)) && (this.position.x <= (world.getPaddle().getPosition().x + 128)) ){
				position.x -= xSpeed * (-1);
				ySpeed *= -1;
		}
	}
	
	public void isHitBlock() {
				
	}
	
	public void checkIsHitBorders() {
		if(position.x <= 0) {
			position.x = 0;
			xSpeed *= -1;
		}
		if(position.x >= 800) {
			position.x = 800;
			xSpeed *= -1;
		}
		if(position.y >= 600) {
			position.y = 600;
			ySpeed *= -1;
		}
	}	
}
