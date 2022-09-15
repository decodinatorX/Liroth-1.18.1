package com.decodinator.liroth.core;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

@Config(name = "liroth")
public class LirothConfigScreen implements ConfigData {
    @ConfigEntry.Gui.CollapsibleObject
    public GeneralConfig general = new GeneralConfig();
    
	public static class GeneralConfig {
		public boolean lirothMainMenu = true;
	}
}