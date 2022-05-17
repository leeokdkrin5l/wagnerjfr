/*
 * Copyright 2013-2019 Xia Jun(3979434@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ***************************************************************************************
 *                                                                                     *
 *                        Website : http://www.farsunset.com                           *
 *                                                                                     *
 ***************************************************************************************
 */
package com.farsunset.cim.sdk.android.model;


import java.io.Serializable;

/**
 * 服务端心跳请求
 */
public class Ping implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String TAG = "PING";

    private static final Ping object = new Ping();

    private Ping() {
    }

    public static Ping getInstance() {
        return object;
    }

    @Override
    public String toString() {
        return TAG;
    }

}
