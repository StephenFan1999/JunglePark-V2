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
 * Adds a Button to JunglePark that can add an animal type to JunglePark when
 * clicked. AddAnimalButton's superclass is Button.
 * 
 * @author Mouna Kacem, Stephen Fan
 *
 */
public class AddAnimalButton extends Button {
	// type of the animal to add
	private String type;
	 
	/**
	 * Constructor for the AddAnimalButton class
	 * @param type is the type of animal to add
	 * @param x is the x-coordinate of the Button
	 * @param y is the y-coordinate of the Button
	 * @param park is the JunglePark PApplet that the button is being added to
	 */
	public AddAnimalButton(String type, float x, float y, JunglePark park) {
		// calls its superclass' constructor (superclass is Button)
	    super(x, y, park);
	    
	    // set type and label
	    this.type = type.toLowerCase();
	    this.label = "Add " + type;
	}
	 
	/**
	 * Overrides the superclass Button's mousePressed method
	 * If AddAnimalButton is pressed and the Button is of type Tiger, it adds a new
	 * Tiger to JunglePark. If AddAnimalButton is pressed and it is of type
	 * Deer, it adds a Deer to JunglePark.
	 */
	@Override
	public void mousePressed() {
	  //checks if the mouse is over the Button
	  if (isMouseOver()) {
		//checks the type of the Button
	    switch (type) {
	      case "tiger":
	        //TODO create a new Tiger and add it to the JunglePark
			Tiger tiger = new Tiger(super.processing);
			super.processing.listGUI.add(tiger);
	        break;
	      case "deer":
	        //TODO create a new Deer and add it to the JunglePark
			Deer deer = new Deer(super.processing);
			super.processing.listGUI.add(deer);
	        break;
	    }
	  }
	}
}
