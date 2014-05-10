package org.cen.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Case for {@link ReflectionUtils}
 */
public class ReflectionUtilsTest {

    @Test
    public void should_return_SelfClass() {
        String callerDepth0 = ReflectionUtils.getCallerClassName(0);

        Assert.assertEquals(ReflectionUtilsTest.class.getName(), callerDepth0);
    }

    private static class Class1 {

        private static String intermediateMethod1() {
            String result = Class2.intermediateMethod2();
            return result;
        }
    }

    private static class Class2 {

        private static String intermediateMethod2() {
            // JUnit causes offset when calling test
            String result = ReflectionUtils.getCallerClassName(4);
            return result;
        }
    }

    private static class Class3 {

        private static String intermediateMethod3() {
            String result = Class4.intermediateMethod4();
            return result;
        }
    }

    private static class Class4 {

        private static String intermediateMethod4() {
            // JUnit causes offset when calling test
            String result = ReflectionUtils.getCallerClassName(2);
            return result;
        }
    }

    @Test
    public void should_return_Caller1() {
        String callerDepth = Class1.intermediateMethod1();

        Assert.assertEquals(ReflectionUtilsTest.class.getName(), callerDepth);
    }

    @Test
    public void should_return_Caller2() {
        String callerDepth = Class3.intermediateMethod3();

        Assert.assertEquals(ReflectionUtilsTest.Class3.class.getName(), callerDepth);
    }
}
