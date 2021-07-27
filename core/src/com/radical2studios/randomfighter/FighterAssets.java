package com.radical2studios.randomfighter;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader.SkinParameter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class FighterAssets extends AssetManager {

  public final static String RED_KNIGHT_ATLAS = "redKnightFull/redKnight.atlas";
  public final static String BLUE_KNIGHT_ATLAS = "blueKnightFull/blueKnight.atlas";
  public final static String BACKGROUND_IMG = "bg001.png";
  public final static String SKIN_BASE = "comicSkin/skin/";
  public final static String SKIN_UI = SKIN_BASE+"comic-ui.json";
  public final static String SKIN_ATLAS = SKIN_BASE+"comic-ui.atlas";

  public void loadImages(){
    load(RED_KNIGHT_ATLAS, TextureAtlas.class);
    load(BLUE_KNIGHT_ATLAS, TextureAtlas.class);
    load(BACKGROUND_IMG, Texture.class);
  }

  public void loadSkin(){
    SkinParameter params = new SkinParameter(SKIN_ATLAS);
    load(SKIN_UI, Skin.class, params);
  }

}
