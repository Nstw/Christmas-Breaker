package com.christmas.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private SpriteBatch batch;
	private ChristmasBreaker christmasBreaker;
	private World world;
	
	private Texture baubleImg;
	private Texture paddleImg;
	
	private Sprite paddleSprite;
	private Sprite baubleSprite;
	
	public WorldRenderer(ChristmasBreaker christmasBreaker, World world) {
	    this.christmasBreaker = christmasBreaker;
	    batch = christmasBreaker.batch;
	    this.world = world;
	    
	    baubleImg = new Texture("bauble.png");
	    baubleSprite = new Sprite(baubleImg);
		baubleSprite.setPosition(350, 70);
		
	    paddleImg = new Texture("paddle.png");
	    paddleSprite = new Sprite(paddleImg);
		paddleSprite.setPosition(300, 20);
	}
	
	public void render(float delta) {
		SpriteBatch batch = christmasBreaker.batch;
		Vector2 posBauble = world.getBauble().getPosition();
		Vector2 posPaddle = world.getPaddle().getPosition();
		
		batch.begin();
		baubleSprite.setPosition(posBauble.x, posBauble.y);
        baubleSprite.draw(batch);
        
        paddleSprite.setPosition(posPaddle.x, posPaddle.y);
        paddleSprite.draw(batch);
        batch.end();
	}
}
