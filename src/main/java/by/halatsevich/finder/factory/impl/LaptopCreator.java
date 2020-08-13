package by.halatsevich.finder.factory.impl;

import by.halatsevich.finder.entity.Appliance;
import by.halatsevich.finder.entity.Laptop;
import by.halatsevich.finder.factory.ApplianceCreator;
import by.halatsevich.finder.parameter.ApplianceParameter;

import java.util.Map;

public class LaptopCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(Map<String, String> applianceParameter) {
        Laptop laptop = new Laptop();
        double batteryCapacity = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.BATTERY_CAPACITY.getParameterName()));
        String operationSystem = applianceParameter.get(ApplianceParameter.OS.getParameterName());
        double memoryROM = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.MEMORY_ROM.getParameterName()));
        double systemMemory = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.SYSTEM_MEMORY.getParameterName()));
        double CPU = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.CPU.getParameterName()));
        double displayInches = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.DISPLAY_INCHES.getParameterName()));
        laptop.setBatteryCapacity(batteryCapacity);
        laptop.setOperationSystem(operationSystem);
        laptop.setMemoryROM(memoryROM);
        laptop.setSystemMemory(systemMemory);
        laptop.setCPU(CPU);
        laptop.setDisplayInches(displayInches);
        return laptop;
    }
}
