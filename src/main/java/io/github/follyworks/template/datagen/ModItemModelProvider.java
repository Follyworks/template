/* SPDX-License-Identifier: MIT */
package io.github.follyworks.template.datagen;

import io.github.follyworks.template.TemplateMod;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public final class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TemplateMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(TemplateMod.EXAMPLE_ITEM.get());
    }
}
