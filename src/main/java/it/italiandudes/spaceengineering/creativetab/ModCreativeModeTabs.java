package it.italiandudes.spaceengineering.creativetab;

import it.italiandudes.spaceengineering.SpaceEngineering;
import it.italiandudes.spaceengineering.block.ModBlocks;
import it.italiandudes.spaceengineering.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public final class ModCreativeModeTabs {

    // Registers
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SpaceEngineering.MOD_ID);

    // Register Methods
    public static void register(@NotNull final IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    // Creative Tabs
    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SAPPHIRE.get())) // Set the icon from an existing item
                    .title(Component.translatable("creativetab.tutorial_tab")) // Create a key for the translation files
                    .displayItems((pParameters, pOutput) -> { // Registry here all the things you want inside this tab
                        // Items
                        pOutput.accept(ModItems.SAPPHIRE.get()); // .get() only for custom items, for the vanilla one use just Item.ITEM_NAME
                        pOutput.accept(ModItems.RAW_SAPPHIRE.get());

                        // Blocks
                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                    })
                    .build()
    );
}
