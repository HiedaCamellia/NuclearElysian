package org.hiedacamellia.nuclearelysian.world.effect;

import org.hiedacamellia.nuclearelysian.register.AutoRegistryObject;
import net.minecraft.world.effect.MobEffect;

public class MobEffects {
    public static final AutoRegistryObject<MobEffect> VOMITING = new AutoRegistryObject<>(VomitingMobEffect::new);
}
