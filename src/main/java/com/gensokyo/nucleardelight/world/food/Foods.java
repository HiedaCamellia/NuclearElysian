package com.gensokyo.nucleardelight.world.food;

import com.gensokyo.nucleardelight.NuclearDelight;
import com.mojang.logging.LogUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
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
        try {
            Class<?> clazz = Foods.class;
            Field[] fields = clazz.getDeclaredFields();

            Map<String, FoodProperties> staticFinalFoodProperties = new HashMap<>();

            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers) && field.getType() == FoodProperties.class) {
                    boolean accessible = field.canAccess(null);
                    field.setAccessible(true);
                    FoodProperties value = (FoodProperties) field.get(null);
                    field.setAccessible(accessible);

                    staticFinalFoodProperties.put(field.getName(), value);
                }
            }

            // Print the names and values of the static final FoodProperties fields
            for (Map.Entry<String, FoodProperties> entry : staticFinalFoodProperties.entrySet()) {
                LOGGER.debug("Name: {}, Value: {}", entry.getKey(), entry.getValue());
                String id = entry.getKey().toLowerCase();
                Supplier<Item> getFoodItem = (()-> new Item((new Item.Properties()).food(entry.getValue())));

                NuclearDelight.ITEMS.register(id, getFoodItem);
            }
        } catch (IllegalAccessException e) {
            LOGGER.error("Failed to access field", e);
        }
    }
}
