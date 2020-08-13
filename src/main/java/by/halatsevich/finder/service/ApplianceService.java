package by.halatsevich.finder.service;

import by.halatsevich.finder.entity.Appliance;
import by.halatsevich.finder.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface ApplianceService {
    List<Appliance> selectAllAppliances() throws ServiceException;

    Appliance findAppliance(Map<String, String> applianceParameter)throws ServiceException;

    List<Appliance> findAppliancesByTag(Map<String, String> applianceParameter)throws ServiceException;
}
