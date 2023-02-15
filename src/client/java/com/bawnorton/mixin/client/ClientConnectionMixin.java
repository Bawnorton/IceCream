package com.bawnorton.mixin.client;

import com.bawnorton.IceCreamClient;
import com.bawnorton.listener.FlavourListener.FlavourOutEvent;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ClientConnection.class)
public abstract class ClientConnectionMixin {
    @ModifyVariable(method = "send(Lnet/minecraft/network/Packet;Lnet/minecraft/network/PacketCallbacks;)V", at = @At("HEAD"), argsOnly = true)
    private Packet<?> icecream$onSend(Packet<?> value) {
        FlavourOutEvent event = new FlavourOutEvent(value);
        event.serve(IceCreamClient.FLAVOUR);
        return event.getFlavour();
    }
}
