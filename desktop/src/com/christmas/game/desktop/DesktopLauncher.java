package com.christmas.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.christmas.game.ChristmasBreaker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = ChristmasBreaker.WIDTH;
		config.height = ChristmasBreaker.HEIGHT;
		new LwjglApplication(new ChristmasBreaker(), config);
	}
}
