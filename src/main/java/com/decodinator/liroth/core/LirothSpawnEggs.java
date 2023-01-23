package com.decodinator.liroth.core;

import java.util.ArrayList;
import java.util.List;

import com.decodinator.liroth.Liroth;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.SpawnEggItem;

public class LirothSpawnEggs {
    public static List<Item> ITEMS = new ArrayList<>();

    public static final Item FUNGAL_FIEND_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.FUNGAL_FIEND, 1315860, 2031360, new Properties().tab(Liroth.creativeEntitiesTab)), "fungal_fiend_spawn_egg");
    public static final Item FORSAKEN_CORPSE_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.FORSAKEN_CORPSE, 1842204, 10551525, new Properties().tab(Liroth.creativeEntitiesTab)), "forsaken_corpse_spawn_egg");
    public static final Item SKELETAL_FREAK_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.SKELETAL_FREAK, 1513239, 16711900, new Properties().tab(Liroth.creativeEntitiesTab)), "skeletal_freak_spawn_egg");
    public static final Item WARP_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.WARP, 524305, 4260003, new Properties().tab(Liroth.creativeEntitiesTab)), "warp_spawn_egg");
    public static final Item SOUL_ARACHNID_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.SOUL_ARACHNID, 73758, 5078138, new Properties().tab(Liroth.creativeEntitiesTab)), "soul_arachnid_spawn_egg");
    public static final Item PIER_PEEP_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.PIER_PEEP, 1638400, 11665663, new Properties().tab(Liroth.creativeEntitiesTab)), "pier_peep_spawn_egg");
    public static final Item SHADE_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.SHADE, 328965, 1579032, new Properties().tab(Liroth.creativeEntitiesTab)), "shade_spawn_egg");
    public static final Item PROWLER_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.PROWLER, 16312063, 4260003, new Properties().tab(Liroth.creativeEntitiesTab)), "prowler_spawn_egg");
    public static final Item FREAKSHOW_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.FREAKSHOW, 524305, 1579032, new Properties().tab(Liroth.creativeEntitiesTab)), "freakshow_spawn_egg");
    public static final Item VILE_SHARK_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.VILE_SHARK, 5963996, 7667865, new Properties().tab(Liroth.creativeEntitiesTab)), "vile_shark_spawn_egg");
    public static final Item LIROTHIAN_MIMIC_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.LIROTHIAN_MIMIC, 41655, 10551525, new Properties().tab(Liroth.creativeEntitiesTab)), "lirothian_mimic_spawn_egg");
    
    private static Item createSpawnEggItem(SpawnEggItem spawnEggItem, String id) {
          Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, id), spawnEggItem);
          ITEMS.add(spawnEggItem);
    	  return spawnEggItem;
	}
    
    public static List<Item> getSpawnEggs() {
    	return ITEMS;
    }
    
    public static void init() {}
}
