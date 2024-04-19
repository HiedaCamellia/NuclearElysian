package com.gensokyo.nucleardelight.datagenerator;

import com.gensokyo.nucleardelight.NuclearDelight;
import net.minecraft.data.PackOutput;
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
        items.forEach(item ->
                singleTexture(item.getDescriptionId(), mcLoc("item/handheld"), "layer0", modLoc("item/" + item.getDescriptionId())));
    }
}
