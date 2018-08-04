package com.satgnu.herotrainer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.HashMap;
import java.util.Map;


public class Render {

    public static SpriteBatch batch;
    public static BitmapFont font;
    public static Stage stage;

    private static Map<String, Texture> Textures = new HashMap<>();

    public static void Initialise()
    {
        font = new BitmapFont();
        batch = new SpriteBatch();

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
    }

    public static void StartBatch()
    {
        batch.begin();
    }

    public static void FlipBatch()
    {
        batch.end();
    }

    public static void DrawTexture(String filename, int x, int y)
    {
        if (!Textures.containsKey(filename)) {
            LoadTexture(filename);
        }
        Texture tex = Textures.get(filename);
        if(tex == null) {
            return;
        }

        batch.draw(tex, x, y);
    }

    public static void Resize(int width, int height)
    {
        stage.getViewport().update(width, height, true);
    }

    public static void Shutdown()
    {
        batch.dispose();
        stage.dispose();
        font.dispose();

        // FIXME unload all Textures
    }

    private static void LoadTexture(String path)
    {
        Texture tex = new Texture(Gdx.files.internal(path));

        if(tex == null) {
            System.out.println("Attempted to draw non-existing texture: " + path);
        }

        Textures.put(path, tex);
    }
}
