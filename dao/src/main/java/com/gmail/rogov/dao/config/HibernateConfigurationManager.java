package com.gmail.rogov.dao.config;

import java.util.ResourceBundle;

public class HibernateConfigurationManager {

    private static HibernateConfigurationManager instance;

    private ResourceBundle resourceBundle;

    private static final String BUNDLE_NAME = "hibernate";

    public static final String DATABASE_DRIVER_NAME = "database.driver.name";
    public static final String DATABASE_URL = "database.url";
    public static final String DATABASE_USERNAME = "database.username";
    public static final String DATABASE_PWD = "database.password";
    public static final String HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

    public static final String LOGIN_PAGE_PATH = "login.page.path";
    public static final String USERS_PAGE_PATH = "users.page.path";
    public static final String ITEMS_PAGE_PATH = "items.page.path";
    public static final String ERRORS_PAGE_PATH = "errors.page.path";

    public static HibernateConfigurationManager getInstance() {
        if (instance == null) {
            instance = new HibernateConfigurationManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resourceBundle.getObject(key);
    }

}
