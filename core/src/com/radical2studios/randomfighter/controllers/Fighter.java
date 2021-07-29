package com.radical2studios.randomfighter.controllers;

import java.util.Arrays;
import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Fighter extends Actor {
  

  private TextureAtlas atlas;
  private String name;
  private int health;
  private Rectangle hitbox;
  private HashMap<FighterAnimationType, Animation<TextureRegion>> animations;
  private FighterAnimationType activeAnimation = null;
  private Animation<TextureRegion> animation;
  private float elapsedTime, x, y;
  private boolean isFlipped = false;

  public Fighter(String name, TextureAtlas atlas, float x, float y){
    this.atlas = atlas;
    this.name = name;
    this.x = x;
    this.y = y;
    health = 3;
    hitbox = new Rectangle();
    animations = new HashMap<FighterAnimationType, Animation<TextureRegion>>();
    storeAnimations();
    setAnimation(FighterAnimationType.IDLE);
  }

  private void storeAnimations(){
    Arrays.asList(FighterAnimationType.values()).forEach(key -> {
      Animation<TextureRegion> animation = new Animation<TextureRegion>(1f/(16.5f + MathUtils.random(-0.2f, 0.2f)),
                                                                        atlas.findRegions(key.toString())
                                                                      );
      animations.put(key, animation);
    });
  }

  public void setAnimation (FighterAnimationType animationType){
    if(activeAnimation == animationType) return;
    activeAnimation = animationType;
    animation = animations.get(animationType);
    elapsedTime = 0;
  }

  @Override
  public void draw(Batch batch, float parentAlpha) {
    TextureRegion frame = animation.getKeyFrame(elapsedTime, isAlive());
    if(isFlipped != frame.isFlipX()) frame.flip(true, false);
    batch.draw(frame, x, y);
  }

  @Override
  public void act(float delta) {    
    super.act(delta);
    elapsedTime += delta;
  }

  public void flip(){
    isFlipped = !isFlipped;
  }

  public boolean isAlive(){
    return health > 0;
  }

  public void attack(){

  }

  public void move(){

  }

  public void jump(){

  }

  public void parry(){

  }

  public void takeHit(){
    health--; 
  }
}
