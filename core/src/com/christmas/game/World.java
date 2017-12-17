package com.christmas.game;

public class World {
	private ChristmasBreaker christmasBreaker;
	private Bauble bauble;
	private Paddle paddle;
	private Block block;
	
	public int score;
	public int totalBlock;
	
	World(ChristmasBreaker christmasBreaker){
		this.christmasBreaker = christmasBreaker;
		
		bauble = new Bauble(350, 70, this);
		paddle = new Paddle(300, 20);
		block = new Block();
		
		score = 0;
		totalBlock = 24;
		regisHitBlock();
	}
	
	Bauble getBauble() {
		return bauble;
	}
	
	Paddle getPaddle() {
		return paddle;
	}
	
	Block getBlock() {
		return block;
	}
	
	public int getScore() {
		return score;
	}
	
	private void regisHitBlock() {
        bauble.regisHitBlock(new Bauble.HitBlock() {
            @Override
            public void notifyHitBlock() {
                score += 1;
                totalBlock -= 1;
            }
        });
    }

	public void update(float delta) {
		if(totalBlock > 0) {
			bauble.update(delta);
			paddle.update(delta);
		}
        
    }
}
