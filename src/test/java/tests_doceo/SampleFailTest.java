package tests_doceo;

import org.testng.Assert;
import org.testng.annotations.Test;

import concito.Doceodirect;

public class SampleFailTest extends Doceodirect {

    @Test
    public void failTestOne() {
        // Intentionally wrong title
        String title = getDriver().getTitle();
        Assert.assertEquals(title, "Wrong Title");
    }

    @Test
    public void failTestTwo() {
        // Intentionally failing assertion
        Assert.assertTrue(false, "Force failure for screenshot");
    }
}