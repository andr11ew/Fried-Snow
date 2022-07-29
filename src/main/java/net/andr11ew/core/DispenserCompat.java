package net.andr11ew.core;

import net.andr11ew.common.entity.custom.FriedSnowball;
import net.andr11ew.common.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class DispenserCompat {

    public static void registerDispenserBehaviors() {


        DispenserBlock.registerBehavior(ModItems.FRIED_SNOWBALL_ITEM.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return new FriedSnowball(pLevel, pPosition.x(), pPosition.y(), pPosition.z());
            }
        });
    }


}
