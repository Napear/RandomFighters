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

	public void changeScreen(ScreenType screen) {
		switch(screen){
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(this);
				this.setScreen(menuScreen);			
				break;
			case LOADING:
				if(loadingScreen == null) loadingScreen = new LoadingScreen(this);
				this.setScreen(loadingScreen);
				break;
			case MATCH_UP:
				if(matchUpScreen == null) matchUpScreen = new MatchUpScreen(this);
				this.setScreen(matchUpScreen);
				break;
			case BATTLE:
				if(battleScreen == null) battleScreen = new BattleScreen(this);
				this.setScreen(battleScreen);
				break;
			case END:
				if(endScreen == null) endScreen = new EndScreen(this);
				this.setScreen(endScreen);				
				break;
		}
	}
	
	@Override
	public void create () {
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
	}

	@Override
	public void render () {
		
	}
	
	@Override
	public void dispose () {

	}
}
