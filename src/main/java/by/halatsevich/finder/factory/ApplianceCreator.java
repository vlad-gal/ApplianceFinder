package by.halatsevich.finder.factory;

import by.halatsevich.finder.entity.Appliance;

import java.util.Map;

public interface ApplianceCreator {
    Appliance createAppliance(Map<String, String> applianceParameter);
}
