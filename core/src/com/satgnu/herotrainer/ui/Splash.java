package com.satgnu.herotrainer.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.satgnu.herotrainer.AnimatedSprite;
import com.satgnu.herotrainer.GameState;
import com.satgnu.herotrainer.MenuHandler;

import java.util.ArrayList;
import java.util.List;

public class Splash {
    private AnimatedSprite logo;
    private final float duration = 3.1f;

    private float stateTime = 0;

    private SpriteBatch batch;

    public Splash(SpriteBatch batch)
    {
        logo = new AnimatedSprite(4,3,400, 156, "splash/satgnu.png");
        List<Integer> frames = new ArrayList<>();
        for(int i=0; i<12; i++)
            frames.add(i);
        logo.registerAnim("play", frames, 10);
        logo.play("play", true);

        this.batch = batch;
    }

    Color fg_color = new Color(.95f, .95f, .95f, 1f);
    Color bg_color = new Color(.25f, .25f, .25f, 1f);

    public void render(float deltaTime)
    {
        stateTime += deltaTime;
        logo.update(deltaTime);

        if(stateTime < 0.5f)
        {
            bg_color.r = bg_color.g = bg_color.b = 0.25f + ((stateTime/0.5f)*0.70f);
        }

        if(stateTime > 2)
        {
            float color = 0.95f - (1 * (stateTime-2));
            fg_color.set(color, color, color, 1.0f);
        }

        Gdx.gl.glClearColor(bg_color.r, bg_color.g, bg_color.b, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        float alpha = fg_color.r;
        if(stateTime < 0.5f)
            alpha = bg_color.r;
        batch.setColor(1f, 1f, 1f, alpha);

        float width = 600;
        float height = 234;
        width *= 1f + (stateTime / 24f);
        height *= 1f + (stateTime / 24f);


        batch.draw(logo.getKeyFrame(), 1280/2 - width/2, 720/2-height/2, width, height);
        batch.setColor(1f, 1f, 1f, 1f);
        batch.end();

        if(stateTime >= duration) {
            GameState.inSplash = false;
            MenuHandler.setMenu("main");
        }
    }
}
