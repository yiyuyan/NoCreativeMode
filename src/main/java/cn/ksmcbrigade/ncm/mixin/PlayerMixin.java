package cn.ksmcbrigade.ncm.mixin;

import net.minecraft.client.gui.screens.debug.GameModeSwitcherScreen;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public abstract class PlayerMixin {

    @Shadow @Final public ServerPlayerGameMode gameMode;

    @Shadow public abstract boolean setGameMode(GameType p_143404_);

    @Inject(method = "tick",at = @At("TAIL"))
    public void tick(CallbackInfo ci){
        if(this.gameMode.getGameModeForPlayer() == GameType.CREATIVE){
            this.setGameMode(GameType.SURVIVAL);
        }
    }
}
