package com.christmas.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
	private ChristmasBreaker christmasBreaker;
	private Bauble bauble;
	private Texture baubleImg;
	private Texture paddleImg;
	private Paddle paddle;
	public GameScreen(ChristmasBreaker christmasBreaker) {
		this.christmasBreaker = christmasBreaker;
		baubleImg = new Texture("bauble.png");
		bauble = new Bauble(100,50);
		
		paddleImg = new Texture("paddle.png");
		paddle = new Paddle(300,20);
	}
	private void update(float delta) {
		bauble.update(delta);
	}
    @Override
    public void render(float delta) {
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = christmasBreaker.batch;
        update(delta);
        batch.begin();
        batch.draw(baubleImg, bauble.getPosition().x, bauble.getPosition().y);
        batch.draw(paddleImg, paddle.getPosition().x, paddle.getPosition().y);
        batch.end();
    }	
	
}
