package com.christmas.game;

public class World {
	private ChristmasBreaker christmasBreaker;
	private Bauble bauble;
	private Paddle paddle;
	private Block block;
	
	World(ChristmasBreaker christmasBreaker){
		this.christmasBreaker = christmasBreaker;
		
		bauble = new Bauble(350, 70, this);
		paddle = new Paddle(300, 20);
		block = new Block();
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

	public void update(float delta) {
        bauble.update(delta);
        paddle.update(delta);       
        
    }
}
