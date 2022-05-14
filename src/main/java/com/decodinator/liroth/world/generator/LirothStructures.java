package com.decodinator.liroth.world.generator;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.mixin.access.StructureFeatureAccessor;

import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.StructureFeature;

public class LirothStructures {

    /**
    /**
     * Registers the structure itself and sets what its path is. In this case, the
     * structure will have the Identifier of structure_tutorial:sky_structures.
     *
     * It is always a good idea to register your Structures so that other mods and datapacks can
     * use them too directly from the registries. It great for mod/datapacks compatibility.
     */
    public static StructureFeature<?> NOVA_TOWER = new NovaTowerStructure();
    public static StructureFeature<?> OLDEN_LIROTH_PORTAL = new OldenLirothPortalStructure();
    public static StructureFeature<?> LIROTH_FORTRESS = new LirothFortressStructure();

    public static void registerStructureFeatures() {
        // The generation step for when to generate the structure. there are 10 stages you can pick from!
        // This surface structure stage places the structure before plants and ores are generated.
        StructureFeatureAccessor.callRegister(Liroth.MOD_ID + ":nova_tower", NOVA_TOWER, GenerationStep.Feature.SURFACE_STRUCTURES);
        StructureFeatureAccessor.callRegister(Liroth.MOD_ID + ":olden_liroth_portal", OLDEN_LIROTH_PORTAL, GenerationStep.Feature.SURFACE_STRUCTURES);
        StructureFeatureAccessor.callRegister(Liroth.MOD_ID + ":liroth_fortress", LIROTH_FORTRESS, GenerationStep.Feature.SURFACE_STRUCTURES);
    }
}