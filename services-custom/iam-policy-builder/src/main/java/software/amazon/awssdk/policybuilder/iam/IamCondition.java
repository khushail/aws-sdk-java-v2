/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.policybuilder.iam;

import software.amazon.awssdk.policybuilder.iam.internal.DefaultIamCondition;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

public interface IamCondition extends ToCopyableBuilder<IamCondition.Builder, IamCondition> {
    static Builder builder() {
        return new DefaultIamCondition.Builder();
    }

    static IamCondition create(IamConditionOperator operator, IamConditionKey key, String value) {
        return builder().operator(operator).key(key).value(value).build();
    }

    static IamCondition create(String operator, String key, String value) {
        return builder().operator(operator).key(key).value(value).build();
    }

    IamConditionOperator operator();
    IamConditionKey key();
    String value();

    interface Builder extends CopyableBuilder<Builder, IamCondition> {
        Builder operator(IamConditionOperator operator);
        Builder operator(String operator);
        Builder key(IamConditionKey key);
        Builder key(String key);
        Builder value(String value);
    }
}
