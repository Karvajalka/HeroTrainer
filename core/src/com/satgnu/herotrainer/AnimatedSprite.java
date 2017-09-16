package com.satgnu.herotrainer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimatedSprite {
    protected int rows, cols, width, height;

    private Texture sheet;
    private TextureRegion[] frames;

    private boolean looping = false;

    private Map<String, AnimationSet> animations = new HashMap<>();

    String current_anim;

    private float frameTime = 0;

    private class AnimationSet
    {
        int fps;
        List<Integer> frames = new ArrayList<Integer>();
    }

    public AnimatedSprite(int rows, int cols, int width, int height, String path)
    {
        this.rows = rows;
        this.cols = cols;
        this.width = width;
        this.height = height;

        sheet = new Texture(Gdx.files.internal(path));

        // Split the sheet into frames
        TextureRegion[][] tmp = TextureRegion.split(sheet, sheet.getWidth() / cols, sheet.getHeight() / rows);
        frames = new TextureRegion[cols * rows];
        int index = 0;
        for (int i=0; i<rows; i++)
            for (int j=0; j<cols; j++)
                frames[index++] = tmp[i][j];
    }

    public void play(String anim, boolean loop)
    {
        current_anim = anim;
        frameTime = 0;
    }

    public void update(float deltaTime)
    {
        frameTime += deltaTime;
    }

    public void registerAnim(String name, List<Integer> frames, int fps)
    {
        AnimationSet set = new AnimationSet();

        set.fps = fps;
        set.frames= frames;
        animations.put(name, set);
    }

    public TextureRegion getKeyFrame()
    {
        AnimationSet anim = animations.get(current_anim);

        int index = (int)((frameTime / (1f / anim.fps)) % anim.frames.size());
        int frameNum = anim.frames.get(index);
        return frames[frameNum];
    }

    public int GetRows()
    {
        return rows;
    }

    public int GetCols()
    {
        return cols;
    }

    public int GetWidth()
    {
        return width;
    }

    public int GetHeight()
    {
        return height;
    }
}
