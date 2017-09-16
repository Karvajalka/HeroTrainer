package com.satgnu.herotrainer.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.satgnu.herotrainer.Audio;
import com.satgnu.herotrainer.GameState;
import com.satgnu.herotrainer.MenuHandler;

public class MenuInitializers {

    public static void initializeMenuMain()
    {
        Menu menu = new Menu();
        Skin skin = menu.getSkin();

        int btnWidth = 256;
        int btnHeight = 64;

        int stageWidth = 1280;

        final TextButton btnPlay = new TextButton("Play", skin); // Use the initialized skin
        btnPlay.setPosition(stageWidth/2 - btnWidth/2, 400);
        btnPlay.setSize(btnWidth, btnHeight);
        btnPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                btnPlay.setChecked(false);
                Audio.playSound("sfx/click.wav", 1f);
                MenuHandler.setMenu("ingame");
                event.stop();
            }
        });

        menu.addWidget(btnPlay);

        final TextButton btnLoad = new TextButton("Load Save", skin); // Use the initialized skin
        btnLoad.setPosition(stageWidth/2 - btnWidth/2, 300);
        btnLoad.setSize(btnWidth, btnHeight);
        btnLoad.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                btnLoad.setChecked(false);
                Audio.playSound("sfx/click.wav", 1f);
                MenuHandler.setMenu("ingame");
                event.stop();
            }
        });

        menu.addWidget(btnLoad);

        final TextButton btnOptions = new TextButton("Options", skin); // Use the initialized skin
        btnOptions.setPosition(stageWidth/2 - btnWidth/2, 200);
        btnOptions.setSize(btnWidth, btnHeight);
        btnOptions.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                btnOptions.setChecked(false);
                Audio.playSound("sfx/click.wav", 1f);
                MenuHandler.setMenu("ingame");
                event.stop();
            }
        });

        menu.addWidget(btnOptions);

        final TextButton btnExit = new TextButton("Exit", skin); // Use the initialized skin
        btnExit.setPosition(stageWidth/2 - btnWidth/2, 100);
        btnExit.setSize(btnWidth, btnHeight);
        btnExit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                btnExit.setChecked(false);
                Audio.playSound("sfx/click.wav", 1f);
                Gdx.app.exit(); // FIXME exit properly
                event.stop();
            }
        });

        menu.addWidget(btnExit);

        final Image imgTitle = new Image(new TextureRegion(new Texture(Gdx.files.internal("ui/title.png"))));
        imgTitle.setScaling(Scaling.fill);
        imgTitle.setPosition(-20, 720-160);

        menu.addWidget(imgTitle);

        MenuHandler.registerMenu(menu, "main");
    }
}
