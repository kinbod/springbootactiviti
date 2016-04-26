/**
 * Copyright (c) 2005-2012 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.easeu.modules.test.data;

/**
 * 基于DBUnit初始化数据到数据库的工具类.
 */
public class DataFixtures {

    /*private static Logger logger = LoggerFactory.getLogger(DataFixtures.class);
    private static ResourceLoader resourceLoader = new DefaultResourceLoader();

    *//**
     * 先删除数据库中所有表的数据, 再插入XML文件中的数据到数据库.
     *
     * @param xmlFilePaths 符合Spring Resource路径格式的文件路径列表.
     *//*
    public static void reloadData(DataSource dataSource, String... xmlFilePaths) throws Exception {
        execute(DatabaseOperation.CLEAN_INSERT, dataSource, xmlFilePaths);
    }

    *//**
     * 插入XML文件中的数据到数据库.
     *
     * @param xmlFilePaths 符合Spring Resource路径格式的文件路径列表.
     *//*
    public static void loadData(DataSource dataSource, String... xmlFilePaths) throws Exception {
        execute(DatabaseOperation.INSERT, dataSource, xmlFilePaths);
    }

    *//**
     * 在数据库中删除XML文件中涉及的表的数据.
     *
     * @param xmlFilePaths 符合Spring Resource路径格式的文件路径列表.
     *//*
    public static void deleteData(DataSource dataSource, String... xmlFilePaths) throws Exception {
        execute(DatabaseOperation.DELETE_ALL, dataSource, xmlFilePaths);
    }

    *//**
     * 对XML文件中的数据在数据库中执行Operation.
     *
     * @param xmlFilePaths 符合Spring Resource路径格式的文件列表.
     *//*
    private static void execute(DatabaseOperation operation, DataSource dataSource, String... xmlFilePaths)
            throws DatabaseUnitException, SQLException {
        IDatabaseConnection connection = getConnection(dataSource);
        try {
            for (String xmlPath : xmlFilePaths) {
                try {
                    InputStream input = resourceLoader.getResource(xmlPath).getInputStream();
                    IDataSet dataSet = new FlatXmlDataSetBuilder().setColumnSensing(true).build(input);
                    operation.execute(connection, dataSet);
                } catch (IOException e) {
                    logger.warn(xmlPath + " file not found", e);
                }
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    *//**
     * 从DataSource中取得新的Connection(不会参与原有事务)，并根据url转换为相应数据库的Connection.
     *//*
    protected static IDatabaseConnection getConnection(DataSource dataSource) throws DatabaseUnitException,
            SQLException {
        Connection connection = dataSource.getConnection();
        String jdbcUrl = connection.getMetaData().getURL();
        if (StringUtils.contains(jdbcUrl, ":h2:")) {
            return new H2Connection(connection, null);
        } else if (StringUtils.contains(jdbcUrl, ":mysql:")) {
            return new MySqlConnection(connection, null);
        } else if (StringUtils.contains(jdbcUrl, ":oracle:")) {
            return new OracleConnection(connection, null);
        } else {
            return new DatabaseConnection(connection);
        }
    }*/
}
