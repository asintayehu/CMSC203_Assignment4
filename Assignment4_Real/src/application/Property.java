package application;

public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private int x;
	private int y;
	private int width;
	private int depth;
	private Plot plot;
	
	Property(){
		this.propertyName = "";
		this.city = "";
		this.owner = "";
		this.plot = new Plot();
	}
	
	Property(String propertyName, String city, double rentAmount, String owner){
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();		
	}
	
	Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth){
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
		this.plot = new Plot(x, y, width, depth);
	}
	
	Property(Property otherProperty){
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.rentAmount =otherProperty. rentAmount;
		this.owner = otherProperty.owner;		
		this.plot = new Plot(otherProperty.getPlot());
//		this.x = otherProperty.x;
//		this.y = otherProperty.y;
//		this.width = otherProperty.width;
//		this.depth = otherProperty.depth;
}
	
	public String getCity() {
		return this.city;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public Plot getPlot() {
		return this.plot;
	}
	
	public String getPropertyName() {
		return this.propertyName;
	}
	
	public double getRentAmount() {
		return this.rentAmount;
	}
	
	public String toString() {
		return this.getPropertyName() + "," + this.getCity() + "," + this.getOwner() + "," + this.getRentAmount();
	}

}
