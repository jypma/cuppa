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

import static org.forgerock.cuppa.model.Behaviour.only;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.forgerock.cuppa.model.TestBlock;

/**
 * Filters out all tests that are not marked as "only" if any test is marked as "only". Otherwise, does nothing.
 */
public final class OnlyTestBlockFilter implements Function<TestBlock, TestBlock> {
    @Override
    public TestBlock apply(TestBlock rootBlock) {
        boolean hasOnlyTests = hasOnlyTests(rootBlock);
        if (!hasOnlyTests) {
            return rootBlock;
        }
        return pruneNotOnlyTests(rootBlock);
    }

    private TestBlock pruneNotOnlyTests(TestBlock testBlock) {
        if (testBlock.behaviour == only) {
            return testBlock;
        }
        List<TestBlock> testBlocks = testBlock.testBlocks.stream()
                .map(this::pruneNotOnlyTests)
                .collect(Collectors.toList());
        List<org.forgerock.cuppa.model.Test> tests = testBlock.tests.stream()
                .filter(t -> t.behaviour == only)
                .collect(Collectors.toList());
        return new TestBlock(testBlock.behaviour, testBlock.description, testBlocks, testBlock.beforeHooks,
                testBlock.afterHooks, testBlock.beforeEachHooks, testBlock.afterEachHooks, tests, testBlock.tags);
    }

    private boolean hasOnlyTests(TestBlock block) {
        return block.behaviour == only
                || block.tests.stream().anyMatch(t -> t.behaviour == only)
                || block.testBlocks.stream().anyMatch(this::hasOnlyTests);
    }
}
