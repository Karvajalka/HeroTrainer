package com.satgnu.herotrainer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class HeroTrainer extends ApplicationAdapter {
	SpriteBatch batch;
	Stage stage;
	BitmapFont font;
	MainUI mainUI;

	@Override
	public void create () {
		font = new BitmapFont();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		batch = new SpriteBatch();

		mainUI = new MainUI(font, stage);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.end();

		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void dispose () {
		batch.dispose();
		stage.dispose();
		font.dispose();
		mainUI.dispose();
	}
}
