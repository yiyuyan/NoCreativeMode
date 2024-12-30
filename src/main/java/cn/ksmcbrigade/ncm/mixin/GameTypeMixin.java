package cn.ksmcbrigade.ncm.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameType.class)
public class GameTypeMixin {
    @Mutable
    @Shadow @Final private String name;

    @Mutable
    @Shadow @Final private Component longName;

    @Mutable
    @Shadow @Final private Component shortName;

    @Inject(method = "isCreative",at = @At("RETURN"),cancellable = true)
    public void creative(CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(false);
    }

    @Inject(method = "<init>",at = @At("TAIL"))
    public void init(String p_46390_, int p_46391_, int par3, String par4, CallbackInfo ci){
        if(p_46390_.equalsIgnoreCase("creative")){
            this.name = "survival";
            this.longName = Component.translatable("selectWorld.gameMode.survival");
            this.shortName = Component.translatable("gameMode.survival");
        }
    }
}
