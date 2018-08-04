package com.satgnu.herotrainer.entity;

import com.satgnu.herotrainer.HeroTrainer;
import com.satgnu.herotrainer.Render;
import com.satgnu.herotrainer.ui.HeroPortrait;

public class Hero extends Entity {

    public BaseAttributes attributes;
    public BaseAttributes attributesMax;
    public String name;
    public HeroPortrait portrait;
    public HeroTrainer mainApp;
    public int order;

    public Hero(HeroTrainer app)
    {
        super();
        mainApp = app;
        name = "Thorn Mercy";
        attributesMax = new BaseAttributes();
        attributesMax.SetAttribute(BaseAttributes.Attribute.Physical, (int)(Math.random()*8+5));
        attributesMax.SetAttribute(BaseAttributes.Attribute.Mind, (int)(Math.random()*8+5));
        attributesMax.SetAttribute(BaseAttributes.Attribute.Agility, (int)(Math.random()*8+5));

        attributes = new BaseAttributes();
        attributes.SetAttribute(BaseAttributes.Attribute.Physical, (int)(Math.random()*attributesMax.GetAttribute(BaseAttributes.Attribute.Physical)));
        attributes.SetAttribute(BaseAttributes.Attribute.Mind, (int)(Math.random()*attributesMax.GetAttribute(BaseAttributes.Attribute.Mind)));
        attributes.SetAttribute(BaseAttributes.Attribute.Agility, (int)(Math.random()*attributesMax.GetAttribute(BaseAttributes.Attribute.Agility)));


        order = mainApp.heroList.size()+1;
        portrait = new HeroPortrait("", mainApp.mainUI.verticalBarSkin);
        portrait.setPosition(10, order*70+200);

        portrait.setSize(64,64);
        portrait.myHero = this;
        Render.stage.addActor(portrait);
    }

    public void Update()
    {

    }

    public void Draw()
    {
        if(portrait.isChecked())
            DrawInfo();
    }

    public void DrawInfo() {
        int origin_x = 10 + 64 + 10;
        int origin_y = order*70+200;

        int fys = attributes.GetAttribute(BaseAttributes.Attribute.Physical);
        int agi = attributes.GetAttribute(BaseAttributes.Attribute.Agility);
        int mind = attributes.GetAttribute(BaseAttributes.Attribute.Mind);
        int fysMax = attributesMax.GetAttribute(BaseAttributes.Attribute.Physical);
        int agiMax = attributesMax.GetAttribute(BaseAttributes.Attribute.Agility);
        int mindMax = attributesMax.GetAttribute(BaseAttributes.Attribute.Mind);

        Render.batch.draw(mainApp.mainUI.texHeroPortrait, origin_x-1, origin_y+1, 110, 66);
        Render.font.draw(Render.batch, name, origin_x, origin_y + 64);

        Render.font.draw(Render.batch, fys + "("+fysMax+")", origin_x+60, origin_y + 64-16);
        Render.font.draw(Render.batch, agi + "("+agiMax+")", origin_x+60, origin_y + 64-32);
        Render.font.draw(Render.batch, mind + "("+mindMax+")", origin_x+60, origin_y + 64-48);

        Render.batch.draw(mainApp.mainUI.gradientGreen, origin_x+8, origin_y + 64-32, 44, 16);
        Render.batch.draw(mainApp.mainUI.gradientGreen, origin_x+8, origin_y + 64-48, 44, 16);
        Render.batch.draw(mainApp.mainUI.gradientGreen, origin_x+8, origin_y + 64-64, 44, 16);

        Render.batch.draw(mainApp.mainUI.gradientRed, origin_x+10, origin_y + 64-30, 40*fys/fysMax, 12);
        Render.batch.draw(mainApp.mainUI.gradientOrange, origin_x+10, origin_y + 64-46, 40*agi/agiMax, 12);
        Render.batch.draw(mainApp.mainUI.gradientBlue, origin_x+10, origin_y + 64-62, 40*mind/mindMax, 12);
    }
}
