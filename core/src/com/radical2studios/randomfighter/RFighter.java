package com.radical2studios.randomfighter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class RFighter extends ApplicationAdapter {
	SpriteBatch batch;
	private Texture background;
	private TextureAtlas atlas1, atlas2;
	private TextureRegion otherguy;
	private Animation<TextureRegion> animation1, animation2;
	private float elapsedTime = 0f;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("bg001.png");
		atlas1 = new TextureAtlas(Gdx.files.internal("knightSprites/attack.atlas"));
		atlas2 = new TextureAtlas(Gdx.files.internal("knightSprites/idle.atlas"));

		animation1 = new Animation<TextureRegion>(1f/(16.5f + MathUtils.random(-0.3f, 0.4f)), atlas1.getRegions());
		animation2 = new Animation<TextureRegion>(1f/(16.5f + MathUtils.random(-0.3f, 0.4f)), atlas2.getRegions());
		
	}

	@Override
	public void render () {
		elapsedTime += Gdx.graphics.getDeltaTime();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0);
		batch.setColor(Color.SKY);
		batch.draw(animation1.getKeyFrame(elapsedTime, true), 64, 62);
		otherguy = animation2.getKeyFrame(elapsedTime, true);
		if(!otherguy.isFlipX()) otherguy.flip(true, false);
		batch.setColor(Color.SALMON);
		batch.draw(otherguy, 1280-(128+(294/2)), 62);
		batch.setColor(Color.WHITE);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		atlas1.dispose();
		atlas2.dispose();
		background.dispose();
	}
}
