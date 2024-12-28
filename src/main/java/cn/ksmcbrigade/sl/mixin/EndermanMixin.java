package cn.ksmcbrigade.sl.mixin;

import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(EnderMan.class)
public class EndermanMixin {
    @Inject(method = "isLookingAtMe",at = @At("RETURN"),cancellable = true)
    public void noLook(Player p_32535_, CallbackInfoReturnable<Boolean> cir){
        if(cir.getReturnValue() && new Random().nextDouble()<0.65){
            cir.setReturnValue(false);
        }
    }
}
