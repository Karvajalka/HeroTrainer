package com.satgnu.herotrainer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;
import java.util.Map;

public class Audio {
    static private Map<String, Sound> sounds = new HashMap<>();

    static public long playSound(String name, float vol)
    {
        if(!sounds.containsKey(name))
            loadSound(name);
        Sound sound = sounds.get(name);
        if(sound == null)
            return -1;

        return sound.play(vol);
    }

    static private void loadSound(String name)
    {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal(name));
        sounds.put(name, sound);
    }
}
