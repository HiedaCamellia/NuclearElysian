package com.gensokyo.nucleardelight.datagenerator;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerator {
    @SubscribeEvent
    public static void dataGen(GatherDataEvent event) {
//        event.getGenerator().addProvider();
    }
}
