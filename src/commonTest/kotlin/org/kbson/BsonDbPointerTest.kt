/*
 * Copyright 2008-present MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kbson

import kotlin.test.*

class BsonDbPointerTest {

    private val namespace = "namespace"
    private val id = BsonObjectId()
    private val bsonValue = BsonDbPointer(namespace, id)

    @Test
    fun shouldHaveTheExpectedBsonType() {
        assertTrue { bsonValue.isDBPointer() }
        assertEquals(BsonType.DB_POINTER, bsonValue.getBsonType())
    }

    @Test
    fun shouldHaveAccessToTheUnderlyingValues() {
        assertEquals(namespace, bsonValue.namespace)
        assertEquals(id, bsonValue.id)
    }

    @Test
    fun shouldOverrideEquals() {
        assertEquals(bsonValue, BsonDbPointer(namespace, id))
        assertNotEquals(bsonValue, BsonDbPointer("altNamespace", id))
    }
}
