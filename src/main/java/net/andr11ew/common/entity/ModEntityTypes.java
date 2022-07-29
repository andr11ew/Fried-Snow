package net.andr11ew.common.entity;

import net.andr11ew.common.FriedSnow;
import net.andr11ew.common.entity.custom.FriedSnowball;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;



public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, FriedSnow.MOD_ID);




    public static final RegistryObject<EntityType<FriedSnowball>> FRIED_SNOWBALL_ENTITY =
            ENTITY_TYPES.register("fried_snowball_entity",
                    () -> EntityType.Builder.<FriedSnowball>of(FriedSnowball::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(FriedSnow.MOD_ID, "fried_snowball_entity").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);


    }




}
