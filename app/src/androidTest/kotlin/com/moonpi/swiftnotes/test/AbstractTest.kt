package com.moonpi.swiftnotes.test

import android.os.Environment
import com.moonpi.swiftnotes.util.context
import com.moonpi.swiftnotes.util.targetContext
import org.junit.Before
import java.io.File


open class AbstractTest {

    val allurePath = File(Environment.getExternalStorageDirectory().absolutePath + "/allure-results")

    @Before
    fun clearAllureData() {
        if (allurePath.exists()) {
            allurePath.deleteRecursively()
        }
    }

    @Before
    fun clearUserData() {
        try {
            val dir = context.cacheDir
            dir.deleteRecursively()
            val dir1 = targetContext.cacheDir
            dir1.deleteRecursively()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}