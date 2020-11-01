package se.tink.hello;

import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void testAdd() {
        Assert.assertEquals(10, HelloWorld.add(3, 7));
    }

}
