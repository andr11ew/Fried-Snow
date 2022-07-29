package net.andr11ew.common.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class FriedSnowBowl extends Item {
    public FriedSnowBowl(Properties pProperties) {
        super(pProperties);
    }



    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity consumer) {
        if (!worldIn.isClientSide) {
            this.affectConsumer(stack, worldIn, consumer);
        }

        ItemStack containerStack = stack.getContainerItem();

        if (stack.isEdible()) {
            super.finishUsingItem(stack, worldIn, consumer);
        } else {
            Player player = consumer instanceof Player ? (Player) consumer : null;
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) player, stack);
            }
            if (player != null) {
                player.awardStat(Stats.ITEM_USED.get(this));
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
            }
        }

        if (stack.isEmpty()) {
            return containerStack;
        } else {
            if (consumer instanceof Player player && !((Player) consumer).getAbilities().instabuild) {
                if (!player.getInventory().add(containerStack)) {
                    player.drop(containerStack, false);
                }
            }
            return stack;
        }
    }


    public void affectConsumer(ItemStack stack, Level worldIn, LivingEntity consumer) {
    }





    private void onItemUseFinish(ItemStack stack, Level worldIn, LivingEntity subject, CallbackInfoReturnable<ItemStack> cir) {

        ItemStack container = stack.getContainerItem();
        if (container.isEmpty())
            container = new ItemStack(Items.BOWL);

        if (stack.isEdible()) {
            super.finishUsingItem(stack, worldIn, subject);
        } else {
            Player player = subject instanceof Player ? (Player) subject : null;
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) player, stack);
            }
            if (player != null) {
                player.awardStat(Stats.ITEM_USED.get(this));
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
            }
        }

        if (stack.isEmpty()) {
            cir.setReturnValue(container);
        } else {
            if (subject instanceof Player && !((Player) subject).getAbilities().instabuild) {
                Player player = (Player) subject;
                if (!player.getInventory().add(container)) {
                    player.drop(container, false);
                }
            }
            cir.setReturnValue(stack);
        }
    }




    }
