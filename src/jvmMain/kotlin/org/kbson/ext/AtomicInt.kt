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
package org.kbson.ext

import java.util.concurrent.atomic.AtomicInteger

/** A Jvm wrapper of atomic integer */
actual class AtomicInt actual constructor(value: Int) {

    val atomicInt: AtomicInteger

    init {
        atomicInt = AtomicInteger(value)
    }

    /** Gets the current value */
    actual fun getValue(): Int = atomicInt.get()

    /**
     * Increments the value by [delta] and returns the new value.
     *
     * @param delta the value to add
     * @return the new value
     */
    actual fun addAndGet(delta: Int): Int = atomicInt.addAndGet(delta)

    /**
     * Compares value with [expected] and replaces it with [new] value if values matches.
     *
     * @param expected the expected value
     * @param new the new value
     * @return true if successful
     */
    actual fun compareAndSet(expected: Int, new: Int): Boolean =
        atomicInt.compareAndSet(expected, new)

    /** Increments value by one. */
    actual fun increment() {
        atomicInt.incrementAndGet()
    }

    /** Decrements value by one. */
    actual fun decrement() {
        atomicInt.decrementAndGet()
    }
}
