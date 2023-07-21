package com.decodinator.liroth;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "liroth")
@Config.Gui.Background("liroth:textures/blocks/liroth_dirt.png")
public class LirothConfig implements ConfigData {
    @ConfigEntry.Gui.RequiresRestart
	public boolean titlescreen = true;
}