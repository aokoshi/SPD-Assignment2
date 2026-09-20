package app;

import gui.GUIFactory;
import gui.MacOSFactory;
import gui.WindowsFactory;
import logistics.Logistics;
import logistics.RoadLogistics;
import logistics.SeaLogistics;

public class Main {

    private static final String USAGE = "Usage: java app.Main <ROAD|SEA> <WINDOWS|MACOS>";

    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new IllegalArgumentException("Expected 2 arguments: delivery mode and UI platform.");
            }
            String deliveryMode = normalize(args[0]);
            String uiPlatform = normalize(args[1]);

            Logistics logistics = selectLogistics(deliveryMode);
            GUIFactory guiFactory = selectGuiFactory(uiPlatform);

            System.out.println("Delivery mode: " + deliveryMode);
            System.out.println("UI platform: " + uiPlatform);
            new DeliveryApplication(guiFactory, logistics).run();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println(USAGE);
            System.exit(1);
        }
    }

    private static String normalize(String value) {
        return value.trim().toUpperCase();
    }

    private static Logistics selectLogistics(String deliveryMode) {
        return switch (deliveryMode) {
            case "ROAD" -> new RoadLogistics();
            case "SEA" -> new SeaLogistics();
            default -> throw new IllegalArgumentException(
                    "Unsupported delivery mode '" + deliveryMode + "'. Supported: ROAD, SEA.");
        };
    }

    private static GUIFactory selectGuiFactory(String uiPlatform) {
        return switch (uiPlatform) {
            case "WINDOWS" -> new WindowsFactory();
            case "MACOS" -> new MacOSFactory();
            default -> throw new IllegalArgumentException(
                    "Unsupported UI platform '" + uiPlatform + "'. Supported: WINDOWS, MACOS.");
        };
    }
}
