/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.discovery.ec2;


import org.elasticsearch.cloud.aws.AbstractAwsTest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.plugin.cloud.aws.CloudAwsPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.test.ESIntegTestCase.ClusterScope;
import org.elasticsearch.test.ESIntegTestCase.Scope;
import org.junit.Test;

import java.util.Collection;

import static org.elasticsearch.common.settings.Settings.settingsBuilder;

/**
 * Just an empty Node Start test to check eveything if fine when
 * starting.
 * This test requires AWS to run.
 */
@ClusterScope(scope = Scope.TEST, numDataNodes = 0, numClientNodes = 0, transportClientRatio = 0.0)
public class Ec2DiscoveryITest extends AbstractAwsTest {

    @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        return pluginList(CloudAwsPlugin.class);
    }

    @Test
    public void testStart() {
        Settings nodeSettings = settingsBuilder()
                .put("cloud.enabled", true)
                .put("discovery.type", "ec2")
                .build();
        internalCluster().startNode(nodeSettings);
    }

}
