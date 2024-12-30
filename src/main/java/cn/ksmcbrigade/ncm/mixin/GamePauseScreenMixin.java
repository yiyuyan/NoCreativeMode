package cn.ksmcbrigade.ncm.mixin;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Supplier;

@Mixin(PauseScreen.class)
public class GamePauseScreenMixin {
    @Shadow @Final private static Component SHARE_TO_LAN;

    @Inject(method = "openScreenButton",at = @At("RETURN"),cancellable = true)
    private void open(Component p_262567_, Supplier<Screen> p_262581_, CallbackInfoReturnable<Button> cir){
        Button ret = cir.getReturnValue();
        ret.active = false;
        if(p_262567_.equals(SHARE_TO_LAN)) cir.setReturnValue(ret);
    }
}
