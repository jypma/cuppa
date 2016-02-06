/*
 * Copyright 2015-2016 ForgeRock AS.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.forgerock.cuppa.internal;

import org.forgerock.cuppa.model.TestBlock;

/**
 * Internal exception used to handle hooks throwing exceptions.
 */
public final class HookException extends RuntimeException {

    private final TestBlock testBlock;

    /**
     * Creates a new hook exception.
     *
     * @param testBlock The test block that the hook is in.
     * @param cause The exception that the hook function threw.
     */
    public HookException(TestBlock testBlock, Throwable cause) {
        super(cause);
        this.testBlock = testBlock;
    }

    public TestBlock getTestBlock() {
        return testBlock;
    }
}
