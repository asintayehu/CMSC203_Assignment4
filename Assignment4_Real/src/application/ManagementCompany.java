package application;

public class ManagementCompany{
	// constant class variables
	static final int MAX_PROPERTY = 5;
	static final int MGMT_DEPTH = 10;
	static final int MGMT_WIDTH = 10;
	
	// instance variables
	private String name;
	private String taxID;
	private double mgmFeePer;
	
	// properties array
	Property[] properties;
	
	private Plot plot;
	private int numberOfProperties;
	
	// no arg constructor
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		this.numberOfProperties = 0;
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this(name, taxID, mgmFee);
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
		this.numberOfProperties = 0;
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFeePer, 
                otherCompany.plot.getX(), otherCompany.plot.getY(), 
                otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
	
        // copying properties array
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = otherCompany.numberOfProperties;
        
        for(int i = 0; i < otherCompany.numberOfProperties; i++) {
        	this.properties[i] = new Property(otherCompany.properties[i]);
        }
        
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		return addProperty(new Property(name, city, rent, owner));
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}
	
	public int addProperty(Property property) {
		if(this.properties.length >= MAX_PROPERTY) { return -1; }
		
		if (property == null) { return -2; }
		
		if(!(this.plot.encompasses(property.getPlot()))) {return -3; }
		
		for(int i = 0; i < this.numberOfProperties; i++) {
			if(property.getPlot().overlaps(this.properties[i].getPlot())) {
				return -4;
			}
		}
		
	    this.properties[this.numberOfProperties] = new Property(property);
	    this.numberOfProperties++;
	    return this.numberOfProperties - 1; 
		
	}
	
	public void removeLastProperty() {
		
		if(this.numberOfProperties > 0) {
		this.properties[numberOfProperties - 1] = null;
		numberOfProperties -= 1;
		}
	}
	
	public boolean isPropertiesFull() {
		if(this.numberOfProperties == MAX_PROPERTY) {
			return true;
		}
		return false;
	}
	
	public int getPropertiesCount() {
		return this.numberOfProperties;
	}
	
	public double getTotalRent() {
		double total = 0.0;
		for(int i = 0; i < this.numberOfProperties; i++) {
			total += this.properties[i].getRentAmount();
		}
		return total;
	}
	
	public Property getHighestRentProperty() {
	    if (this.numberOfProperties == 0) {
	        return null;
	    }

	    Property highestRentProperty = this.properties[0];
	    double maxRent = highestRentProperty.getRentAmount();

	    for (int i = 1; i < this.numberOfProperties; i++) {
	        Property currentProperty = this.properties[i];
	        double currentRent = currentProperty.getRentAmount();

	        if (currentRent > maxRent) {
	            maxRent = currentRent;
	            highestRentProperty = currentProperty;
	        }
	    }

	    return highestRentProperty;
	}
	
	public boolean isMangementFeeValid() {
	    return (this.mgmFeePer * 100) >= 0 && (this.mgmFeePer * 100) <= 100;
	}
	
	
	
	// getter and setter methods
	
	public String getName() {
		return this.name;
	}
	
	public String getTaxID() {
		return this.taxID;
	}
	
	public Property[] getProperties() {
		return this.properties;
	}
	
	public double getMgmFeePer() {
		return this.mgmFeePer;
	}
	
	public Plot getPlot() {
		return this.plot;
	}
	
	public String toString() {
	    String result = "List of the properties for " + this.name + ", taxID: " + this.taxID + "\n";
	    result += "______________________________________________________\n";

	    for (int i = 0; i < this.numberOfProperties; i++) {
	        Property property = this.properties[i];
	        result += property.getPropertyName() + "," +
	                  property.getCity() + "," +
	                  property.getOwner() + "," +
	                  String.format("%.1f", property.getRentAmount()) + "\n";
	    }

	    result += "______________________________________________________\n\n";
	    result += " total management Fee: " + String.format("%.2f", this.getMgmFeePer());

	    return result;
	}
	
	
	
	
	
}
