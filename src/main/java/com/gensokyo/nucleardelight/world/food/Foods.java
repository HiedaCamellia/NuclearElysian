package com.gensokyo.nucleardelight.world.food;

import com.gensokyo.nucleardelight.world.effect.MobEffects;
import com.mojang.logging.LogUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import org.slf4j.Logger;

public class Foods {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final FoodProperties APPLE_JAM_JAR = new FoodProperties.Builder().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.VOMITING.get(), 1000, 1), 1.0F)
            .nutrition(1)
            .saturationMod(2f).build();
}
