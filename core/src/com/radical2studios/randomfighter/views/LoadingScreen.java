package com.radical2studios.randomfighter.views;

import com.badlogic.gdx.ScreenAdapter;
import com.radical2studios.randomfighter.RFighter;

public class LoadingScreen extends ScreenAdapter {

  private RFighter parent;

  public LoadingScreen(RFighter rFighter){
    this.parent = rFighter;
  }

  @Override
  public void show() {
    parent.assets.finishLoading();
  }

  @Override
  public void render(float delta) {
    parent.changeScreen(ScreenType.MENU);
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub
    
  }
  
}
