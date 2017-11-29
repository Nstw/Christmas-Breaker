package com.christmas.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
	private ChristmasBreaker christmasBreaker;
	private int x;
	private int y;
	
	private Texture img;
	public GameScreen(ChristmasBreaker christmasBreaker) {
		this.christmasBreaker = christmasBreaker;
		img = new Texture("bauble.png");
		x =100;
		y = 100;
	}
	private void update(float delta) {
		x+=5;
	}
    @Override
    public void render(float delta) {
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = christmasBreaker.batch;
        update(delta);
        batch.begin();
        batch.draw(img, x, y);
        batch.end();
    }	
	
}
