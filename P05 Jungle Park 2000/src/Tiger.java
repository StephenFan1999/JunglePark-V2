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
 * This class represents a Tiger in the JunglePark application
 *
 */
public class Tiger extends Animal {
  // range dimension for scanning the neighborhood for food
  private static final int SCAN_RANGE = 100; 
  
  //file name of the tiger image
  private static final String IMAGE_FILE_NAME = "images/tiger.png";
  
  //class variable that represents the identifier of the next tiger
  // to be created
  private static int nextID = 1;
  
  // Tiger's identification fields:
  //A String that represents the tiger type
  private static final String TYPE = "TGR"; 
  
  //Tiger's id: positive number that represents the order of the tiger
  private final int id; 

  //Number of Deers that the current tiger has eaten so far
  private int deerEatenCount; 
  
  /**
   * Creates a new Tiger object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Tiger(JunglePark processing) {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields:
    id = nextID;
    
    // String that identifies the current tiger
    this.label = TYPE + id; 
    nextID++;
    
    //set deers eaten count to zero
    deerEatenCount = 0;
  }


  /**
   * Tiger's behavior in the Jungle Park
   * Scans for food at the neighborhood of the current tiger. 
   * If the Tiger finds any deer at its proximity, it hops on it, and eats it
   */
  @Override
  public void action() {
	//declares a ParkGUI object
	ParkGUI checkDeer;
		  
	// loops through listGUI
	// sets checkDeer to each object in listGUI
    for (int i = 0; i < processing.listGUI.size(); i++) {
	  checkDeer = processing.listGUI.get(i);
	  
	  // if the object is a Deer and it is in close proximity to a Tiger,
	  // the Tiger hops on the Deer and eats it
	  if (checkDeer instanceof Deer) {
		if (this.isClose((Animal) processing.listGUI.get(i), SCAN_RANGE)
				== true) {
		  hop((Deer) checkDeer);
		}
	  }
	}
    
    // display deerEatenCount if it is greater than 0
	if(deerEatenCount > 0) {
	  displayDeerEatenCount();
	}
  }
  
  /**
   * Accessor method for deerEatenCount
   * 
   * @return deerEatenCount the number of Deers eaten by the Tiger
   */
  public int getDeerEatenCount() {
	  // simple accessor method
	  return deerEatenCount;
  }
  
  /**
   * This method runs when a Deer is in close proximity to a Tiger.
   * The tiger hops to the deer and eats it.
   * 
   * @param d is the Deer that a Tiger wants to hop on and eat
   */
  public void hop(Deer d) {
	//release the mouse first so that the Tiger will automatically hop
	//to a nearby dear that is within range
	this.mouseReleased();  
	
	//increment the number of Deers eaten by the Tiger
    deerEatenCount++;
    
    //removes the deer from the list listGUI of objects in JunglePark
    processing.listGUI.remove(d);
    
    //moves the Tiger's position to the deer position, simulating the
    //Tiger "hopping" to the Deer's location
	this.setPositionX(d.getPositionX());
	this.setPositionY(d.getPositionY());
  }
  
  /**
   * Displays the number of eaten deers if any on the top of the tiger image
   */
  public void displayDeerEatenCount() {
	// specify font color: black
    this.processing.fill(0);
    
    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(), 
    		this.getPositionY() - this.image.height / 2 - 4);  
  }
 
}