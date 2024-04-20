package com.gensokyo.nucleardelight.datagenerator;

import com.gensokyo.nucleardelight.NuclearDelight;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Collection;

public class SingleTextureItemModelGenerator extends ItemModelProvider {

    private final Collection<Item> items;

    public SingleTextureItemModelGenerator(Collection<Item> items, PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NuclearDelight.MODID, existingFileHelper);
        this.items = items;
    }

    @Override
    protected void registerModels() {
        items.stream().map(SingleTextureItemModelGenerator::getNameFromItem).forEach(itemName ->
                singleTexture(itemName, new ResourceLocation("item/generated"), "layer0", modLoc("item/" + itemName)));
    }

    private static String getNameFromItem(Item item) {
        return getNameFromDescriptionId(item.getDescriptionId());
    }

    private static String getNameFromDescriptionId(String descriptionId) {
        String[] strings = descriptionId.split("\\.");
        return strings[strings.length - 1];
    }
}
