package application;

import static org.junit.Assert.*;
import org.junit.*;


public class ManagementCompanyTestStudent {

    private ManagementCompany managementCompany;

    @Before
    public void setUp() throws Exception {
        managementCompany = new ManagementCompany("ExampleCo", "123456789", 6.5, 1, 1, 10, 10);
    }

    @After
    public void tearDown() throws Exception {
        managementCompany = null;
    }

    @Test
    public void testNoArgConstructor() {
        ManagementCompany mc = new ManagementCompany();
        assertNotNull("Default constructor should initialize ManagementCompany object", mc);
        assertNotNull("Default plot should not be null", mc.getPlot());
        assertEquals("Default number of properties should be 0", 0, mc.getPropertiesCount());
    }

    @Test
    public void testParametrizedConstructor() {
        assertEquals("Constructor should set name correctly", "ExampleCo", managementCompany.getName());
    }

    @Test
    public void testCopyConstructor() {
        ManagementCompany copyCompany = new ManagementCompany(managementCompany);
        assertEquals("Copy constructor should copy name correctly", managementCompany.getName(), copyCompany.getName());
        assertEquals("Copy constructor should copy plot X-coordinate correctly", managementCompany.getPlot().getX(), copyCompany.getPlot().getX());    }
    
}
