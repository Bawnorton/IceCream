package com.bawnorton.listener;

import com.bawnorton.event.Event;
import net.minecraft.network.Packet;

import java.util.EventListener;

public interface FlavourListener extends EventListener {

    void onSentFlavour(FlavourOutEvent event);

    class FlavourOutEvent extends Event<FlavourListener> {
        private Packet<?> flavour;

        public FlavourOutEvent(Packet<?> flavour) {
            this.flavour = flavour;
        }

        public Packet<?> getFlavour() {
            return flavour;
        }

        public void setFlavour(Packet<?> flavour) {
            this.flavour = flavour;
        }

        @Override
        public void serve(FlavourListener listener) {
            listener.onSentFlavour(this);
        }
    }
}
