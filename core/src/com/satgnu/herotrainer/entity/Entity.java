package com.satgnu.herotrainer.entity;

import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

    protected Vector2 position;
    protected long id;

    Entity()
    {
        id = GenerateID();
        position = new Vector2();
    }

    public abstract void Update();

    public abstract void Draw();

    private static long last_id = 0;
    private static long GenerateID()
    {
        return ++last_id;
    }
}
