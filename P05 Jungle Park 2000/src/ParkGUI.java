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

// TODO Add file header
// TODO Add javadoc interface header

/**
 * Interface that makes it easier to create classes that will be placed in
 * JunglePark. Each object in JunglePark needs a draw method in order to be
 * continuously visually updated. Each object in JunglePark also needs a 
 * mousePressed, mouseReleased, and isMouseOver method in order for the user
 * to interact with the objects in JunglePark using their mouse.
 * 
 * @author Mouna Kacem
 *
 */
public interface ParkGUI {
  // draws a ParkGUI object (either an animal or a button) to the display 
  // window
  public void draw(); 

  //called each time the mouse is Pressed
  public void mousePressed();

  //called each time the mouse is Pressed
  public void mouseReleased(); 
  
  //checks whether the mouse is over a ParkGUI object
  public boolean isMouseOver(); 

}