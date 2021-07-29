package com.radical2studios.randomfighter.controllers;

public enum FighterAnimationType {
  WALK("Walk"), RUN("Run"), DIE("Dead"), JUMP("Jump"), ATTACK("Attack"), JUMP_ATTACK("JumpAttack");

  private final String text;

  FighterAnimationType(final String text){
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}

