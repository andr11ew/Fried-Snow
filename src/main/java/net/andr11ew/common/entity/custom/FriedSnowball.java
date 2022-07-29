package net.andr11ew.common.entity.custom;

import net.andr11ew.common.entity.ModEntityTypes;
import net.andr11ew.common.item.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;


public class FriedSnowball extends ThrowableItemProjectile {


    public FriedSnowball(EntityType<? extends FriedSnowball> p_37391_, Level p_37392_) {
        super(p_37391_, p_37392_);
    }

    public FriedSnowball(Level p_37399_, LivingEntity p_37400_) {
        super(ModEntityTypes.FRIED_SNOWBALL_ENTITY.get(), p_37400_, p_37399_);
    }

    public FriedSnowball(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
        super(ModEntityTypes.FRIED_SNOWBALL_ENTITY.get(), p_37395_, p_37396_, p_37397_, p_37394_);
    }


    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        Entity entity = pResult.getEntity();
        entity.setSecondsOnFire(1);
        entity.hurt(DamageSource.thrown(this, this.getOwner()), 0.0f);
    }


    @Override
    protected Item getDefaultItem() {
        return ModItems.FRIED_SNOWBALL_ITEM.get();
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(ModItems.FRIED_SNOWBALL_ITEM.get());
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return (ParticleOptions)(itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleOption(ParticleTypes.ITEM, itemstack));
    }

    public void handleEntityEvent(byte pId) {
        if (pId == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }
}

