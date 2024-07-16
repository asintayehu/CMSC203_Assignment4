package application;

public class Plot {
	int x;
	int y;
	int width;
	int depth;
	
	Plot(){
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	
	Plot(int x, int y, int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	Plot(Plot otherPlot){
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	
	public boolean encompasses(Plot plot) {
	    int[] thisBtmLeft = {this.x, this.y};
	    int[] thisBtmRight = {this.x + this.width, this.y};
	    int[] thisTopLeft = {this.x, this.y + this.depth};
	    int[] thisTopRight = {this.x + this.width, this.y + this.depth};

	    int[] otherBtmLeft = {plot.getX(), plot.getY()};
	    int[] otherBtmRight = {plot.getX() + plot.getWidth(), plot.getY()};
	    int[] otherTopLeft = {plot.getX(), plot.getY() + plot.getDepth()};
	    int[] otherTopRight = {plot.getX() + plot.getWidth(), plot.getY() + plot.getDepth()};

	    boolean bottomLeftInside = thisBtmLeft[0] >= otherBtmLeft[0] && thisBtmLeft[1] >= otherBtmLeft[1];
	    boolean bottomRightInside = thisBtmRight[0] <= otherBtmRight[0] && thisBtmRight[1] >= otherBtmRight[1];
	    boolean topLeftInside = thisTopLeft[0] >= otherTopLeft[0] && thisTopLeft[1] <= otherTopLeft[1];
	    boolean topRightInside = thisTopRight[0] <= otherTopRight[0] && thisTopRight[1] <= otherTopRight[1];

	    return bottomLeftInside && bottomRightInside && topLeftInside && topRightInside;
	}

	
	
	public int getDepth() {
		return this.depth;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	
	public boolean overlaps(Plot plot) {
		int thisLeft = this.x;
		int thisRight = this.x + this.width;
		int thisBottom = this.y;
		int thisTop = this.y + this.depth;
		
		int otherLeft = plot.getX();
		int otherRight = plot.getX() + plot.getWidth();
		int otherBottom = plot.getY();
		int otherTop = plot.getY() + plot.getDepth();
		
        return (thisRight > otherLeft) && (thisLeft < otherRight) && 
        		(thisBottom < otherTop) && (thisTop > otherBottom);

	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return this.x + "," + this.y + "," + this.width + "," + this.depth;
	}
	
}
