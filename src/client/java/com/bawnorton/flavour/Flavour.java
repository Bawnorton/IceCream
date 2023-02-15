package com.bawnorton.flavour;

import com.bawnorton.config.Config;
import com.bawnorton.listener.FlavourListener;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;

public class Flavour implements FlavourListener {

    private Config.Flavour flavour;

    public Flavour(Config.Flavour flavour) {
        this.flavour = flavour;
    }

    public Flavour next() {
        this.flavour = flavour.next();
        return new Flavour(flavour);
    }

    public String getName() {
        return flavour.name();
    }

    @Override
    public void onSentFlavour(FlavourOutEvent event) {
         if(event.getFlavour() instanceof CustomPayloadC2SPacket) {
             event.setFlavour(new CustomPayloadC2SPacket(flavour.brand(), flavour.data()));
         }
    }
}
