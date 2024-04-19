package com.gensokyo.nucleardelight.world.food;

import com.gensokyo.nucleardelight.NuclearDelight;
import com.gensokyo.nucleardelight.Utils;
import com.mojang.logging.LogUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Foods {
    private static final Logger LOGGER = LogUtils.getLogger();

//    public static List<Item> FOODS = List.of();
//
//    public static List<Item> getFoods() {
//        return FOODS;
//    }

    public static final FoodProperties EXAMPLE_FOOD = new FoodProperties.Builder().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F)
            .nutrition(1)
            .saturationMod(2f).build();

    public static void Initializing() {
        LOGGER.debug("Initializing Foods");
        Map<String, FoodProperties> staticFinalFieldsNameAndValue = Utils.getStaticFinalFieldsNameAndValue(Foods.class, FoodProperties.class);
        staticFinalFieldsNameAndValue.forEach((name, value) -> {
            String id = name.toLowerCase();
            Supplier<Item> itemSupplier = () -> new Item(new Item.Properties().food(value));
            NuclearDelight.ITEMS.register(id, itemSupplier);
        });
    }
}
