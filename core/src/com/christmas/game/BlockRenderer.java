package com.christmas.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class BlockRenderer {	
	private Block block;
    private SpriteBatch batch;
    private Texture reindeerImg;
    
    public BlockRenderer(SpriteBatch batch, Block block) {
        this.block = block;
        this.batch = batch;
        reindeerImg = new Texture("reindeer.png");
    }
    
    public void render() {    	
    	batch.begin();
        for(int r = 0; r < block.getHeight(); r++) {
            for(int c = 0; c < block.getWidth(); c++) {
            	int x = c * WorldRenderer.BLOCK_SIZE + 180;
                int y = ChristmasBreaker.HEIGHT - (r * WorldRenderer.BLOCK_SIZE) - WorldRenderer.BLOCK_SIZE - 50;

                if(block.hasDotAt(r, c)) {
                    batch.draw(reindeerImg, x, y);                             
                }
            }
        }
        batch.end();
    }    
}
