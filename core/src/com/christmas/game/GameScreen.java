package com.christmas.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
	private ChristmasBreaker christmasBreaker;	
	
	private Bauble bauble;
	public Paddle paddle;
	
	private Texture baubleImg;
	private Texture paddleImg;
	
	private int posXpaddle = 300;
	private int posYpaddle = 20;
	
	private int posXbauble = 350;
	private int posYbauble = 70;
	
	private Sprite paddleSprite;
	private Sprite baubleSprite;
	
	public GameScreen(ChristmasBreaker christmasBreaker) {
		this.christmasBreaker = christmasBreaker;
		
		paddleImg = new Texture("paddle.png");		
		paddleSprite = new Sprite(paddleImg);
		paddleSprite.setPosition(posXpaddle, posYpaddle);
		paddle = new Paddle(posXpaddle, posYpaddle);
		
		baubleImg = new Texture("bauble.png");
		baubleSprite = new Sprite(baubleImg);
		baubleSprite.setPosition(posXbauble, posYbauble);
		bauble = new Bauble(posXbauble, posYbauble);
		
		
	//	bauble = new Bauble(paddle.getPosition(),100,50);
		//bauble = new Bauble(paddle,350,70);
	/*
		if(paddleSprite.getBoundingRectangle().overlaps(baubleSprite.getBoundingRectangle())){
			posXbauble *= -1;
			posYbauble *= -1;
		}
	*/			
	}
	
	private void update(float delta) {
		bauble.update(delta);
		paddle.update(delta);
	}
	
    @Override
    public void render(float delta) {
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        SpriteBatch batch = christmasBreaker.batch;
        update(delta);
        
        batch.begin();
        //batch.draw(baubleImg, bauble.getPosition().x, bauble.getPosition().y);
        baubleSprite.setPosition(bauble.getPosition().x, bauble.getPosition().y);
        baubleSprite.draw(batch);
        
        //batch.draw(paddleImg, paddle.getPosition().x, paddle.getPosition().y);
        paddleSprite.setPosition(paddle.getPosition().x, paddle.getPosition().y);
        paddleSprite.draw(batch);
        batch.end();
        
        if(paddleSprite.getBoundingRectangle().overlaps(baubleSprite.getBoundingRectangle())){
			bauble.isHitPaddle();
		}
    }		
}