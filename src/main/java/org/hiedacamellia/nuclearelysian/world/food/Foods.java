package org.hiedacamellia.nuclearelysian.world.food;

import org.hiedacamellia.nuclearelysian.datagenerator.Lang;
import org.hiedacamellia.nuclearelysian.datagenerator.LangName;
import org.hiedacamellia.nuclearelysian.datagenerator.Langs;
import org.hiedacamellia.nuclearelysian.world.effect.MobEffects;
import com.mojang.logging.LogUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import org.slf4j.Logger;

public class Foods {
    private static final Logger LOGGER = LogUtils.getLogger();

    @Langs({
            @Lang(lang = LangName.EN_US, name = "Apple Jam Jar"),
            @Lang(lang = LangName.ZH_CN, name = "苹果果酱罐")
    })
    public static final FoodProperties APPLE_JAM_JAR = new FoodProperties.Builder().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.VOMITING.get(), 1000, 1), 1.0F)
            .nutrition(1)
            .saturationMod(2f).build();

    @Langs({
            @Lang(lang = LangName.EN_US, name = "Creeper Jam Jar"),
            @Lang(lang = LangName.ZH_CN, name = "苦力怕果酱罐")
    })
    public static final FoodProperties CREEPER_JAM_JAR = new FoodProperties.Builder().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.VOMITING.get(), 1000, 1), 1.0F)
            .nutrition(1)
            .saturationMod(2f).build();
}
