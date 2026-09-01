/* SPDX-License-Identifier: MIT */
package io.github.follyworks.template.datagen;

import io.github.follyworks.template.TemplateMod;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public final class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(PackOutput output) {
        super(output, TemplateMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + TemplateMod.MODID, "Folly Template");
        add(TemplateMod.EXAMPLE_ITEM.get(), "Example Item");
    }
}
