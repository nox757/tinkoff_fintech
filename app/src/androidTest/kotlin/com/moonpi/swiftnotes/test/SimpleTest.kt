package com.moonpi.swiftnotes.test

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.moonpi.swiftnotes.MainActivity
import com.moonpi.swiftnotes.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.annotations.DisplayName
import ru.tinkoff.allure.step
import java.util.concurrent.TimeUnit


@RunWith(AndroidJUnit4::class)
@DisplayName("Первые шаги Espresso")
class SampleTest : AbstractTest() {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    @DisplayName("Тест2")
    fun testCase2() {
        step("Нажать +") {
            onView(withId(R.id.newNote)).perform(click())
            deviceScreenshot("Экран создания")
        }
        step("Заполнение заголовка  ‘Заметка 1’") {
            onView(allOf(withId(R.id.titleEdit), isDisplayed())).perform(typeText("Zametka 1"))
            onView(allOf(withId(R.id.titleEdit), isDisplayed())).check(matches(withText("Zametka 1")))
            deviceScreenshot("Заголовок")
        }
        step("Заполнение Тела ‘Тестовая запись 1’") {
            onView(withId(R.id.bodyEdit)).perform(typeText("Test note 1"))
            onView(allOf(withId(R.id.bodyEdit), isDisplayed())).check(matches(withText("Test note 1")))
            deviceScreenshot("Тело")
        }
        step("Нажать <-") {
            onView(allOf(withParent(withId(R.id.toolbarEdit)), instanceOf(android.widget.ImageButton::class.java))).perform(click())
            onView(allOf(withId(android.R.id.message), isDisplayed())).check(matches(withText("Save changes?")))
            deviceScreenshot("Нажать стрелку вернуться")
        }
        step("Нажать YES") {
            onView(withId(android.R.id.button1)).perform(click())
            onView(allOf(withId(R.id.titleView), withText("Zametka 1") )).check(matches(isDisplayed()))
            deviceScreenshot("Нажать стрелку вернуться")
        }
        TimeUnit.SECONDS.sleep(5)
    }

}
