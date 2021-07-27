package com.radical2studios.randomfighter;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader.SkinParameter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class FigherAssets {

  public final AssetManager manager = new AssetManager();
  public final String RED_KNIGHT_ATLAS = "redKnightFull/redKnight.atlas";
  public final String BLUE_KNIGHT_ATLAS = "blueKnightFull/blueKnight.atlas";
  public final String BACKGROUND_IMG = "bg001.png";
  public final String SKIN_BASE = "comicSkin/skin/";
  public final String SKIN_UI = SKIN_BASE+"comic-ui.json";
  public final String SKIN_ATLAS = SKIN_BASE+"comic-ui.atlas";

  public void loadImages(){
    manager.load(RED_KNIGHT_ATLAS, TextureAtlas.class);
    manager.load(BLUE_KNIGHT_ATLAS, TextureAtlas.class);
    manager.load(BACKGROUND_IMG, Texture.class);
  }

  public void loadSkin(){
    SkinParameter params = new SkinParameter(SKIN_ATLAS);
    manager.load(SKIN_UI, Skin.class, params);
  }
}
