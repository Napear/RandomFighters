package com.radical2studios.randomfighter.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.radical2studios.randomfighter.RFighter;

public class MenuScreen extends ScreenAdapter{

  private Stage stage;
  private Texture background;
  private RFighter parent;

  public MenuScreen(RFighter rFighter) {
    stage = new Stage(new ScreenViewport());
    parent = rFighter;
  }

  @Override
  public void show() {
    Gdx.input.setInputProcessor(stage);
    Table table = new Table();
    table.setFillParent(true);    
    table.setDebug(false);
    stage.addActor(table);
		background = parent.assets.manager.get(parent.assets.BACKGROUND_IMG);
    Skin skin = parent.assets.manager.get(parent.assets.SKIN_UI);

    TextButton newBattle = new TextButton("New Battle", skin);
    TextButton exit = new TextButton("Exit", skin);

    table.add(newBattle).fillX().uniformX();
    table.row().pad(10, 0, 10, 0);
    table.add(exit).fillX().uniformX();

    exit.addListener(new ChangeListener(){
      @Override
      public void changed(ChangeEvent event, Actor actor) {
       Gdx.app.exit();        
      }
    });

    newBattle.addListener(new ChangeListener(){
      @Override
      public void changed(ChangeEvent event, Actor actor) {
         parent.changeScreen(ScreenType.BATTLE);
      }
    });
  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(0, 0, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));

    stage.getBatch().begin();
    stage.getBatch().draw(background, 0, 0);
    stage.getBatch().end();

    stage.draw();
  }

  @Override
  public void hide() {
    Gdx.input.setInputProcessor(null);
  }

  @Override
  public void resize(int width, int height) {
    stage.getViewport().update(width, height);
  }

  @Override
  public void dispose() {
    background.dispose();
    stage.dispose();
  }
  
}
