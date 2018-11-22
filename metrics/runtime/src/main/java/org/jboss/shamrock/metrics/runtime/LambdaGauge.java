/*
 * Copyright 2018 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.shamrock.metrics.runtime;

import java.util.concurrent.Callable;

import org.eclipse.microprofile.metrics.Gauge;

/**
 * Created by bob on 7/31/18.
 */
public class LambdaGauge implements Gauge {

    public LambdaGauge(Callable<Number> callable) {
        this.callable = callable;
    }

    @Override
    public Number getValue() {
        try {
            return this.callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private final Callable<Number> callable;
}
