package cn.ksmcbrigade.sl.mixin;

import cn.ksmcbrigade.sl.StrongLuck;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({LootParams.class, LootContext.class})
public class LootMixin {
    @Inject(method = "getLuck",at = @At("RETURN"),cancellable = true)
    public void luck(CallbackInfoReturnable<Float> cir){
        cir.setReturnValue(StrongLuck.LOOT_LUCK.getValue().floatValue());
    }
}
