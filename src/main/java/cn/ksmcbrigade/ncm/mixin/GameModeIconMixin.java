package cn.ksmcbrigade.ncm.mixin;

import net.minecraft.client.gui.screens.debug.GameModeSwitcherScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.client.gui.screens.debug.GameModeSwitcherScreen.GameModeIcon.*;

@Mixin(GameModeSwitcherScreen.GameModeIcon.class)
public abstract class GameModeIconMixin {
    @Mutable
    @Shadow @Final
    public static GameModeSwitcherScreen.GameModeIcon[] VALUES;

    @Shadow @Final
    Component name;

    @Shadow abstract Component getName();

    @Inject(method = "<clinit>",at = @At("TAIL"))
    private static void initClient(CallbackInfo ci){
        VALUES = new GameModeSwitcherScreen.GameModeIcon[]{GameModeSwitcherScreen.GameModeIcon.SURVIVAL, GameModeSwitcherScreen.GameModeIcon.SPECTATOR, GameModeSwitcherScreen.GameModeIcon.ADVENTURE};
    }

    @Inject(method = {"getFromGameType"},at = @At("RETURN"),cancellable = true)
    private static void get(CallbackInfoReturnable<GameModeSwitcherScreen.GameModeIcon> cir){
        if(cir.getReturnValue().equals(CREATIVE)) cir.setReturnValue(GameModeSwitcherScreen.GameModeIcon.SURVIVAL);
    }

    /**
     * @author KSmc_brigade
     * @reason remove the creative mode
     */
    @Overwrite
    GameModeSwitcherScreen.GameModeIcon getNext() {
        GameModeSwitcherScreen.GameModeIcon var10000;
        switch (valueOf(this.getName())) {
            case SURVIVAL -> var10000 = ADVENTURE;
            case ADVENTURE -> var10000 = SPECTATOR;
            case SPECTATOR -> var10000 = SURVIVAL;
            default -> throw new IncompatibleClassChangeError();
        }

        return var10000;
    }

    public GameModeSwitcherScreen.GameModeIcon valueOf(Component component){
        for (GameModeSwitcherScreen.GameModeIcon value : GameModeSwitcherScreen.GameModeIcon.VALUES) {
            if(value.getName().equals(component)){
                return value;
            }
        }
        return GameModeSwitcherScreen.GameModeIcon.SURVIVAL;
    }
}
