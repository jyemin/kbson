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

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class BsonStringTest {

    private val bsonValue = BsonString("string")

    @Test
    fun shouldHaveTheExpectedBsonType() {
        assertTrue { bsonValue.isString() }
        assertEquals(BsonType.STRING, bsonValue.bsonType)
    }

    @Test
    fun shouldHaveAccessToTheUnderlyingValues() {
        assertEquals("string", bsonValue.value)
    }

    @Test
    fun shouldOverrideEquals() {
        assertEquals(bsonValue, BsonString("string"))
        assertNotEquals(bsonValue, BsonString("STRING"))
    }

    @Test
    fun shouldBeComparable() {
        assertEquals(-1, BsonString("").compareTo(BsonString("a")))
        assertEquals(0, BsonString("a").compareTo(BsonString("a")))
        assertEquals(1, BsonString("aa").compareTo(BsonString("a")))
    }
}
