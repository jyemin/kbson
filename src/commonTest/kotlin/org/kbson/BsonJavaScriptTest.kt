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

class BsonJavaScriptTest {

    private val code = "function() {}"
    private val bsonValue = BsonJavaScript(code)

    @Test
    fun shouldHaveTheExpectedBsonType() {
        assertTrue { bsonValue.isJavaScript() }
        assertEquals(BsonType.JAVASCRIPT, bsonValue.getBsonType())
    }

    @Test
    fun shouldHaveAccessToTheUnderlyingValues() {
        assertEquals(code, bsonValue.code)
    }

    @Test
    fun shouldOverrideEquals() {
        assertEquals(bsonValue, BsonJavaScript(code))
        assertNotEquals(bsonValue, BsonJavaScript("function() { return false;}"))
    }
}
