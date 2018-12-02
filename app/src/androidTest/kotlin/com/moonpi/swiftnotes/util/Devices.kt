@file:JvmName("Devices")

package com.moonpi.swiftnotes.util

import android.content.Context
import android.support.test.InstrumentationRegistry

val targetContext: Context
    get() = InstrumentationRegistry.getInstrumentation().targetContext

val context: Context
    get() = InstrumentationRegistry.getInstrumentation().context
