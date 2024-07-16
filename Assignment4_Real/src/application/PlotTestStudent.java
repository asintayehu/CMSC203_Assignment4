package application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PlotTestStudent {

    private Plot testPlot;

    @Before
    public void setUp() {
        testPlot = new Plot(1, 2, 5, 5);
    }

    @Test
    public void testPlotConstructor() {
        assertEquals(1, testPlot.getX());
        assertEquals(2, testPlot.getY());
        assertEquals(5, testPlot.getWidth());
        assertEquals(5, testPlot.getDepth());
    }

    @Test
    public void testPlotCopyConstructor() {
        Plot copiedPlot = new Plot(testPlot);
        assertEquals(1, copiedPlot.getX());
        assertEquals(2, copiedPlot.getY());
        assertEquals(5, copiedPlot.getWidth());
        assertEquals(5, copiedPlot.getDepth());
    }

    @Test
    public void testEncompasses() {
        Plot innerPlot = new Plot(2, 3, 3, 3);
        Plot outerPlot = new Plot(0, 1, 10, 10);

        assertFalse(outerPlot.encompasses(innerPlot));
        assertTrue(innerPlot.encompasses(outerPlot));
    }

    @Test
    public void testOverlaps() {
        Plot overlappingPlot = new Plot(3, 4, 3, 3);
        Plot nonOverlappingPlot = new Plot(10, 10, 5, 5);

        assertTrue(testPlot.overlaps(overlappingPlot));
        assertFalse(testPlot.overlaps(nonOverlappingPlot));
    }

    @Test
    public void testSettersAndGetters() {
        testPlot.setX(10);
        testPlot.setY(20);
        testPlot.setWidth(15);
        testPlot.setDepth(15);

        assertEquals(10, testPlot.getX());
        assertEquals(20, testPlot.getY());
        assertEquals(15, testPlot.getWidth());
        assertEquals(15, testPlot.getDepth());
    }

    @Test
    public void testToString() {
        String expectedString = "1,2,5,5";
        assertEquals(expectedString, testPlot.toString());
    }
}
