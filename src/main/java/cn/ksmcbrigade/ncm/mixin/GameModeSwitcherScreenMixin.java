package cn.ksmcbrigade.ncm.mixin;

import net.minecraft.client.gui.screens.debug.GameModeSwitcherScreen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameModeSwitcherScreen.class)
public class GameModeSwitcherScreenMixin {
    @Mutable
    @Shadow @Final private static int ALL_SLOTS_WIDTH;

    @Inject(method = "<clinit>",at = @At("TAIL"))
    private static void client(CallbackInfo ci){
        ALL_SLOTS_WIDTH = GameModeSwitcherScreen.GameModeIcon.VALUES.length * 31 - 5;
    }
}
