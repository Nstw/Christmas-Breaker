package com.christmas.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
	private ChristmasBreaker christmasBreaker;
	
	private Texture img;
	public GameScreen(ChristmasBreaker christmasBreaker) {
		this.christmasBreaker = christmasBreaker;
		img = new Texture("bauble.png");
	
	}
    @Override
    public void render(float delta) {
        SpriteBatch batch = christmasBreaker.batch;
        batch.begin();
        batch.draw(img, 100, 100);
        batch.end();
    }	
	
}
