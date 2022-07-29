package net.andr11ew.common.event.loot;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class FriedSnowballSpawn extends LootModifier {
    private final Item addition;

    protected FriedSnowballSpawn(LootItemCondition[] conditionsIn, Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextFloat() > 0.6f) {
            Random random = new Random();
            int numberOfItems = random.nextInt(7)+3;
            generatedLoot.add(new ItemStack(addition, numberOfItems));
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<FriedSnowballSpawn> {

        @Override
        public FriedSnowballSpawn read(ResourceLocation name, JsonObject object,
                                       LootItemCondition[] conditionsIn) {
            Item addition = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new FriedSnowballSpawn(conditionsIn, addition);
        }

        @Override
        public JsonObject write(FriedSnowballSpawn instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }
}
