/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.quarkiverse.sqlite4j.it;

import java.sql.*;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import io.agroal.api.AgroalDataSource;

/**
 * Basic integration test for quarkus-sqlite4j
 *
 */

@SuppressWarnings("unused")
@Path("/Sqlite4j")
@ApplicationScoped
public class JDBCSqliteResource {
    // add some rest methods here
    @Inject
    AgroalDataSource ds;

    @GET
    @Path("Agoral")
    public String testAgoral() throws SQLException {
        String result;
        try (Connection connection = ds.getConnection()) {
            result = test(connection);
        }
        return result;
    }

    @GET
    @Path("Connection")
    public String connection() throws SQLException {
        String result;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:")) {
            result = test(connection);
        }
        return result;
    }

    private String test(Connection connection) throws SQLException {
        StringBuilder result = new StringBuilder();
        try (Statement statement = connection.createStatement()) {
            statement.setQueryTimeout(30); // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists xperson");
            statement.executeUpdate("create table xperson (id integer, name string)");
            statement.executeUpdate("insert into xperson values(1, 'leo')");
            statement.executeUpdate("insert into xperson values(2, 'yui')");
            try (ResultSet rs = statement.executeQuery("select * from xperson")) {
                while (rs.next()) {
                    result.append(rs.getInt("id")).append("/").append(rs.getString("name")).append("/");
                }
            }
        }
        return result.toString();
    }
}
