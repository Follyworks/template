/* SPDX-License-Identifier: MIT */
package io.github.dizzymii.folly.template.gametest;

import io.github.dizzymii.folly.template.TemplateMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestAssertException;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

/**
 * STUDIO-10: the cheapest test that fails when the mod does not load. If registration throws or a
 * DeferredRegister is never bound to the mod event bus, the game crashes on launch and this never
 * reaches its assertion - which is the point. Run by CI via {@code ./gradlew runGameTestServer}.
 */
@GameTestHolder(TemplateMod.MODID)
@PrefixGameTestTemplate(false)
public final class SmokeTest {

    private SmokeTest() {}

    @GameTest(template = "empty", batch = "smoke")
    public static void registriesPopulated(GameTestHelper helper) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(TemplateMod.MODID, "example_item");
        if (BuiltInRegistries.ITEM.get(id) == Items.AIR) {
            throw new GameTestAssertException(id + " is not in the item registry");
        }
        helper.succeed();
    }
}
