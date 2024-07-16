package application;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PropertyTestStudent {

    private Property testProperty;

    @Before
    public void setUp() {
        testProperty = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson", 2, 5, 2, 2);
    }

    @Test
    public void testPropertyConstructorWithPlot() {
        assertEquals("Sunsational", testProperty.getPropertyName());
        assertEquals("Beckman", testProperty.getCity());
        assertEquals(2613.0, testProperty.getRentAmount(), 0.0);
        assertEquals("BillyBob Wilson", testProperty.getOwner());
        assertEquals(2, testProperty.getPlot().getX());
        assertEquals(5, testProperty.getPlot().getY());
        assertEquals(2, testProperty.getPlot().getWidth());
        assertEquals(2, testProperty.getPlot().getDepth());
    }

    @Test
    public void testPropertyCopyConstructor() {
        Property copiedProperty = new Property(testProperty);
        assertEquals("Sunsational", copiedProperty.getPropertyName());
        assertEquals("Beckman", copiedProperty.getCity());
        assertEquals(2613.0, copiedProperty.getRentAmount(), 0.0);
        assertEquals("BillyBob Wilson", copiedProperty.getOwner());
        assertEquals(2, copiedProperty.getPlot().getX());
        assertEquals(5, copiedProperty.getPlot().getY());
        assertEquals(2, copiedProperty.getPlot().getWidth());
        assertEquals(2, copiedProperty.getPlot().getDepth());
    }

    @Test
    public void testToString() {
        String expectedString = "Sunsational,Beckman,BillyBob Wilson,2613.0";
        assertEquals(expectedString, testProperty.toString());
    }
}

