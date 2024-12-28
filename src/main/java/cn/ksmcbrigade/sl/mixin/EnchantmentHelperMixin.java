package cn.ksmcbrigade.sl.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @Inject(method = "getFishingTimeReduction",at = @At("HEAD"),cancellable = true)
    private static void time(ServerLevel p_345589_, ItemStack p_344902_, Entity p_346054_, CallbackInfoReturnable<Float> cir){
        cir.setReturnValue(29F);
    }

    @Inject(method = "getFishingLuckBonus",at = @At("HEAD"),cancellable = true)
    private static void bonus(ServerLevel p_345589_, ItemStack p_344902_, Entity p_346054_, CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(100);
    }
}
