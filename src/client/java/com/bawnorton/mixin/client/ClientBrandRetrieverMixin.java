package com.bawnorton.mixin.client;

import com.bawnorton.IceCreamClient;
import net.minecraft.client.ClientBrandRetriever;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientBrandRetriever.class)
public abstract class ClientBrandRetrieverMixin {
    @Inject(method = "getClientModName", at = @At("HEAD"), cancellable = true, remap = false)
    private static void icecream$onGetClientModName(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue(IceCreamClient.FLAVOUR.brand());
    }
}
