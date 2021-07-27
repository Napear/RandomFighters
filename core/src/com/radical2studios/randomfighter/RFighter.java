package com.radical2studios.randomfighter;

import com.badlogic.gdx.Game;
import com.radical2studios.randomfighter.views.BattleScreen;
import com.radical2studios.randomfighter.views.EndScreen;
import com.radical2studios.randomfighter.views.LoadingScreen;
import com.radical2studios.randomfighter.views.MatchUpScreen;
import com.radical2studios.randomfighter.views.MenuScreen;
import com.radical2studios.randomfighter.views.ScreenType;

public class RFighter extends Game {
	
	private MenuScreen menuScreen;
	private LoadingScreen loadingScreen;
	private MatchUpScreen matchUpScreen;
	private BattleScreen battleScreen;
	private EndScreen endScreen;
	public FigherAssets assets;

	public void changeScreen(ScreenType screen) {
		switch(screen){
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(this);
				setScreen(menuScreen);			
				break;
			case LOADING:
				if(loadingScreen == null) loadingScreen = new LoadingScreen(this);
				setScreen(loadingScreen);
				break;
			case MATCH_UP:
				if(matchUpScreen == null) matchUpScreen = new MatchUpScreen(this);
				setScreen(matchUpScreen);
				break;
			case BATTLE:
				if(battleScreen == null) battleScreen = new BattleScreen(this);
				setScreen(battleScreen);
				break;
			case END:
				if(endScreen == null) endScreen = new EndScreen(this);
				setScreen(endScreen);				
				break;
		}
	}
	
	@Override
	public void create () {
		assets = new FigherAssets();
		assets.loadImages();
		assets.loadSkin();
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
	}
	
}
