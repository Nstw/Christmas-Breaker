package com.christmas.game;

import com.badlogic.gdx.math.Rectangle;
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
		isHitBlock();
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
	
	public void isHitPaddle() {
		if( ( (this.position.y <= (world.getPaddle().getPosition().y + 2)) && (this.position.y >= (world.getPaddle().getPosition().y -2)) ) &&  
			(this.position.x >= (world.getPaddle().getPosition().x - 30)) && (this.position.x <= (world.getPaddle().getPosition().x + 128)) ){
				position.x -= xSpeed * (-1);
				ySpeed *= -1;
		}
	}
	
	public void isHitBlock() {
		Block block = world.getBlock();
		for(int r = 0; r < block.getHeight(); r++) {
			for(int c = 0; c < block.getWidth(); c++) {
				if(block.hasDotAt(r, c)) {
					int x = c * WorldRenderer.BLOCK_SIZE + 180;
					int y = ChristmasBreaker.HEIGHT - (r * WorldRenderer.BLOCK_SIZE) - WorldRenderer.BLOCK_SIZE - 50;
				
					Rectangle rect = new Rectangle(x, y, WorldRenderer.BLOCK_SIZE - 20, WorldRenderer.BLOCK_SIZE - 20);
                    Rectangle ballRect = new Rectangle(position.x, position.y, 20, 20);
                    Rectangle blockRect = rect;
                    
                    if(ballRect.overlaps(blockRect)) {
                    	block.removeDotAt(r, c);
                    	
                    	if(position.x + 19 <= blockRect.x || position.x + 1 >= blockRect.x + blockRect.width) {
                    		xSpeed *= -1;
                    	}
                    	else {
                    		ySpeed *= -1;
                    	}                    	
                    	break;
                    }
				}
			}
		}
	}
}
