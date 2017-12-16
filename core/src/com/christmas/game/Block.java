package com.christmas.game;

public class Block {
	private String[] MAP = new String [] {
            "......",
            "......",
            "......",
            "......",
    };
	private int height;
	private int width;
	
	private boolean [][] hasDots;
	
	public Block() {
        height = MAP.length;
        width = MAP[0].length();
        initDotData();
    }
	
	public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
    
    public boolean hasDotAt(int r, int c) {
    	return hasDots[r][c];
    }

	private void initDotData() {
		hasDots = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
                hasDots[r][c] = MAP[r].charAt(c) == '.';
            }
        }
	}
	
	public void removeDotAt(int r, int c) {
        hasDots[r][c] = false;
    }
}
