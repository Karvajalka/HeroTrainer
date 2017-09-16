package com.satgnu.herotrainer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.satgnu.herotrainer.entity.Hero;
import com.satgnu.herotrainer.ui.Splash;

import java.util.ArrayList;
import java.util.List;

public class HeroTrainer extends ApplicationAdapter {
	SpriteBatch batch;
	Stage stage;
	BitmapFont font;
	MainUI mainUI;

	Splash splashScreen;
	List<Hero> heroList;

	@Override
	public void create () {
		font = new BitmapFont();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		batch = new SpriteBatch();

		MenuHandler.initialise();
		mainUI = new MainUI(font, stage, this);

		splashScreen = new Splash(batch);
		heroList = new ArrayList<Hero>();
		heroList.add(new Hero());
		heroList.add(new Hero());
		heroList.add(new Hero());
		heroList.add(new Hero());
	}

	@Override
	public void render () {

		if(GameState.inSplash) {
			splashScreen.render(Gdx.graphics.getDeltaTime());
			return;
		}

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		if(MenuHandler.getMenu() == "ingame")
		{
			// do game stuff
			mainUI.drawBackground();
			mainUI.drawHeroBar();
		}
		batch.end();

		if(MenuHandler.getMenu() == "ingame")
		{
			Gdx.input.setInputProcessor(stage); // this is a hack until ingame stage becomes a proper Menu object
			stage.act();
			stage.draw();
		}
		else
		{
			MenuHandler.update();
			MenuHandler.draw();
		}
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
		MenuHandler.resize(width, height);
	}

	@Override
	public void dispose () {
		batch.dispose();
		stage.dispose();
		font.dispose();
		mainUI.dispose();
	}
}
