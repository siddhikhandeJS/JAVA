package com.code;

public class Points2D {
	private int x;
	private int y;

	// parameterized constructor to init x & y co-ords.
	public Points2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// method to return string form of point's x & y co-ords
	public String toString() {
		return "X Co-ord = " + x + " Y Co-ord = " + y;
	}

	/*
	 * Add isEqual method to Point2D class :a boolean returning method : must return
	 * true if both points are having same x,y co-ords or false otherwise. eg :
	 * public boolean isEqual(Point2D anotherPoint) { ....... } eg : p1.isEqual(p2)
	 */

	public boolean isEqual(Points2D Pt2) {
		if (this.x == Pt2.x && this.y == Pt2.y) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 5.5 Add calculateDistance method to calculate distance between current point
	 * and specified point & return the distance to the caller. Hint : Use distance
	 * formula . Use java.lang.Math class methods --sqrt, pow etc. eg : public
	 * double calculateDistance(Point2D anotherPoint) { Math.sqrt(.....); }
	 */
	
	public double calculateDistance(Points2D Pt2) {
		return Math.sqrt((this.x-Pt2.x)*(this.x-Pt2.x)+(this.y-Pt2.y)*(this.x-Pt2.y));
	}

}
