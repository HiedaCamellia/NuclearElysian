package com.gensokyo.nucleardelight.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class VomitingMobEffect extends MobEffect {

    protected VomitingMobEffect() {
        super(MobEffectCategory.HARMFUL, 0xA6A03A);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int level) {
        if (!entity.hasEffect(MobEffects.CONFUSION)) {
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION,
                    entity.getEffect(com.gensokyo.nucleardelight.world.effect.MobEffects.VOMITING.get()).getDuration(), 1));
        }
    }

    @Override
    public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
        return true;
    }
}
