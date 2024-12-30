package cn.ksmcbrigade.ncm.mixin;

import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CreateWorldScreen.GameTab.class)
public class GameTabMixin<T> {
    @Redirect(method = "<init>",at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/CycleButton$Builder;withValues([Ljava/lang/Object;)Lnet/minecraft/client/gui/components/CycleButton$Builder;",ordinal = 0))
    public CycleButton.Builder<WorldCreationUiState.SelectedGameMode> init(CycleButton.Builder<WorldCreationUiState.SelectedGameMode> instance, T[] p_168962_){
        return instance.withValues(WorldCreationUiState.SelectedGameMode.SURVIVAL, WorldCreationUiState.SelectedGameMode.HARDCORE);
    }
}
