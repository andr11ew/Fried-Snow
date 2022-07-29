package net.andr11ew.common;

import com.mojang.logging.LogUtils;
import net.andr11ew.common.entity.ModEntityTypes;
import net.andr11ew.common.item.ModItems;
import net.andr11ew.core.DispenserCompat;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FriedSnow.MOD_ID)
public class FriedSnow
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "friedsnow";

    public FriedSnow()
    {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        ModEntityTypes.register(eventBus);
        eventBus.addListener(this::setup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
       DispenserCompat.registerDispenserBehaviors();
    }


}
