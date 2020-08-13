package by.halatsevich.finder.service.impl;

import by.halatsevich.finder.dao.impl.ApplianceDaoImpl;
import by.halatsevich.finder.entity.Appliance;
import by.halatsevich.finder.exception.DaoException;
import by.halatsevich.finder.exception.ServiceException;
import by.halatsevich.finder.factory.ApplianceFactory;
import by.halatsevich.finder.parameter.ApplianceParameter;
import by.halatsevich.finder.parser.ApplianceParser;
import by.halatsevich.finder.service.ApplianceService;
import by.halatsevich.finder.validator.ApplianceValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplianceServiceImpl implements ApplianceService {
    private static ApplianceServiceImpl instance;

    private ApplianceServiceImpl() {
    }

    public static ApplianceServiceImpl getInstance() {
        if (instance == null) {
            return new ApplianceServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Appliance> selectAllAppliances() throws ServiceException {
        ApplianceDaoImpl applianceDao = ApplianceDaoImpl.getInstance();
        ApplianceFactory factory = new ApplianceFactory();
        ApplianceParser parser = new ApplianceParser();
        List<Appliance> appliances = new ArrayList<>();
        try {
            List<String> preparedAppliances = applianceDao.selectAll();
            for (String applianceData : preparedAppliances) {
                Map<String, String> parseAppliance = parser.parseAppliance(applianceData);
                Appliance appliance = factory.createAppliance(parseAppliance);
                appliances.add(appliance);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return appliances;
    }


    @Override
    public Appliance findAppliance(Map<String, String> applianceParameter) throws ServiceException {
        ApplianceDaoImpl applianceDao = ApplianceDaoImpl.getInstance();
        ApplianceValidator validator = new ApplianceValidator();
        ApplianceFactory factory = new ApplianceFactory();
        ApplianceParser parser = new ApplianceParser();
        String applianceName = applianceParameter.get(ApplianceParameter.NAME.getParameterName().toLowerCase());
        String[] parameter = defineParameter(applianceParameter);
        String parameterName = parameter[0];
        String parameterValue = parameter[1];
        if (!validator.isValidApplianceName(applianceName) || applianceName.isEmpty()) {
            throw new ServiceException("Appliance name is empty or has invalid characters");
        }
        if (!validator.isValidApplianceParameter(parameterName) || parameterName.isEmpty()) {
            throw new ServiceException("Appliance parameter name is empty or has invalid characters");
        }
        if (!validator.isValidApplianceParameterValue(parameterValue) || parameterValue.isEmpty()) {
            throw new ServiceException("Appliance parameter value is empty or has invalid symbols");
        }
        Appliance appliance;
        try {
            String applianceData = applianceDao.findAppliance(applianceName, parameterName, parameterValue);
            Map<String, String> parseAppliance = parser.parseAppliance(applianceData);
            appliance = factory.createAppliance(parseAppliance);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return appliance;
    }

    @Override
    public List<Appliance> findAppliancesByTag(Map<String, String> applianceParameter) throws ServiceException {
        ApplianceDaoImpl applianceDao = ApplianceDaoImpl.getInstance();
        ApplianceValidator validator = new ApplianceValidator();
        ApplianceFactory factory = new ApplianceFactory();
        ApplianceParser parser = new ApplianceParser();
        String[] parameter = defineParameter(applianceParameter);
        String parameterName = parameter[0];
        String parameterValue = parameter[1];
        if (!validator.isValidApplianceParameter(parameterName) || parameterName.isEmpty()) {
            throw new ServiceException("Appliance parameter name is empty or has invalid characters");
        }
        if (!validator.isValidApplianceParameterValue(parameterValue) || parameterValue.isEmpty()) {
            throw new ServiceException("Appliance parameter value is empty or has invalid symbols");
        }
        List<Appliance> appliances = new ArrayList<>();
        try {
            List<String> preparedAppliances = applianceDao.findByTag(parameterName, parameterValue);
            for (String applianceData : preparedAppliances) {
                Map<String, String> parseAppliance = parser.parseAppliance(applianceData);
                Appliance appliance = factory.createAppliance(parseAppliance);
                appliances.add(appliance);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return appliances;
    }

    private String[] defineParameter(Map<String, String> applianceParameter) {
        String[] parameter = new String[2];
        ApplianceParameter[] applianceParameters = ApplianceParameter.values();
        for (Map.Entry map : applianceParameter.entrySet()) {
            for (int i = 0; i < applianceParameters.length; i++) {
                if (applianceParameters[i].getParameterName().equalsIgnoreCase(map.getKey().toString())) {
                    parameter[0] = (String) map.getKey();
                    parameter[1] = (String) map.getValue();
                }
            }
        }
        return parameter;
    }
}
