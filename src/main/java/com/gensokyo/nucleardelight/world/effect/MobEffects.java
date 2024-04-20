package com.gensokyo.nucleardelight.world.effect;

import com.gensokyo.nucleardelight.register.AutoRegistryObject;
import net.minecraft.world.effect.MobEffect;

public class MobEffects {
    public static final AutoRegistryObject<MobEffect> VOMITING = new AutoRegistryObject<>(VomitingMobEffect::new);
}
