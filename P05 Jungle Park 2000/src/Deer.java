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
 * This class represents a Deer in the JunglePark application
 * 
 * @author Mouna Kacem, Stephen Fan
 *
 */
public class Deer extends Animal{
  // scan range area to check for a threat in the neighborhood
  private static final int SCAN_RANGE = 175;
  
  // image file name
  private static final String IMAGE_FILE_NAME = "images/deer.png";
  
  //class variable that represents the identifier of the next deer
  // to be created
  private static int nextID = 1;
	  
  //A String that represents the deer type
  private static final String TYPE = "DR"; 
  
  //Deer's id: positive number that represents the order of the deer
  private final int id; 
	 
	  
  /**
   * Constructor that creates a new Deer object positioned at a random 
   * position of the display window
   * @param processing is the JunglePark PApplet object that represents 
   *        the display window
   */
  public Deer(JunglePark processing) {
	// Set Deer drawing parameters
	super(processing, IMAGE_FILE_NAME);

	// Set Deer identification fields:
	id = nextID;
	
	// String that identifies the current tiger
	this.label = TYPE + id; 
	nextID++;
  }
	 
  /**
   * Checks if there is a threat (a Tiger for instance) at the neighborhood
   * scanRange is an integer that represents the range of the area to be 
   * scanned around the animal
   * @param scanRange is the range that the Deer will scan to check if there
   *        is a Tiger within
   * @return threat is true if there is a threat (a Tiger) within the scan
   *         range and false is there is not
   */
  public boolean scanForThreat(int scanRange) {
	  // declare a ParkGUI object
	  ParkGUI checkTiger;
	  
	  // create threat boolean variable: is true if there is a threat 
	  // (a Tiger) within the scan range and false is there is not
	  boolean threat = false;
	  
	  // loops through listGUI
      // sets checkDeer to each object in listGUI
	  for (int i = 0; i < processing.listGUI.size(); i++) {
		checkTiger = processing.listGUI.get(i);
		
		// if the object is a Tiger and it is in close proximity to a Deer,
		// the deer displays that it is threatened
		if (checkTiger instanceof Tiger) {
		  if (this.isClose((Animal) processing.listGUI.get(i), scanRange) 
				  == true) {
		    threat = true;
		  }
		}
	  }
	  
	  return threat;
  }
	 
	 
  /**
   * Defines the behavior of a Deer object in the Jungle park
   */
  @Override
  public void action() { 
	  // scans for a threat
	  // if there is a Tiger within range then it displays that the Deer
	  // is threatened
	  if(scanForThreat(SCAN_RANGE) == true) {
		// specify font color: black
	  	this.processing.fill(0);
	  	this.processing.text("THREAT!", this.getPositionX(), 
	  			this.getPositionY() - this.image.height / 2 - 4);
	  }
  }
}
