package com.satgnu.herotrainer.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Menu {

    private Stage stage;
    private Table table;
    private static Skin skin;

    Menu()
    {
        stage = new Stage();
        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        //skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        skin = new Skin();
        skin.add("default", new BitmapFont()); // FIXME

        //Create a texture
        skin.add("background",new Texture(Gdx.files.internal("ui/button1.png")));

        //Create a button style
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background", Color.WHITE);
        textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);
    }

    public void resize(int w, int h)
    {
        stage.getViewport().update(w, h, true);
    }

    public void setActive()
    {
        Gdx.input.setInputProcessor(stage);
    }

    public void render()
    {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void dispose()
    {
        stage.dispose();
    }

    public void addWidget(Actor widget)
    {
        stage.addActor(widget);
    }

    public Skin getSkin()
    {
        return skin;
    }
}
