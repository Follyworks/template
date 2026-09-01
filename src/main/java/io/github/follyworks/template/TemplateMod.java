/* SPDX-License-Identifier: MIT */
package io.github.follyworks.template;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Entry point. Rename the class, the package leaf and {@link #MODID} together - {@code mod_id} in
 * gradle.properties must match {@link #MODID} exactly or the build fails at resource processing.
 */
@Mod(TemplateMod.MODID)
public final class TemplateMod {

    public static final String MODID = "template";

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    /** Delete once the mod has real content. It exists so datagen and the smoke test have a subject. */
    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB =
            TABS.register("main", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + MODID))
                    .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
                    .displayItems((params, output) -> output.accept(EXAMPLE_ITEM.get()))
                    .build());

    public TemplateMod(IEventBus modEventBus, ModContainer modContainer) {
        ITEMS.register(modEventBus);
        TABS.register(modEventBus);
    }
}
