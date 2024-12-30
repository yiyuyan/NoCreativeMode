package cn.ksmcbrigade.ncm.mixin;

import net.minecraft.commands.arguments.GameModeArgument;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mixin(GameModeArgument.class)
public class GameModeArgumentMixin {
    @Mutable
    @Shadow @Final private static GameType[] VALUES;

    @Mutable
    @Shadow @Final private static Collection<String> EXAMPLES;

    @Inject(method = "<clinit>",at = @At("TAIL"))
    private static void client(CallbackInfo ci){
        EXAMPLES = Stream.of(GameType.SURVIVAL).map(GameType::getName).collect(Collectors.toList());
        VALUES = new GameType[]{GameType.SURVIVAL,GameType.ADVENTURE,GameType.SPECTATOR};
    }
}
