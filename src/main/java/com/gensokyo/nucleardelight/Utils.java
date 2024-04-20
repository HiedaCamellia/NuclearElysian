package com.gensokyo.nucleardelight;

import com.mojang.logging.LogUtils;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Utils {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static <T> Map<String, T> getStaticFinalFieldsNameAndValue(Class<?> clazz, Class<T> valueType) {
        Map<String, T> staticFinalFieldsNameAndValue = new HashMap<>();
        try {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers) && field.getType() == valueType) {
                    boolean accessible = field.canAccess(null);
                    field.setAccessible(true);
                    T value = (T) field.get(null);
                    field.setAccessible(accessible);

                    staticFinalFieldsNameAndValue.put(field.getName(), value);
                }
            }
        } catch (IllegalAccessException e) {
            LOGGER.error("Failed to access field", e);
        }
        return staticFinalFieldsNameAndValue;
    }

    public static <T> List<RegistryObject<T>> registryObjects(DeferredRegister<T> register, Map<String, Supplier<T>> idAndObjectPairs) {
        return idAndObjectPairs.entrySet().stream().map(entry -> register.register(entry.getKey(), entry.getValue())).toList();
    }
}
