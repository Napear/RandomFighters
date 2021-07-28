package com.radical2studios.randomfighter.controllers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Fighter extends Actor {
  

  private TextureAtlas atlas;
  private String name;
  private int health;
  private Rectangle hitbox;

  public Fighter(String name, TextureAtlas atlas){
    this.atlas = atlas;
    this.name = name;
    health = 3;
    hitbox = new Rectangle();
  }

  public void setIdle(){

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
    
  }

  public void die(){

  }
}
