package cn.ksmcbrigade.sl.mixin;

import cn.ksmcbrigade.sl.StrongLuck;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LootPool.class)
public class LootPoolMixin {
    @Redirect(method = "addRandomItems",at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/loot/providers/number/NumberProvider;getInt(Lnet/minecraft/world/level/storage/loot/LootContext;)I"))
    public int rolls(NumberProvider instance, LootContext p_165729_){
        return (instance.getInt(p_165729_)+ StrongLuck.ROLLS.getValue());
    }
}
