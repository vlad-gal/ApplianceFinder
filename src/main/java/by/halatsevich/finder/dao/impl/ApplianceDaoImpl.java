package by.halatsevich.finder.dao.impl;

import by.halatsevich.finder.dao.ApplianceDao;
import by.halatsevich.finder.exception.DaoException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ApplianceDaoImpl implements ApplianceDao {
    private static ApplianceDaoImpl instance;
    private static final String DEFAULT_PATH = "resources/data/input.txt";
    private static final String REGEX_FIND = "\\b%s=%s[,\\s]?\\b";

    private ApplianceDaoImpl() {
    }

    public static ApplianceDaoImpl getInstance() {
        if (instance == null) {
            return new ApplianceDaoImpl();
        }
        return instance;
    }

    @Override
    public List<String> selectAll() throws DaoException {
        Path path = Paths.get(DEFAULT_PATH);
        List<String> appliances;
        try {
            appliances = Files.lines(path)
                    .filter(app -> !app.isEmpty())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new DaoException("Error while opening file", e);
        }
        return appliances;
    }

    @Override
    public String findAppliance(String applianceName, String parameterName, String parameterValue) throws DaoException {
        Path path = Paths.get(DEFAULT_PATH);
        List<String> appliances;
        String request = String.format(REGEX_FIND, parameterName.toUpperCase(), parameterValue.toUpperCase());
        try {
            appliances = Files.lines(path)
                    .filter(app -> app.toUpperCase().contains(applianceName.toUpperCase()))
                    .filter(filterRequest(request))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new DaoException("Error while opening file", e);
        }
        if (appliances.isEmpty()) {
            throw new DaoException("Appliance not found");
        }
        String appliance = appliances.get(0);
        return appliance;
    }

    @Override
    public List<String> findByTag(String parameterName, String parameterValue) throws DaoException {
        Path path = Paths.get(DEFAULT_PATH);
        List<String> appliances;
        String request = String.format(REGEX_FIND, parameterName.toUpperCase(), parameterValue.toUpperCase());
        try {
            appliances = Files.lines(path)
                    .filter(filterRequest(request))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new DaoException("Error while opening file", e);
        }
        return appliances;
    }

    private Predicate<String> filterRequest(String request) {
        return app -> {
            Pattern pattern = Pattern.compile(request);
            Matcher matcher = pattern.matcher(app.toUpperCase());
            boolean flag = false;
            while (matcher.find()) {
                flag = true;
            }
            return flag;
        };
    }
}

