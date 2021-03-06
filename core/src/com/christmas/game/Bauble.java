package com.christmas.game;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bauble {
	private Vector2 position;
	
	private int ySpeed;
	private int xSpeed;
	
	private World world;
	
	public interface HitBlock {
        void notifyHitBlock();			
    }
	
	private List<HitBlock> list;
	
	public Bauble(int x, int y, World world) {
		position = new Vector2(x,y);
		xSpeed = 3;
		ySpeed = 4;
		
		this.world = world;		
		
		list = new LinkedList<HitBlock>();
	}
	
	public void regisHitBlock(HitBlock l) {
        list.add(l);
	}
 
	private void notifyHitBlock() {
		for(HitBlock l : list) {
            l.notifyHitBlock();
		}
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
		if(position.x >= 760) {
			position.x = 760;
			xSpeed *= -1;
		}
		if(position.y >= 580) {
			position.y = 580;
			ySpeed *= -1;
		}
		if(position.y < -100) {
			world.ballFall = true;
		}
	}
	
	public void isHitPaddle() {
		if( ( (this.position.y <= (world.getPaddle().getPosition().y + 2)) && (this.position.y >= (world.getPaddle().getPosition().y -2)) ) &&  
			(this.position.x >= (world.getPaddle().getPosition().x - 40)) && (this.position.x <= (world.getPaddle().getPosition().x + 120)) ){
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
                    	notifyHitBlock();
                    	
                    	if(position.x + 19 <= blockRect.x || position.x + 1 >= blockRect.x + blockRect.width) {
                    		xSpeed *= -1;
                    	} else {
                    		ySpeed *= -1;
                    	}                    	
                    	break;
                    }
				}
			}
		}
	}
}
