package net.andr11ew.common.item;

import net.andr11ew.common.FriedSnow;
import net.andr11ew.common.item.custom.FriedSnowBowl;
import net.andr11ew.common.item.custom.FriedSnowballItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems extends Item  {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FriedSnow.MOD_ID);



public  static final RegistryObject<Item> FRIED_SNOWBALL_ITEM = ITEMS.register("fried_snowball_item",
        () -> new FriedSnowballItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(16)));

    public  static final RegistryObject<Item> FRIED_SNOW_BOWL = ITEMS.register("fried_snow_bowl",
            () -> new FriedSnowBowl(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1).food(ModFoods.FRIED_SNOW_BOWL).craftRemainder(Items.BOWL)));

    public ModItems(Properties pProperties) {
        super(pProperties);
    }



    public static void register(IEventBus eventBus) {
            ITEMS.register(eventBus);
    }





}
