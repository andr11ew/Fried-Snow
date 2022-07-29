package net.andr11ew.common.event;


import net.andr11ew.common.FriedSnow;
import net.andr11ew.common.entity.ModEntityTypes;
import net.andr11ew.common.event.loot.FriedSnowballSpawn;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = FriedSnow.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {


    @SubscribeEvent
    public static void entityRender(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntityTypes.FRIED_SNOWBALL_ENTITY.get(), ThrownItemRenderer::new);
    }




    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().register(new FriedSnowballSpawn.Serializer().setRegistryName
                (new ResourceLocation(FriedSnow.MOD_ID,"fried_snowball_in_igloo_chest")));
        event.getRegistry().register(new FriedSnowballSpawn.Serializer().setRegistryName
                (new ResourceLocation(FriedSnow.MOD_ID,"fried_snowball_in_ruined_portal")));
        event.getRegistry().register(new FriedSnowballSpawn.Serializer().setRegistryName
                (new ResourceLocation(FriedSnow.MOD_ID,"fried_snowball_in_village_snowy_house")));
    }
}
