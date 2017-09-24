package com.satgnu.herotrainer.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.satgnu.herotrainer.Audio;
import com.satgnu.herotrainer.entity.Hero;

import java.util.Iterator;

public class HeroPortrait extends TextButton {
    public Hero myHero;

    public HeroPortrait(String str, Skin s) {
        super(str, s, "portrait_bg");

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //hButton.setChecked(false);

                Iterator<Hero> iterator = myHero.mainApp.heroList.iterator();
                while(iterator.hasNext()) {
                    Hero next = iterator.next();
                    if(next != myHero)
                        next.portrait.setChecked(false);
                }
                Audio.playSound("sfx/click.wav", 1f);
                event.stop();
            }
        });
    }
}