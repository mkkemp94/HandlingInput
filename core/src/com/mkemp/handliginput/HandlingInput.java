package com.mkemp.handliginput;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HandlingInput extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();

		texture = new Texture("0001.png");
		sprite = new Sprite(texture);
		sprite.setPosition(w/2 - sprite.getWidth()/2, h/2 - sprite.getHeight()/2);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
				sprite.translateX(-1f);
			else
				sprite.translateX(-10f);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_RIGHT))
				sprite.translateX(1f);
			else
				sprite.translateX(10f);
		}
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			sprite.setPosition(Gdx.input.getX() - sprite.getWidth()/2,
					Gdx.graphics.getHeight() - Gdx.input.getY() - sprite.getHeight()/2);
		}
		if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
			sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2,
					Gdx.graphics.getHeight() - Gdx.input.getY() - sprite.getHeight()/2);
		}

		batch.begin();
		sprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		texture.dispose();
	}
}
