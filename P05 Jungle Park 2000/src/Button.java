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

// This a super class for any Button that can be added to a PApplet application
// This class implements the ParkGUI interface
// TODO You MUST comment well this code
// TODO ADD File header, Javadoc class header, Javadoc method header to every 
// method, and in-line commenting

/**
 * This a super class for any Button that can be added to a PApplet application
 * It implements the interface ParkGUI
 * @author Mouna Kacem, Stephen Fan
 */
public class Button implements ParkGUI {
  // Width of the Button
  private static final int WIDTH = 85;
  
  //Height of the Button
  private static final int HEIGHT = 32;
  
  //PApplet object where the button will be displayed
  protected JunglePark processing;
  
  //array storing x and y positions of the Button with respect to the
  //display window
  private float[] position; 
  
  //text/label that represents the button
  protected String label;

  /**
   * constructor for the button superclass that takes in the x and y
   * coordinates of its location and the PApplet application
   * @param x is the x-coordinate of the button's location
   * @param y is the y-coordinate of the button's location
   * @param processing is the PApplet Application that the button
   *        is being added to
   */
  public Button(float x, float y, JunglePark processing) {
	//sets all the button constructors parameters equal to the
	//classes fields
    this.processing = processing;
    this.position = new float[2];
    this.position[0] = x;
    this.position[1] = y;
    
    //sets the button's label to Button
    this.label = "Button";
  }

  /**
   * Button superclass' draw method
   * Overrides the interface ParkGUI's draw method
   * Draws a Button to the display window
   */
  @Override
  public void draw() {
	// set line value to black
    this.processing.stroke(0);
    
    //checks if the mouse is over the button
    if (isMouseOver())
      // set the fill color to dark gray if the mouse is over the button
      processing.fill(100);
    else
      // set the fill color to light gray otherwise
      processing.fill(200);

    // draw the button (rectangle with a centered text)
    processing.rect(position[0] - WIDTH / 2.0f, position[1] - HEIGHT / 2.0f,
        position[0] + WIDTH / 2.0f, position[1] + HEIGHT / 2.0f);
    
    // set the fill color to black
    processing.fill(0);
    
    // display the text of the current button
    processing.text(label, position[0], position[1]);
  }

  /**
   * Button superclass' mousePressed method
   * Overrides the interface ParkGUI's mousePressed method
   * Runs when the mouse is pressed
   */
  @Override
  public void mousePressed() {
	//checks if the mouse is over the Button
    if (isMouseOver())
      System.out.println("A button was pressed.");
  }

  /**
   * Button superclass' mouseReleased method
   * Overrides the interface ParkGUI's mouseReleased method
   * Runs when the mouse is released
   */
  @Override
  public void mouseReleased() {}

  /**
   * Button superclass' isMouseOver method
   * Overrides the interface ParkGUI's isMouseOver method
   * Checks if the mouse is over the Button
   * @return returns true if the mouse is over the button and false otherwise
   */
  @Override
  public boolean isMouseOver() {
	//checks whether the mouse x and y coordinates are within the
	//x and y coordinates of the Button
    if (this.processing.mouseX > this.position[0] - WIDTH / 2
        && this.processing.mouseX < this.position[0] + WIDTH / 2
        && this.processing.mouseY > this.position[1] - HEIGHT / 2
        && this.processing.mouseY < this.position[1] + HEIGHT / 2)
      return true;
    return false;
  }
}