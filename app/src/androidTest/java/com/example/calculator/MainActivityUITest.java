package com.example.calculator;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setup() throws InterruptedException {
        Thread.sleep(1500);    // wait for UI to fully load
    }

    @Test
    public void initialDisplay_isZero() {
        onView(withId(R.id.txtDisplay))
                .check(matches(withText("0")));
    }

    @Test
    public void typingDigits_buildsNumber() {
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btn3)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("123")));
    }

    @Test
    public void additionOperation_2plus3_shows5() {
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.btn3)).perform(click());
        onView(withId(R.id.btnEq)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("5")));
    }

    @Test
    public void clearButton_resetsDisplay() throws InterruptedException {
        Thread.sleep(500);
        onView(withId(R.id.btn7)).perform(click());
        onView(withId(R.id.btn8)).perform(click());
        onView(withId(R.id.btnClear)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("0")));
    }

    @Test
    public void divisionByZero_showsError() throws InterruptedException {
        Thread.sleep(500);
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btnDiv)).perform(click());
        onView(withId(R.id.btn0)).perform(click());
        onView(withId(R.id.btnEq)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("Error")));
    }

    @Test
    public void sqrtOfNine_showsThree() {
        onView(withId(R.id.btn9)).perform(click());
        onView(withId(R.id.btnSqrt)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("3")));
    }

    @Test
    public void memoryAdd_andRecall_works() throws InterruptedException {
        Thread.sleep(500);
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btnMPlus)).perform(click());
        onView(withId(R.id.btnClear)).perform(click());
        onView(withId(R.id.btnMR)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("5")));
    }
}
