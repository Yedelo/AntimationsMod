package at.yedel.antimations.mixin;



import static at.yedel.antimations.Antimations.cancelServerAnimations;

import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.server.S0BPacketAnimation;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;




@Mixin(NetHandlerPlayClient.class)
public class MixinNetHandlerPlayClient {
    @Inject(method = "handleAnimation", at = @At("HEAD"), cancellable = true)
    public void onPacketAnimation(S0BPacketAnimation packetIn, CallbackInfo ci) {
        if (packetIn.getAnimationType() == 0 && cancelServerAnimations) {
            ci.cancel();
        }
    }
}
