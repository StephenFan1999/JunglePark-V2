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
 * File Header must go here
 */
import java.util.Random;
/**
 * This class represents an animal in the Jungle Park application
 * It implements the interface ParkGUI
 * @author Mouna Kacem
 */
public class Animal implements ParkGUI {
  // Generator of random numbers
  private static Random randGen = new Random();
  
  //represents the animal's identifier
  protected String label;
  
  // Fields defined to draw the animal in the application display window:
  //PApplet object that represents the display window
  protected JunglePark processing;
  
  // animal's image
  protected PImage image;

  // animal's position in the display window
  // Usage: position[0: x-coordinate, or 1: y-coordinate]
  private float[] position;
  
  // indicates whether the animal is being dragged or not
  private boolean isDragging;


  /**
   * Creates a new Animal object positioned at a given position of the display 
   * window
   * 
   * @param processing PApplet object that represents the display window
   * @param positionX x-coordinate of the animal's image in the display window
   * @param positionY y-coordinate of the animal's image in the display window
   * @param imageFileName filename of the animal image
   */
  public Animal(JunglePark processing, float positionX, float positionY, 
		  String imageFileName) {

    // Set Animal drawing parameters:
	// set the PApplet Object where the animal will be drawn
    this.processing = processing; 
    
    // sets the position of the animal object
    this.position = new float[] {positionX, positionY};
    this.image = processing.loadImage(imageFileName);
    
    // initially the animal is not dragging
    isDragging = false;
  }

  /**
   * Creates a new Animal object positioned at a random position of the 
   * display window
   * 
   * @param processing PApplet object that represents the display window
   * @param imageFileName filename of the animal image
   */
  public Animal(JunglePark processing, String imageFileName) {
	//creates the Animal in a random position
    this(processing, (float) randGen.nextInt(processing.width),
        Math.max((float) randGen.nextInt(processing.height), 100), 
        imageFileName);
  }

  /**
   * Draws the animal to the display window. It sets also its position to 
   * the mouse position if the tiger is being dragged (i.e. if its 
   * isDragging field is set to true).
   */
  @Override
  public void draw() {
    // if the tiger is dragging, set its position to the mouse position 
	// with respect to the display window (processing) dimension
    if (this.isDragging) {
      // mouse outside the screen
      if (this.processing.mouseX < 0)
        this.position[0] = 0;
      // mouse outside the screen
      else if (this.processing.mouseX > this.processing.width)
        this.position[0] = this.processing.width;
      else
        this.position[0] = this.processing.mouseX;

      // mouse outside the screen
      if (this.processing.mouseY < 0)
        this.position[1] = 0;
      // mouse outside the screen
      else if (this.processing.mouseY > this.processing.height) 
        this.position[1] = this.processing.height;
      else
        this.position[1] = this.processing.mouseY;
    }

    // draw the tiger at its current position
    this.processing.image(this.image, this.position[0], position[1]);
    // display label
    displayLabel();
    
    //call action
    action();
    
  }


  /**
   * display's the Tiger object label on the application window screen
   */
  private void displayLabel() {
	// specify font color: black
    this.processing.fill(0);
    
    // display label
    this.processing.text(label, this.position[0], this.position[1] + 
    		this.image.height / 2 + 4);
                                                                                                                                                                                           // text
  }

  /**
   * Checks if the mouse is over the given tiger object
   * 
   * @param tiger reference to a given Tiger object
   * @return true if the mouse is over the given tiger object, false otherwise
   */
  @Override
  public boolean isMouseOver() {
    int tigerWidth = image.width; // image width
    int tigerHeight = image.height; // image height

    // checks if the mouse is over the tiger
    if (processing.mouseX > position[0] - tigerWidth / 2
        && processing.mouseX < position[0] + tigerWidth / 2
        && processing.mouseY > position[1] - tigerHeight / 2
        && processing.mouseY < position[1] + tigerHeight / 2) {
      return true;
    }
    return false;
  }

  @Override
  public void mousePressed() {
	// if the mouse is pressed and the mouse is over the animal
	// the animal should be dragged
    if (isMouseOver())
      isDragging = true;
  }

  @Override
  public void mouseReleased() {
	//if the mouse is released the animal should not be dragged
    isDragging = false;
  }

  /**
   * @return the label that represents the tiger's identifier
   */
  public String getLabel() {
	// simple accessor method
    return label;
  }


  /**
   * @return the image of type PImage of the tiger object
   */
  public PImage getImage() {
	//simple accessor method
    return image;
  }


  /**
   * @return the X coordinate of the animal position
   */
  public float getPositionX() {
	//simple accessor method
    return position[0];
  }

  /**
   * @return the Y coordinate of the animal position
   */
  public float getPositionY() {
	//simple accessor method
    return position[1];
  }


  /**
   * @param position the XPosition to set
   */
  public void setPositionX(float position) {
	//simple mutator method
    this.position[0] = position;
  }

  /**
   * @param position the YPosition to set
   */
  public void setPositionY(float position) {
	// simple mutator method
    this.position[1] = position;
  }

  /**
   * @return true if the animal is being dragged, false otherwise
   */
  public boolean isDragging() {
	//simple accessor method
    return isDragging;
  }

  /**
   * Computes the euclidean distance between the current animal and 
   * another one
   * @param otherAnimal reference to another animal
   * @return distance between the current animal and otherAnimal
   */
  public double distance(Animal otherAnimal) {
	//calculates the distance between current animal and another one
    return Math.sqrt(Math.pow(this.getPositionX() - 
    		otherAnimal.getPositionX(), 2)
        + Math.pow(this.getPositionY() - otherAnimal.getPositionY(), 2));
  }
  
  /**
   * Defines the behavior of the current animal in the jungle park
   */
  public void action() {
    // This method should be overridden by a subclass
  }
  
  public boolean isClose(Animal otherAnimal, int range) {
	  //boolean return value to represent if the otherAnimal is close or not
	  boolean close = false;
	  
	  //checks if the distance to the otherAnimal is less than or equal to the
	  //given range
	  if (this.distance(otherAnimal) <= range) {
		  close = true;
	  }
	  
	  return close;
  }
}