/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/

package org.apache.cayenne.remote;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.testdo.mt.ClientMtTable1;

public class NestedObjectContextParentEventsTest extends RemoteCayenneCase {

    public void testParentUpdatedId() throws Exception {
        deleteTestData();
        
        ObjectContext child = context.createChildContext();

        ClientMtTable1 ac = child.newObject(ClientMtTable1.class);
        ac.setGlobalAttribute1("X");
        child.commitChangesToParent();

        ClientMtTable1 ap = (ClientMtTable1) context.getGraphManager().getNode(ac.getObjectId());
        assertNotNull(ap);

        assertTrue(ap.getObjectId().isTemporary());
        context.commitChanges();

        assertFalse(ap.getObjectId().isTemporary());
        assertEquals(ap.getObjectId(), ac.getObjectId());
    }
}
