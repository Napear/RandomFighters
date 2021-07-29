package com.radical2studios.randomfighter.views;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.radical2studios.randomfighter.FighterAssets;
import com.radical2studios.randomfighter.RFighter;
import com.radical2studios.randomfighter.controllers.Fighter;
import com.radical2studios.randomfighter.controllers.FighterAnimationType;
import com.badlogic.gdx.graphics.GL20;


public class BattleScreen extends ScreenAdapter {

	private Texture background;
  private RFighter parent;
  private Stage stage;
  private Fighter redFighter, blueFighter;

  public BattleScreen(RFighter rFighter) {
    parent = rFighter;
    stage = new Stage(new ScreenViewport());
    background = parent.assets.get(FighterAssets.BACKGROUND_IMG);
  }

  @Override
  public void show() {
    Gdx.input.setInputProcessor(stage);
		TextureAtlas redAtlas = parent.assets.get(FighterAssets.RED_KNIGHT_ATLAS);
		TextureAtlas blueAtlas = parent.assets.get(FighterAssets.BLUE_KNIGHT_ATLAS);
    redFighter = new Fighter("Red Fighter", redAtlas, 64, 62);
    blueFighter = new Fighter("Blue Fighter", blueAtlas, 1280-(128+(294/2)), 62);
    blueFighter.flip();
    stage.addActor(redFighter);
    stage.addActor(blueFighter);
  }

  @Override
  public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));

		stage.getBatch().begin();
		stage.getBatch().draw(background, 0, 0);
		stage.getBatch().end();
    stage.draw();

    if(Gdx.input.isKeyPressed(Keys.ESCAPE)) parent.changeScreen(ScreenType.MENU);
    if(Gdx.input.isKeyPressed(Keys.UP)) redFighter.setAnimation(FighterAnimationType.ATTACK);
    if(Gdx.input.isKeyPressed(Keys.DOWN)) redFighter.setAnimation(FighterAnimationType.IDLE);
    if(Gdx.input.isKeyPressed(Keys.LEFT)) {
      blueFighter.setHealth(0);
      blueFighter.setAnimation(FighterAnimationType.DIE);
    }
    if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
      blueFighter.setHealth(3);
      blueFighter.setAnimation(FighterAnimationType.IDLE);
    }
  }

  @Override
  public void hide() {
    Gdx.input.setInputProcessor(null);
    redFighter.remove();
    blueFighter.remove();
  }

  @Override
  public void dispose() {
		background.dispose();
    stage.dispose();    
  }
  
}
