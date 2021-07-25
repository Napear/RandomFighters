package com.radical2studios.randomfighter.views;

import com.badlogic.gdx.Screen;
import com.radical2studios.randomfighter.RFighter;

public class LoadingScreen implements Screen {

  private RFighter parent;

  public LoadingScreen(RFighter rFighter){
    this.parent = rFighter;
  }

  @Override
  public void show() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void render(float delta) {
    parent.changeScreen(ScreenType.MENU);
  }

  @Override
  public void resize(int width, int height) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void pause() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void resume() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void hide() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub
    
  }
  
}
