package com.decodinator.liroth.world.generator;

import com.decodinator.liroth.Liroth;

import net.minecraft.structure.PlainsVillageData;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class LirothConfiguredStructures {
    /**
     * Static instance of our configured structure so we can reference it and add it to biomes easily.
     */
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_LIROTH_FORTRESS = LirothStructures.LIROTH_FORTRESS
            .configure(new StructurePoolFeatureConfig(() -> PlainsVillageData.STRUCTURE_POOLS, 0));
    
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_OLDEN_LIROTH_PORTAL = LirothStructures.OLDEN_LIROTH_PORTAL
            .configure(new StructurePoolFeatureConfig(() -> PlainsVillageData.STRUCTURE_POOLS, 0));
    
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_NOVA_TOWER = LirothStructures.NOVA_TOWER
            .configure(new StructurePoolFeatureConfig(() -> PlainsVillageData.STRUCTURE_POOLS, 0));
            // Dummy StructurePoolFeatureConfig values for now. We will modify the pool at runtime since we cannot get json pool files here at mod init.
            // You can create and register your pools in code, pass in the code create pool here, and delete both newConfig and newContext in RunDownHouseStructure's createPiecesGenerator.
            // Note: StructurePoolFeatureConfig only takes 0 - 7 size so that's another reason why we are going to bypass that "codec" by changing size at runtime to get higher sizes.
    /**
     * Registers the configured structure which is what gets added to the biomes.
     * You can use the same identifier for the configured structure as the regular structure
     * because the two fo them are registered to different registries.
     *
     * We can register configured structures at any time before a world is clicked on and made.
     * But the best time to register configured features by code is honestly to do it in onInitialize.
     */
    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new Identifier(Liroth.MOD_ID, "configured_olden_liroth_portal"), CONFIGURED_OLDEN_LIROTH_PORTAL);
        Registry.register(registry, new Identifier(Liroth.MOD_ID, "configured_liroth_fortress"), CONFIGURED_LIROTH_FORTRESS);
        Registry.register(registry, new Identifier(Liroth.MOD_ID, "configured_nova_tower"), CONFIGURED_NOVA_TOWER);
    }
    
    
}