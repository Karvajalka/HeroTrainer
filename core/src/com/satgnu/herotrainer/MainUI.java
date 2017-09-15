package com.satgnu.herotrainer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainUI {
    BitmapFont font;
    Skin verticalBarSkin;
    Stage stage;

    public MainUI (BitmapFont f, Stage s) {
        font = f;
        stage = s;
        createSkins();
        createSideBar();
    }

    public void createSkins () {
        verticalBarSkin = new Skin();
        verticalBarSkin.add("default", font);

        //Create a texture
        Pixmap pixmap = new Pixmap(40,10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        verticalBarSkin.add("background",new Texture(pixmap));

        //Create a button style
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = verticalBarSkin.newDrawable("background", Color.BROWN);
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
                event.stop();
            }
        });
        stage.addActor(button3);
    }
    public void dispose() {
        verticalBarSkin.dispose();
    }
}
