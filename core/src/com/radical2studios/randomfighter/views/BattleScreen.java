package com.radical2studios.randomfighter.views;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.radical2studios.randomfighter.RFighter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;


public class BattleScreen extends ScreenAdapter {

	private Texture background;
	private TextureAtlas redAtlas, blueAtlas;
	private TextureRegion otherguy;
	private Animation<TextureRegion> animation1, animation2;
	private float elapsedTime = 0f;
  private RFighter parent;
  private Stage stage;

  public BattleScreen(RFighter rFighter) {
    this.parent = rFighter;
    stage = new Stage(new ScreenViewport());
    Gdx.input.setInputProcessor(stage);
  }

  @Override
  public void show() {
		background = new Texture("bg001.png");
		redAtlas = new TextureAtlas(Gdx.files.internal("knightSprites/redKnight/walk.atlas"));
		blueAtlas = new TextureAtlas(Gdx.files.internal("knightSprites/blueKnight/idle.atlas"));

		animation1 = new Animation<TextureRegion>(1f/(16.5f + MathUtils.random(-0.3f, 0.4f)), redAtlas.getRegions());
		animation2 = new Animation<TextureRegion>(1f/(16.5f + MathUtils.random(-0.3f, 0.4f)), blueAtlas.getRegions());
  }

  @Override
  public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
    elapsedTime += Gdx.graphics.getDeltaTime();
		stage.getBatch().begin();
		stage.getBatch().draw(background, 0, 0);
		stage.getBatch().draw(animation1.getKeyFrame(elapsedTime, true), 64, 62);
		otherguy = animation2.getKeyFrame(elapsedTime, true);
		if(!otherguy.isFlipX()) otherguy.flip(true, false);
		stage.getBatch().draw(otherguy, 1280-(128+(294/2)), 62);
		stage.getBatch().setColor(Color.WHITE);
		stage.getBatch().end();

    stage.draw();

    if(Gdx.input.isKeyPressed(Keys.ESCAPE)) parent.changeScreen(ScreenType.MENU);
  }

  @Override
  public void resize(int width, int height) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void dispose() {
		redAtlas.dispose();
		blueAtlas.dispose();
		background.dispose();
    stage.dispose();    
  }
  
}
