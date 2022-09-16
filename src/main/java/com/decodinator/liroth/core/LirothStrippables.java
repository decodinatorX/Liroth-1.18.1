package com.decodinator.liroth.core;

import java.util.IdentityHashMap;
import java.util.Map;

import net.minecraft.block.Block;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.mixin.access.AxeItemAccess;

public class LirothStrippables {

    public static void strippableLogsLiroth() {
        Liroth.LOGGER.debug("Liroth: Registering strippable Blocks...");

        Map<Block, Block> stripables = new IdentityHashMap<>(AxeItemAccess.getStripables());

        stripables.put(LirothBlocks.LIROTH_LOG, LirothBlocks.STRIPPED_LIROTH_LOG);
        stripables.put(LirothBlocks.SPICED_LOG, LirothBlocks.STRIPPED_SPICED_LOG);
        stripables.put(LirothBlocks.TALLPIER_LOG, LirothBlocks.STRIPPED_TALLPIER_LOG);
        stripables.put(LirothBlocks.DAMNATION_LOG, LirothBlocks.STRIPPED_DAMNATION_LOG);
        stripables.put(LirothBlocks.JAPZ_LOG, LirothBlocks.STRIPPED_JAPZ_LOG);
        stripables.put(LirothBlocks.KOOLAW_LOG, LirothBlocks.STRIPPED_KOOLAW_LOG);
        stripables.put(LirothBlocks.PETRIFIED_DAMNATION_LOG, LirothBlocks.STRIPPED_PETRIFIED_DAMNATION_LOG);


        AxeItemAccess.setStripables(stripables);
        Liroth.LOGGER.info("Liroth: Strippables registered!");

    }
}