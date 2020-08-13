package by.halatsevich.finder.dao;

import by.halatsevich.finder.exception.DaoException;

import java.util.List;

public interface ApplianceDao {
    List<String> selectAll() throws DaoException;

    String findAppliance(String applianceName, String parameterName, String parameterValue) throws DaoException;

    List<String> findByTag(String parameterName, String parameterValue) throws DaoException;
}
