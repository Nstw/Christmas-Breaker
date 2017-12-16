package com.christmas.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Paddle {
	private Vector2 position;
	
	public Paddle(int x, int y) {
		position = new Vector2(x, y);		
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void update(float delta) {
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            position.x -= 10;
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            position.x += 10;
        }        
	}	
}