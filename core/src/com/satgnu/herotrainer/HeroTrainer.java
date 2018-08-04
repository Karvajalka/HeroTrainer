package com.satgnu.herotrainer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.satgnu.herotrainer.entity.Hero;
import com.satgnu.herotrainer.game.inventory.Inventory;
import com.satgnu.herotrainer.game.inventory.Item;
import com.satgnu.herotrainer.ui.HudInventory;
import com.satgnu.herotrainer.ui.Splash;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HeroTrainer extends ApplicationAdapter {

	public MainUI mainUI;

	Splash splashScreen;
	public List<Hero> heroList;

	public HudInventory hud_inventory;

	@Override
	public void create () {
		Render.Initialise();

		MenuHandler.initialise();
		mainUI = new MainUI(Render.font, Render.stage, this);

		splashScreen = new Splash(Render.batch);
		heroList = new ArrayList<Hero>();
		heroList.add(new Hero(this));
		heroList.add(new Hero(this));
		heroList.add(new Hero(this));
		heroList.add(new Hero(this));

		GameState.inventory = new Inventory();
		GameState.inventory.addToInventory(new Item(Item.Type.Scale), 3);
		GameState.inventory.addToInventory(new Item(Item.Type.FancyScale), 7);
		hud_inventory = new HudInventory(GameState.inventory);
	}

	@Override
	public void render () {

		if(GameState.inSplash) {
			splashScreen.render(Gdx.graphics.getDeltaTime());
			return;
		}

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Render.StartBatch();
		if(MenuHandler.getMenu() == "ingame")
		{
			// do game stuff
			mainUI.drawBackground();
			Iterator<Hero> iterator = heroList.iterator();
			while(iterator.hasNext()) {
				Hero next = iterator.next();
				next.Draw();
			}

			hud_inventory.draw(new Vector2(300, 20));
		}
		Render.FlipBatch();

		if(MenuHandler.getMenu() == "ingame")
		{
			Gdx.input.setInputProcessor(Render.stage); // this is a hack until ingame stage becomes a proper Menu object
			Render.stage.act();
			Render.stage.draw();
		}
		else
		{
			MenuHandler.update();
			MenuHandler.draw();
		}
	}

	@Override
	public void resize(int width, int height) {
		Render.Resize(width, height);
		MenuHandler.resize(width, height);
	}

	@Override
	public void dispose () {
		Render.Shutdown();
		mainUI.dispose();
	}
}
