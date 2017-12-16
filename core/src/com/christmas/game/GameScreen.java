package com.christmas.game;

//import java.util.ArrayList;
//import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
	private ChristmasBreaker christmasBreaker;	
	
	//private Bauble bauble;
	//public Paddle paddle;
	//public Reindeer reindeer;
	
	//private Texture baubleImg;
	//private Texture paddleImg;
	//private Texture reindeerImg;
	
	World world;
	WorldRenderer worldRenderer;
	
	//private int posXpaddle = 300;
	//private int posYpaddle = 20;
	
	//private int posXbauble = 350;
	//private int posYbauble = 70;
	
	//private int posXreindeer = 320; //not use now
	//private int posYreindeer = 400; //not use now
	
	//private Sprite paddleSprite;
	//private Sprite baubleSprite;
	//private Sprite reindeerSprite; //not use now
	
	//List<Sprite> reindeerList; //not use now
	
	public GameScreen(ChristmasBreaker christmasBreaker) {
		this.christmasBreaker = christmasBreaker;
		
		//paddleImg = new Texture("paddle.png");		
		//paddleSprite = new Sprite(paddleImg);
		//paddleSprite.setPosition(posXpaddle, posYpaddle);
		//paddle = new Paddle(posXpaddle, posYpaddle);
		
		//baubleImg = new Texture("bauble.png");
		//baubleSprite = new Sprite(baubleImg);
		//baubleSprite.setPosition(posXbauble, posYbauble);
		//bauble = new Bauble(posXbauble, posYbauble);
		
		world = new World(christmasBreaker);
		worldRenderer = new WorldRenderer(christmasBreaker, world);
				
		//bauble = new Bauble(paddle.getPosition(),100,50);
		//bauble = new Bauble(paddle,350,70);
		/*
		reindeerImg = new Texture("reindeer.png");
		reindeerSprite = new Sprite(reindeerImg);
		reindeerSprite.setPosition(posXreindeer, posYreindeer);
		reindeer = new Reindeer(posXreindeer, posYreindeer);
		*/
		//reindeerList = new ArrayList();
		
	}
	
	private void update(float delta) {
		//bauble.update(delta);
		//paddle.update(delta);
		
		world.update(delta);
	}
	
    @Override
    public void render(float delta) {
    	update(delta);
    	
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        //SpriteBatch batch = christmasBreaker.batch;
        
        worldRenderer.render(delta);
        
        //batch.begin();
        
        //reindeerSprite.setPosition(320, 400); //not use now
        //reindeerSprite.draw(batch); //not use now
        
        //batch.draw(baubleImg, bauble.getPosition().x, bauble.getPosition().y); //not use
        //baubleSprite.setPosition(bauble.getPosition().x, bauble.getPosition().y);
        //baubleSprite.draw(batch);
        
        //batch.draw(paddleImg, paddle.getPosition().x, paddle.getPosition().y); //not use
        //paddleSprite.setPosition(paddle.getPosition().x, paddle.getPosition().y);
        //paddleSprite.draw(batch);
        
        //batch.end();
        
        //if(paddleSprite.getBoundingRectangle().overlaps(baubleSprite.getBoundingRectangle())){
		//	bauble.isHitPaddle();
		//}
        /*
        if(reindeerSprite.getBoundingRectangle().overlaps(baubleSprite.getBoundingRectangle())){
			bauble.isHitReindeer();
		}
		*/
    }		
}