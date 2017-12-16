package com.christmas.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private SpriteBatch batch;
	private ChristmasBreaker christmasBreaker;
	private World world;
	private BlockRenderer blockRenderer;
	
	private Texture baubleImg;
	private Texture paddleImg;
	
	public static final int BLOCK_SIZE = 70;
	
	public WorldRenderer(ChristmasBreaker christmasBreaker, World world) {
	    this.christmasBreaker = christmasBreaker;
	    batch = christmasBreaker.batch;
	    this.world = world;
	    
	    baubleImg = new Texture("bauble.png");
	    paddleImg = new Texture("paddle.png");
	    
	    blockRenderer = new BlockRenderer(christmasBreaker.batch, world.getBlock());
	}
	
	public void render(float delta) {
		SpriteBatch batch = christmasBreaker.batch;
		Vector2 posBauble = world.getBauble().getPosition();
		Vector2 posPaddle = world.getPaddle().getPosition();
		
		batch.begin();
		batch.draw(baubleImg, posBauble.x, posBauble.y);
        batch.draw(paddleImg, posPaddle.x, posPaddle.y);
        batch.end();
        
        blockRenderer.render();
	}
}
