package com.christmas.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class World {
	private ChristmasBreaker christmasBreaker;
	private Bauble bauble;
	private Paddle paddle;
	private Block block;
	
	public int score;
	public int totalBlock;
	
	public boolean ballFall;
	
	Sound sound;
	
	World(ChristmasBreaker christmasBreaker){
		sound = Gdx.audio.newSound(Gdx.files.internal("song.mp3"));
		sound.play(1.0f);
		
		this.christmasBreaker = christmasBreaker;
		
		bauble = new Bauble(350, 70, this);
		paddle = new Paddle(300, 20);
		block = new Block();
		
		score = 0;
		totalBlock = 24;
		regisHitBlock();
		
		ballFall = false;
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
		if(totalBlock > 0 && (ballFall == false)) {
			bauble.update(delta);
			paddle.update(delta);
		}        
		else {
			sound.stop();
		}
    }
}
