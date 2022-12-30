package com.decodinator.liroth.core;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class LirothSounds {
    public static final Identifier LIROTH_BLASTER_FIRING_SOUND_ID = new Identifier("liroth:liroth_blaster_firing");
    public static SoundEvent LIROTH_BLASTER_FIRING_SOUND_EVENT = SoundEvent.of(LIROTH_BLASTER_FIRING_SOUND_ID);
    
    // Fungal Fiend
    public static final Identifier FUNGAL_FIEND_DEATH_SOUND_ID = new Identifier("liroth:fungal_fiend_death");
    public static SoundEvent FUNGAL_FIEND_DEATH_SOUND_EVENT = SoundEvent.of(FUNGAL_FIEND_DEATH_SOUND_ID);    
    public static final Identifier FUNGAL_FIEND_HURT_SOUND_ID = new Identifier("liroth:fungal_fiend_hurt");
    public static SoundEvent FUNGAL_FIEND_HURT_SOUND_EVENT = SoundEvent.of(FUNGAL_FIEND_HURT_SOUND_ID);
    public static final Identifier FUNGAL_FIEND_FUSE_SOUND_ID = new Identifier("liroth:fungal_fiend_fuse");
    public static SoundEvent FUNGAL_FIEND_FUSE_SOUND_EVENT = SoundEvent.of(FUNGAL_FIEND_FUSE_SOUND_ID);
    
    // Warp
    public static final Identifier WARP_DEATH_SOUND_ID = new Identifier("liroth:warp_death");
    public static SoundEvent WARP_DEATH_SOUND_EVENT = SoundEvent.of(WARP_DEATH_SOUND_ID);    
    public static final Identifier WARP_HURT_SOUND_ID = new Identifier("liroth:warp_hurt");
    public static SoundEvent WARP_HURT_SOUND_EVENT = SoundEvent.of(WARP_HURT_SOUND_ID);
    public static final Identifier WARP_IDLE_SOUND_ID = new Identifier("liroth:warp_idle");
    public static SoundEvent WARP_IDLE_SOUND_EVENT = SoundEvent.of(WARP_IDLE_SOUND_ID);
    
    // Shade
    public static final Identifier SHADE_DEATH_SOUND_ID = new Identifier("liroth:shade_death");
    public static SoundEvent SHADE_DEATH_SOUND_EVENT = SoundEvent.of(SHADE_DEATH_SOUND_ID);    
    public static final Identifier SHADE_HURT_SOUND_ID = new Identifier("liroth:shade_hurt");
    public static SoundEvent SHADE_HURT_SOUND_EVENT = SoundEvent.of(SHADE_HURT_SOUND_ID);
    public static final Identifier SHADE_IDLE_SOUND_ID = new Identifier("liroth:shade_idle");
    public static SoundEvent SHADE_IDLE_SOUND_EVENT = SoundEvent.of(SHADE_IDLE_SOUND_ID);
    
    // AMS - C418
    public static final Identifier LIROTH_BIOME_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.liroth_biome");
    public static SoundEvent LIROTH_BIOME_MUSIC_SOUND_EVENT = SoundEvent.of(LIROTH_BIOME_MUSIC_SOUND_ID);
    
    // ATX - C418
    public static final Identifier TALLPIER_BIOME_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.tallpier_biome");
    public static SoundEvent TALLPIER_BIOME_MUSIC_SOUND_EVENT = SoundEvent.of(TALLPIER_BIOME_MUSIC_SOUND_ID);
    
    // Fake Triplets - C418
    public static final Identifier SPICED_DESERT_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.spiced_desert");
    public static SoundEvent SPICED_DESERT_MUSIC_SOUND_EVENT = SoundEvent.of(SPICED_DESERT_MUSIC_SOUND_ID);
    
    // Home - C418
    public static final Identifier DAMNATION_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.damnation");
    public static SoundEvent DAMNATION_MUSIC_SOUND_EVENT = SoundEvent.of(DAMNATION_MUSIC_SOUND_ID);
    
    // Hope - C418
    public static final Identifier ESCAPE_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.escape");
    public static SoundEvent ESCAPE_MUSIC_SOUND_EVENT = SoundEvent.of(ESCAPE_MUSIC_SOUND_ID);
    
    // Keighley - C418
    public static final Identifier JALSPHIRE_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.jalsphire");
    public static SoundEvent JALSPHIRE_MUSIC_SOUND_EVENT = SoundEvent.of(JALSPHIRE_MUSIC_SOUND_ID);
    
    // Impostor Syndrome - C418
    public static final Identifier DESOLATE_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.desolate");
    public static SoundEvent DESOLATE_MUSIC_SOUND_EVENT = SoundEvent.of(DESOLATE_MUSIC_SOUND_ID);    
    
    public static void init() {
        Registry.register(Registries.SOUND_EVENT, LirothSounds.LIROTH_BLASTER_FIRING_SOUND_ID, LIROTH_BLASTER_FIRING_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.FUNGAL_FIEND_DEATH_SOUND_ID, FUNGAL_FIEND_DEATH_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.FUNGAL_FIEND_HURT_SOUND_ID, FUNGAL_FIEND_HURT_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.FUNGAL_FIEND_FUSE_SOUND_ID, FUNGAL_FIEND_FUSE_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.WARP_DEATH_SOUND_ID, WARP_DEATH_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.WARP_HURT_SOUND_ID, WARP_HURT_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.WARP_IDLE_SOUND_ID, WARP_IDLE_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.SHADE_DEATH_SOUND_ID, SHADE_DEATH_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.SHADE_HURT_SOUND_ID, SHADE_HURT_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.SHADE_IDLE_SOUND_ID, SHADE_IDLE_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.LIROTH_BIOME_MUSIC_SOUND_ID, LIROTH_BIOME_MUSIC_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.TALLPIER_BIOME_MUSIC_SOUND_ID, TALLPIER_BIOME_MUSIC_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.SPICED_DESERT_MUSIC_SOUND_ID, SPICED_DESERT_MUSIC_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.DAMNATION_MUSIC_SOUND_ID, DAMNATION_MUSIC_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.ESCAPE_MUSIC_SOUND_ID, ESCAPE_MUSIC_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.JALSPHIRE_MUSIC_SOUND_ID, JALSPHIRE_MUSIC_SOUND_EVENT);
        Registry.register(Registries.SOUND_EVENT, LirothSounds.DESOLATE_MUSIC_SOUND_ID, DESOLATE_MUSIC_SOUND_EVENT);
    }
}
