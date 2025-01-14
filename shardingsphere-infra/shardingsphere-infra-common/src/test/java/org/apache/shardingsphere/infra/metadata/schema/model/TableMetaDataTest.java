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

package org.apache.shardingsphere.infra.metadata.schema.model;

import org.junit.Before;
import org.junit.Test;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public final class TableMetaDataTest {
    
    private TableMetaData tableMetaData;
    
    @Before
    public void setUp() {
        tableMetaData = new TableMetaData(null, Collections.singletonList(new ColumnMetaData("test", Types.INTEGER, true, false, true)), Collections.emptyList());
    }
    
    @Test
    public void assertGetColumnMetaData() {
        ColumnMetaData actual = tableMetaData.getColumns().get(new ArrayList<>(tableMetaData.getColumns().keySet()).get(0));
        assertThat(actual.getName(), is("test"));
        assertThat(actual.getDataType(), is(Types.INTEGER));
        assertTrue(actual.isPrimaryKey());
        assertFalse(actual.isGenerated());
        assertTrue(actual.isCaseSensitive());
    }
    
    @Test
    public void assertEmptyColumnsWithDefaultConstructor() {
        tableMetaData = new TableMetaData();
        assertThat(tableMetaData.getColumns(), is(Collections.emptyMap()));
    }
}
