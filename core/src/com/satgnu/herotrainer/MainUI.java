package com.satgnu.herotrainer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.satgnu.herotrainer.entity.Hero;

import java.util.Iterator;

public class MainUI {
    HeroTrainer mainApp;
    BitmapFont font;
    Skin verticalBarSkin;
    Stage stage;
    Texture texHeroPortrait;
    Texture mainBackground;

    public MainUI (BitmapFont f, Stage s, HeroTrainer h) {
        mainApp = h;
        font = f;
        stage = s;
        createSkins();
        createSideBar();
        texHeroPortrait = new Texture(Gdx.files.internal("ui/portrait_background2.png"));
        mainBackground = new Texture(Gdx.files.internal("ui/background.png"));
    }

    public void createSkins () {
        verticalBarSkin = new Skin();
        verticalBarSkin.add("default", font);

        //Create a texture
        verticalBarSkin.add("background", new Texture(Gdx.files.internal("ui/button2.png")));

        //Create a button style
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = verticalBarSkin.newDrawable("background", Color.WHITE);
        textButtonStyle.down = verticalBarSkin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.checked = verticalBarSkin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.over = verticalBarSkin.newDrawable("background", Color.LIGHT_GRAY);
        textButtonStyle.font = verticalBarSkin.getFont("default");
        verticalBarSkin.add("default", textButtonStyle);
    }

    public void createSideBar () {
        final TextButton button1 = new TextButton("1", verticalBarSkin); // Use the initialized skin
        button1.setPosition(10, 10);
        button1.setSize(30, 30);
        button1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                button1.setChecked(false);
                Audio.playSound("sfx/click.wav", 1f);
                event.stop();
            }
        });
        stage.addActor(button1);

        final TextButton button2 = new TextButton("2", verticalBarSkin); // Use the initialized skin
        button2.setPosition(10, 50);
        button2.setSize(30, 30);
        button2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                button2.setChecked(false);
                Audio.playSound("sfx/click.wav", 1f);
                event.stop();
            }
        });
        stage.addActor(button2);

        final TextButton button3 = new TextButton("3", verticalBarSkin); // Use the initialized skin
        button3.setPosition(10, 90);
        button3.setSize(30, 30);
        button3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                button3.setChecked(false);
                Audio.playSound("sfx/click.wav", 1f);
                event.stop();
            }
        });
        stage.addActor(button3);
    }

    public void drawBackground() {
        mainApp.batch.draw(mainBackground,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }

    public void drawHeroBar() {
        Iterator<Hero> iterator;

        iterator = mainApp.heroList.iterator();
        int y = 128;
        while(iterator.hasNext()) {
            Hero next = iterator.next();
            mainApp.batch.draw(texHeroPortrait, 10, y);
            y += 66;
        }
    }

    public void dispose() {
        verticalBarSkin.dispose();
    }
}
