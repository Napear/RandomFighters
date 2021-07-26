package com.radical2studios.randomfighter.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.radical2studios.randomfighter.RFighter;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setTitle("Trial By Combat");
		config.setResizable(false);
		config.setWindowedMode(1280, 720);

		new Lwjgl3Application(new RFighter(), config);
	}
}
