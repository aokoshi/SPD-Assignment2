package app;

import gui.Button;
import gui.Checkbox;
import gui.GUIFactory;
import logistics.Logistics;

public class DeliveryApplication {

    private static final String CARGO = "laboratory equipment";
    private static final String DESTINATION = "Aktau warehouse";

    private final GUIFactory guiFactory;
    private final Logistics logistics;

    public DeliveryApplication(GUIFactory guiFactory, Logistics logistics) {
        this.guiFactory = guiFactory;
        this.logistics = logistics;
    }

    public void run() {
        renderInterface();
        logistics.planDelivery(CARGO, DESTINATION);
    }

    private void renderInterface() {
        Button button = guiFactory.createButton();
        Checkbox checkbox = guiFactory.createCheckbox();
        button.paint();
        checkbox.paint();
    }
}
