package at.yedel.antimations.mixin;



import static at.yedel.antimations.Antimations.cancelClientAnimations;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



@Mixin(EntityLivingBase.class)
public abstract class MixinEntityLivingBase extends MixinEntity {
    @Inject(method = "swingItem", at = @At("HEAD"), cancellable = true)
    public void setSwingingToFalse(CallbackInfo ci) {
        if ((Object) this instanceof EntityPlayerSP) {
            if (cancelClientAnimations) {
                ci.cancel();
            }
        }
    }
}
