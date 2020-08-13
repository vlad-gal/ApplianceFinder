package by.halatsevich.finder.factory.impl;

import by.halatsevich.finder.entity.Appliance;
import by.halatsevich.finder.entity.Oven;
import by.halatsevich.finder.factory.ApplianceCreator;
import by.halatsevich.finder.parameter.ApplianceParameter;

import java.util.Map;

public class OvenCreator implements ApplianceCreator {

    @Override
    public Appliance createAppliance(Map<String, String> applianceParameter) {
        Oven oven = new Oven();
        double powerConsumption = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.POWER_CONSUMPTION.getParameterName()));
        double weight = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.WEIGHT.getParameterName()));
        double capacity = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.CAPACITY.getParameterName()));
        double depth = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.DEPTH.getParameterName()));
        double height = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.HEIGHT.getParameterName()));
        double width = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.WIDTH.getParameterName()));
        oven.setPowerConsumption(powerConsumption);
        oven.setWeight(weight);
        oven.setCapacity(capacity);
        oven.setDepth(depth);
        oven.setHeight(height);
        oven.setWidth(width);
        return oven;
    }
}
