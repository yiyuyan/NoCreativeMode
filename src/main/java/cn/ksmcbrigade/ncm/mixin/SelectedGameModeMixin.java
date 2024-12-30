package cn.ksmcbrigade.ncm.mixin;

import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldCreationUiState.SelectedGameMode.class)
public class SelectedGameModeMixin {

    @Mutable
    @Shadow @Final public Component displayName;

    @Mutable
    @Shadow @Final private Component info;

    @Inject(method = "<init>",at = @At("TAIL"))
    public void init(String p_268033_, int p_268252_, String par3, GameType par4, CallbackInfo ci){
        if(par4==GameType.CREATIVE){
            this.displayName = Component.translatable("selectWorld.gameMode." + "survival");
            this.info = Component.translatable("selectWorld.gameMode." + "survival" + ".info");
        }
    }
}
