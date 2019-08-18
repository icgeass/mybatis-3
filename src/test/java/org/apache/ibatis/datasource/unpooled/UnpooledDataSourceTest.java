/**
 * Copyright 2009-2015 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.datasource.unpooled;

import static org.junit.Assert.*;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.*;
import java.util.Enumeration;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;

import javax.sql.DataSource;

public class UnpooledDataSourceTest {

    @Test
    public void shouldNotRegisterTheSameDriverMultipleTimes() throws Exception {
        // https://code.google.com/p/mybatis/issues/detail?id=430
        UnpooledDataSource dataSource = null;
        dataSource = new UnpooledDataSource("org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:multipledrivers", "sa", "");
        dataSource.getConnection();
        int before = countRegisteredDrivers();
        dataSource = new UnpooledDataSource("org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:multipledrivers", "sa", "");
        dataSource.getConnection();
        assertEquals(before, countRegisteredDrivers());
    }

    @Ignore("Requires MySQL server and a driver.")
    @Test
    public void shouldRegisterDynamicallyLoadedDriver() throws Exception {
        int before = countRegisteredDrivers();
        ClassLoader driverClassLoader = null;
        UnpooledDataSource dataSource = null;
        driverClassLoader = new URLClassLoader(new URL[]{new URL("jar:file:/PATH_TO/mysql-connector-java-5.1.25.jar!/")});
        dataSource = new UnpooledDataSource(driverClassLoader, "com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/test", "root", "");
        dataSource.getConnection();
        assertEquals(before + 1, countRegisteredDrivers());
        driverClassLoader = new URLClassLoader(new URL[]{new URL("jar:file:/PATH_TO/mysql-connector-java-5.1.25.jar!/")});
        dataSource = new UnpooledDataSource(driverClassLoader, "com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/test", "root", "");
        dataSource.getConnection();
        assertEquals(before + 1, countRegisteredDrivers());
    }


    @Test
    public void getDataFromUnpooled() throws Exception {
        UnpooledDataSourceFactory unpooledDataSourceFactory = new UnpooledDataSourceFactory();
        Properties properties = new Properties();
        properties.put("username", "root");
        properties.put("password", "123456");
        properties.put("url", "jdbc:MySql://127.0.0.1:3306/fund?characterEncoding=UTF-8");
        properties.put("driver", "com.mysql.jdbc.Driver");
        unpooledDataSourceFactory.setProperties(properties);

        DataSource ds = unpooledDataSourceFactory.getDataSource();
        Connection conn = ds.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("select * from fund_info");
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int colNum = resultSetMetaData.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= colNum; i++) {
                System.out.print(resultSet.getObject(i) + "\t");
            }
            System.out.println();
        }
    }

    protected int countRegisteredDrivers() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        int count = 0;
        while (drivers.hasMoreElements()) {
            drivers.nextElement();
            count++;
        }
        return count;
    }

}
