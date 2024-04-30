package org.hiedacamellia.nuclearelysian.datagenerator;

import org.hiedacamellia.nuclearelysian.NuclearDelight;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class LangGenerator extends LanguageProvider {
    public LangGenerator(PackOutput output, String locale) {
        super(output, NuclearDelight.MODID, locale);
        this.locale = locale;
    }

    private final String locale;

    @Override
    protected void addTranslations() {
        NuclearDelight.LangKeyValuePairs.get(locale).forEach((key, value) -> add(key.get(), value));
    }
}
