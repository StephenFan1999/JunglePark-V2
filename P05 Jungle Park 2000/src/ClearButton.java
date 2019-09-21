////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Jungle Park 2000
// Files:           Button.java, Animal.java, JunglePark.java, ParkGUI.java,
//					Tiger.java, JungleParkTests.java, Deer.java,
//                  AddAnimalButton.java, ClearButton.java
// Course:          CS300, Fall 2018
//
// Author:          Stephen Fan
// Email:           sfan54@wisc.edu
// Lecturer's Name: Alexi Brooks
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully 
//acknowledge and credit those sources of help here.  Instructors and TAs do 
//not need to be credited here, but tutors, friends, relatives, room mates, 
//strangers, and others do.  If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * The ClearButton class has superclass Button. It creates a Button that when
 * clicked, removes all animals from JunglePark.
 * 
 * @author Stephen Fan
 *
 */
public class ClearButton extends Button{
	
	/**
	 * Constructor for class ClearButton
	 * 
	 * @param x is the x-coordinate of the Button
	 * @param y is the y-coordinate of the Button
	 * @param park is the JunglePark PApplet that the Button is created in
	 */
	public ClearButton(float x, float y, JunglePark park) {
		// calls the superclass Button's constructor
	    super(x, y, park);
	    
	    // sets label of Button to "Clear Park"
	    this.label = "Clear Park";
	}
	
	/**
	 * Overrides the superclass Button's mousePressed method
	 * If the ClearButton is pressed, it removes all animals from JunglePark.
	 */
	@Override
	public void mousePressed() {
	  //checks if the mouse is over the Button
	  if (isMouseOver()) {
		//clears animals from JunglePark
        super.processing.clear();
	  }
	}
}
