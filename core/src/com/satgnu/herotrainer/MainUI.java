package com.satgnu.herotrainer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.satgnu.herotrainer.entity.BaseAttributes;
import com.satgnu.herotrainer.entity.Hero;

public class MainUI {
    HeroTrainer mainApp;
    BitmapFont font;
    public Skin verticalBarSkin;
    Stage stage;
    public Texture texHeroPortrait;
    Texture mainBackground;

    public Texture gradientRed;
    public Texture gradientBlue;
    public Texture gradientOrange;
    public Texture gradientGreen;
    public Texture portraitThorn;

    public MainUI (BitmapFont f, Stage s, HeroTrainer h) {
        mainApp = h;
        font = f;
        stage = s;
        texHeroPortrait = new Texture(Gdx.files.internal("ui/portrait_background2.png"));
        mainBackground = new Texture(Gdx.files.internal("ui/background.png"));
        portraitThorn = new Texture(Gdx.files.internal("ui/portrait_thorn.png"));

        gradientRed = new Texture(Gdx.files.internal("ui/gradientred.png"));
        gradientOrange = new Texture(Gdx.files.internal("ui/gradientorange.png"));
        gradientBlue = new Texture(Gdx.files.internal("ui/gradientblue.png"));
        gradientGreen = new Texture(Gdx.files.internal("ui/gradientgreen.png"));
        createSkins();
        createSideBar();
    }

    public void createSkins () {
        verticalBarSkin = new Skin();
        verticalBarSkin.add("default", font);
        verticalBarSkin.add("portrait_bg", font);

        //Create a texture
        verticalBarSkin.add("background", new Texture(Gdx.files.internal("ui/button2.png")));
        verticalBarSkin.add("portrait_bg", portraitThorn);

        //Create a button style
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = verticalBarSkin.newDrawable("background", Color.WHITE);
        textButtonStyle.down = verticalBarSkin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.checked = verticalBarSkin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.over = verticalBarSkin.newDrawable("background", Color.LIGHT_GRAY);
        textButtonStyle.font = verticalBarSkin.getFont("default");
        verticalBarSkin.add("default", textButtonStyle);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = verticalBarSkin.newDrawable("portrait_bg", Color.WHITE);
        textButtonStyle.down = verticalBarSkin.newDrawable("portrait_bg", Color.DARK_GRAY);
        textButtonStyle.checked = verticalBarSkin.newDrawable("portrait_bg", Color.DARK_GRAY);
        textButtonStyle.over = verticalBarSkin.newDrawable("portrait_bg", Color.LIGHT_GRAY);
        textButtonStyle.font = verticalBarSkin.getFont("portrait_bg");
        verticalBarSkin.add("portrait_bg", textButtonStyle);
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
        Render.batch.draw(mainBackground,0,0);
    }

    public void drawHeroPage(Hero hero, int origin_y) {
        int origin_x;
        origin_x = 10 + 64 + 10;
        int fys = hero.attributes.GetAttribute(BaseAttributes.Attribute.Physical);
        int agi = hero.attributes.GetAttribute(BaseAttributes.Attribute.Agility);
        int mind = hero.attributes.GetAttribute(BaseAttributes.Attribute.Mind);
        int fysMax = hero.attributesMax.GetAttribute(BaseAttributes.Attribute.Physical);
        int agiMax = hero.attributesMax.GetAttribute(BaseAttributes.Attribute.Agility);
        int mindMax = hero.attributesMax.GetAttribute(BaseAttributes.Attribute.Mind);

        Render.batch.draw(texHeroPortrait, origin_x-1, origin_y+1, 110, 66);
        font.draw(Render.batch, hero.name, origin_x, origin_y + 64);

        font.draw(Render.batch, fys + "("+fysMax+")", origin_x+60, origin_y + 64-16);
        font.draw(Render.batch, agi + "("+agiMax+")", origin_x+60, origin_y + 64-32);
        font.draw(Render.batch, mind + "("+mindMax+")", origin_x+60, origin_y + 64-48);

        Render.batch.draw(gradientGreen, origin_x+8, origin_y + 64-32, 44, 16);
        Render.batch.draw(gradientGreen, origin_x+8, origin_y + 64-48, 44, 16);
        Render.batch.draw(gradientGreen, origin_x+8, origin_y + 64-64, 44, 16);

        Render.batch.draw(gradientRed, origin_x+10, origin_y + 64-30, 40*fys/fysMax, 12);
        Render.batch.draw(gradientOrange, origin_x+10, origin_y + 64-46, 40*agi/agiMax, 12);
        Render.batch.draw(gradientBlue, origin_x+10, origin_y + 64-62, 40*mind/mindMax, 12);
    }

    public void dispose() {
        verticalBarSkin.dispose();
    }
}
