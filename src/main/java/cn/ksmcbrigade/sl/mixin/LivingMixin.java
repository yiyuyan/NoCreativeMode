package cn.ksmcbrigade.sl.mixin;

import cn.ksmcbrigade.sl.utils.Self;
import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(LivingEntity.class)
public abstract class LivingMixin implements Self<LivingEntity> {
    @Shadow public abstract boolean removeEffect(Holder<MobEffect> p_316570_);

    @Inject(method = "onEffectAdded",at = @At("HEAD"),cancellable = true)
    public void effectAdded(MobEffectInstance p_147190_, Entity p_147191_, CallbackInfo ci){
        if(!(this.getSelf() instanceof Player)) return;
        if((p_147190_.getEffect().value().getCategory().equals(MobEffectCategory.HARMFUL)) || (p_147190_.getEffect().value().getCategory().equals(MobEffectCategory.NEUTRAL) && new Random().nextBoolean())){
            this.removeEffect(p_147190_.getEffect());
            ci.cancel();
        }
    }

    @Inject(method = "hurt",at = @At("HEAD"),cancellable = true)
    public void hurt(DamageSource p_21016_, float p_21017_, CallbackInfoReturnable<Boolean> cir){
        if(!(this.getSelf() instanceof Player)) return;
        double r = new Random().nextDouble();
        if(r < 0.75) cir.setReturnValue(true);
    }
}
