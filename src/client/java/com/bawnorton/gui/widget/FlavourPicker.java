package com.bawnorton.gui.widget;

import com.bawnorton.IceCreamClient;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class FlavourPicker extends ButtonWidget {

    public FlavourPicker(int x, int y, int width, int height) {
        super(x, y, width, height, Text.of(capitalize(IceCreamClient.FLAVOUR.getName())), button -> {
            IceCreamClient.FLAVOUR = IceCreamClient.FLAVOUR.next();
            button.setMessage(Text.of(capitalize(IceCreamClient.FLAVOUR.getName())));
        }, ButtonWidget.DEFAULT_NARRATION_SUPPLIER);

        setTooltip(Tooltip.of(Text.of("Click to change your ice cream flavour (Client)")));
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
