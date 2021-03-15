package ch.paixon.exercise_testing_solution;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTests {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void addDoesAdd1OnCounterValue() {
        // Find counterValue-View and check initial state is "0"
        onView(withId(R.id.counterValue)).check(matches(withText("0")));

        // Perform a click on the "Add 1" button
        onView(withId(R.id.buttonAdd)).perform(click());

        // Find the counterValue-View and check whether the new text is "1"
        onView(withId(R.id.counterValue)).check(matches(withText("1")));
    }

    @Test
    public void subtractDoesSubtract1OnCounterValue() {
        onView(withId(R.id.counterValue)).check(matches(withText("0")));

        onView(withId(R.id.buttonSubtract)).perform(click());

        onView(withId(R.id.counterValue)).check(matches(withText("-1")));
    }

    @Test
    public void addValueTest(){
        onView(withId(R.id.counterValue)).check(matches(withText("0")));

        onView(withId(R.id.valueEditText)).perform(typeText("3"));

        onView(withId(R.id.buttonAddValue)).perform(click());

        onView(withId(R.id.counterValue)).check(matches(withText("3")));
    }
}
