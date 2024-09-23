package it.italiandudes.spaceengineering;

import com.mojang.logging.LogUtils;
import it.italiandudes.spaceengineering.block.ModBlocks;
import it.italiandudes.spaceengineering.creativetab.ModCreativeModeTabs;
import it.italiandudes.spaceengineering.item.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(SpaceEngineering.MOD_ID)
public final class SpaceEngineering {

    // Attributes
    @NotNull public static final String MOD_ID = "spaceengineering";
    @NotNull public static final Logger LOGGER = LogUtils.getLogger();

    // Constructors
    public SpaceEngineering(@NotNull final FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Registering Creative Mode Tabs
        ModCreativeModeTabs.register(modEventBus);

        // Registering Items
        ModItems.register(modEventBus);

        // Registering Blocks
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    // Methods
    private void commonSetup(@NotNull final FMLCommonSetupEvent event) {}
    @SubscribeEvent
    public void onServerStarting(@NotNull final ServerStartingEvent event) {}

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(@NotNull final FMLClientSetupEvent event) {}
    }
}
