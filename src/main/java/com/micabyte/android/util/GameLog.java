/*
 * Copyright 2015 MicaByte Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.micabyte.android.util;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import org.jetbrains.annotations.NonNls;

import io.fabric.sdk.android.Fabric;

@NonNls
public final class GameLog {
    private static final boolean LOG = true; //BuildConfig.DEBUG;

    private GameLog() {
        // NOOP
    }

    public static void i(String tag, String s) {
        if (LOG) Log.i(tag, s);
    }

    public static void v(String tag, String s) {
        if (LOG) Log.v(tag, s);
    }

    public static void d(String tag, String s) {
        if (LOG) Log.d(tag, s);
    }

    public static void w(String tag, String s) {
        if (LOG) Log.w(tag, s);
        else if (Fabric.isInitialized())
            Crashlytics.log(Log.WARN, tag, s);
    }

    public static void e(String tag, String s) {
        if (LOG) Log.e(tag, s);
        else if (Fabric.isInitialized())
            GameLog.e(tag, s);
    }

    public static void logException(Exception e) {
        if (Fabric.isInitialized())
            GameLog.logException(e);
        if (LOG) //noinspection CallToPrintStackTrace
            e.printStackTrace();
    }


}
