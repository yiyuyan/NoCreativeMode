package cn.ksmcbrigade.sl.mixin;

import cn.ksmcbrigade.sl.StrongLuck;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AttributeInstance.class)
public class AttributeInstanceMixin {

    @Shadow @Final private Holder<Attribute> attribute;

    @Inject(method = {"getValue","getBaseValue"},at = @At("RETURN"),cancellable = true)
    public void value(CallbackInfoReturnable<Double> cir){
        if(this.attribute.equals(Attributes.LUCK)) cir.setReturnValue(cir.getReturnValue()+ StrongLuck.LUCK.getValue().floatValue());
    }
}
