package org.hiedacamellia.nuclearelysian;

import org.hiedacamellia.nuclearelysian.datagenerator.LangName;
import org.hiedacamellia.nuclearelysian.datagenerator.Langs;
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
import java.util.stream.Stream;

public class Utils {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static Field[] getStaticFinalFields(Class<?> clazz, Class<?> valueType) {
        Field[] fields = clazz.getDeclaredFields();
        return Stream.of(fields).filter(field -> {
            int modifiers = field.getModifiers();
            return Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers) && field.getType() == valueType;
        }).toList().toArray(new Field[0]);
    }

    public static <T> Map<String, T> getStaticFinalFieldsNameAndValueFrom(Class<?> clazz, Class<T> valueType) {
        Map<String, T> staticFinalFieldsNameAndValue = new HashMap<>();
        try {
            Field[] fields = getStaticFinalFields(clazz, valueType);
            for (Field field : fields) {
                field.setAccessible(true);
                staticFinalFieldsNameAndValue.put(field.getName(), (T) field.get(null));
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            LOGGER.error("Failed to get field", e);
        }
        return staticFinalFieldsNameAndValue;
    }

    public static <T> Map.Entry<String, T> getNameAndValueFromField(Field field) {
        try {
            field.setAccessible(true);
            return Map.entry(field.getName(), (T) field.get(null));
        } catch (IllegalArgumentException | IllegalAccessException e) {
            LOGGER.error("Failed to get field", e);
            return null;
        }
    }

    public static <T> List<Map.Entry<String, T>> getNameAndValueFromFields(Field[] fields) {
        return Stream.of(fields).map(Utils::getNameAndValueFromField).map(entry -> (Map.Entry<String, T>) entry).toList();
    }

    public static Map<LangName, String> getLangFromField(Field field) {
        Langs langs = field.getAnnotation(Langs.class);
        if (langs == null) {
            return Map.of();
        }
        Map<LangName, String> langNameAndName = new HashMap<>();
        for (int i = 0; i < langs.value().length; i++) {
            langNameAndName.put(langs.value()[i].lang(), langs.value()[i].name());
        }
        return langNameAndName;
    }

    public static <T> List<RegistryObject<T>> registryObjects(DeferredRegister<T> register, Map<String, Supplier<T>> idAndObjectPairs) {
        return idAndObjectPairs.entrySet().stream().map(entry -> register.register(entry.getKey(), entry.getValue())).toList();
    }
}
