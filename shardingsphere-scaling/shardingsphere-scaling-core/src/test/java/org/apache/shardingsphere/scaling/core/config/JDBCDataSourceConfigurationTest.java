/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.scaling.core.config;

import org.apache.shardingsphere.infra.database.type.dialect.MySQLDatabaseType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public final class JDBCDataSourceConfigurationTest {
    
    @Test
    public void assertJDBCDataSourceConfigurationEquals() {
        JDBCScalingDataSourceConfiguration sourceConfig = new JDBCScalingDataSourceConfiguration("jdbc:mysql://127.0.0.1:3306/test2?serverTimezone=UTC&useSSL=false", "root", "root");
        JDBCScalingDataSourceConfiguration targetConfig = new JDBCScalingDataSourceConfiguration("jdbc:mysql://127.0.0.1:3306/test2?serverTimezone=UTC&useSSL=false", "root", "root");
        assertThat(sourceConfig, is(targetConfig));
        sourceConfig.setDatabaseType(new MySQLDatabaseType());
        targetConfig.setDatabaseType(new MySQLDatabaseType());
        assertThat(sourceConfig, is(targetConfig));
    }
    
    @Test
    public void assertJDBCDataSourceConfigurationNotEquals() {
        JDBCScalingDataSourceConfiguration sourceConfig = new JDBCScalingDataSourceConfiguration("jdbc:mysql://127.0.0.1:3306/test2?serverTimezone=UTC&useSSL=false", "sa", "root");
        JDBCScalingDataSourceConfiguration targetConfig = new JDBCScalingDataSourceConfiguration("jdbc:mysql://127.0.0.1:3306/test2?serverTimezone=UTC&useSSL=false", "root", "root");
        assertThat(sourceConfig, not(targetConfig));
    }
}
