package com.satgnu.herotrainer;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.satgnu.herotrainer.ui.Menu;
import com.satgnu.herotrainer.ui.MenuInitializers;

import java.util.HashMap;
import java.util.Map;

public class MenuHandler {

    // "null" = not in any menu
    private static String current_menu = "none";
    private static Map<String, Menu> menus;

    public static void initialise()
    {
        menus = new HashMap<>();
        preloadMenus();
    }

    public static void registerMenu(Menu menu, String name)
    {
        menus.put(name, menu);
    }

    public static void preloadMenus()
    {
        menus.put("ingame", null);

        MenuInitializers.initializeMenuMain();
    }

    public static void setMenu(String menu)
    {
        current_menu = menu;
        Menu m = menus.get(current_menu);
        if(m != null)
        {
            m.setActive();
            m.getStage().addAction(Actions.sequence(Actions.alpha(0.2f), Actions.fadeIn(0.5f)));
        }

        // TODO should probably check menu is loaded here otherwise it will null crash
    }

    public static void resize(int width, int height)
    {
        menus.forEach((key, value) -> {
            if(value != null)
                value.resize(width, height);
        });
    }

    public static String getMenu()
    {
        return current_menu;
    }

    public static void update()
    {

    }

    public static void draw()
    {
        if(current_menu != "ingame")
        {
            Menu menu = menus.get(current_menu);
            menu.render();
        }
    }

    public static void shutdown()
    {

    }
}
