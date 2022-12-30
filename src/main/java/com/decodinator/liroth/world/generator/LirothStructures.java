package com.decodinator.liroth.world.generator;

import com.decodinator.liroth.Liroth;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.StructureType;

public class LirothStructures {

    /**
    /**
     * Registers the structure itself and sets what its path is. In this case, the
     * structure will have the Identifier of structure_tutorial:sky_structures.
     *
     * It is always a good idea to register your Structures so that other mods and datapacks can
     * use them too directly from the registries. It great for mod/datapacks compatibility.
     */

    public static StructureType<LirothFortressStructure> LIROTH_FORTRESS;
    public static StructureType<NovaTowerStructure> NOVA_TOWER;
    public static StructureType<OldenLirothPortalStructure> OLDEN_LIROTH_PORTAL;
    
    public static void init() {
    	LIROTH_FORTRESS = Registry.register(Registries.STRUCTURE_TYPE, new Identifier(Liroth.MOD_ID, "liroth_fortress"), () -> LirothFortressStructure.CODEC);
    	NOVA_TOWER = Registry.register(Registries.STRUCTURE_TYPE, new Identifier(Liroth.MOD_ID, "nova_tower"), () -> NovaTowerStructure.CODEC);
    	OLDEN_LIROTH_PORTAL = Registry.register(Registries.STRUCTURE_TYPE, new Identifier(Liroth.MOD_ID, "olden_liroth_portal"), () -> OldenLirothPortalStructure.CODEC);
    }
}