package com.bawnorton.mixin.client;

import com.bawnorton.IceCreamClient;
import com.bawnorton.gui.widget.FlavourPicker;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.util.Window;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MultiplayerScreen.class)
public abstract class MultiplayerScreenMixin extends Screen {
    protected MultiplayerScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("HEAD"))
    private void icecream$onInit(CallbackInfo info) {
        assert client != null;
        Window window = client.getWindow();
        width = window.getScaledWidth();
        addDrawableChild(new FlavourPicker(width - 106, 6, 100, 20));
    }
}
