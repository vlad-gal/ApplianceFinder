package by.halatsevich.finder.factory.impl;

import by.halatsevich.finder.entity.Appliance;
import by.halatsevich.finder.entity.TabletPC;
import by.halatsevich.finder.factory.ApplianceCreator;
import by.halatsevich.finder.parameter.ApplianceParameter;

import java.util.Map;

public class TabletPCCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(Map<String, String> applianceParameter) {
        TabletPC tabletPC = new TabletPC();
        double batteryCapacity = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.BATTERY_CAPACITY.getParameterName()));
        double displayInches = Integer
                .parseInt(applianceParameter.get(ApplianceParameter.DISPLAY_INCHES.getParameterName()));
        double memoryROM = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.MEMORY_ROM.getParameterName()));
        double flashMemoryCapacity = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.FLASH_MEMORY_CAPACITY.getParameterName()));
        String color = applianceParameter.get(ApplianceParameter.COLOR.getParameterName());
        tabletPC.setBatteryCapacity(batteryCapacity);
        tabletPC.setDisplayInches(displayInches);
        tabletPC.setMemoryROM(memoryROM);
        tabletPC.setFlashMemoryCapacity(flashMemoryCapacity);
        tabletPC.setColor(color);
        return tabletPC;
    }
}
