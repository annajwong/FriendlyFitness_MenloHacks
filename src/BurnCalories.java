import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.JFrame;


public class BurnCalories extends JFrame implements MouseListener, KeyListener
{
	// scanner to get user input
	private static final Scanner sc = new Scanner(System.in);

	
	// grid for the game
	
	public static void main(String[] args) 
	{

	}

	
	/**
	 * Gets input from user about which boxes to fill.
	 * 
	 * @param grid
	 */
	private static void getUserInput()
	{

	}
	
	
	/**
	 * Paint method to draw and fill the grid
	 */
	public void paint(Graphics g)
	{

	}
	
	/********************************************
	  * MouseListener event handlers
	  ********************************************/
	 /**
	  * Called when the mouse is clicked (pressed and released without moving
	  * while the mouse is in our window) Required for any MouseListener 
	  * 
	  * @param e
	  *         Contains info about the mouse click
	  */
	 public void mouseClicked(MouseEvent e) 
	 {
	  // check if any of the attack boxes were clicked, then use that action
	  if(cut.wasClicked(e.getX(), e.getY()) == true)
	  {
	   userPokemon.cut(enemy);
	  }

	  repaint();
	 }

	 /**
	  * Called when the mouse is pressed (in our window) Required for any
	  * MouseListener
	  * 
	  * @param e
	  *         Contains info about the mouse click
	  */
	 public void mousePressed(MouseEvent e) {
	 }

	 /**
	  * Called when the mouse is released (in our window) Required for any
	  * MouseListener
	  * 
	  * @param e
	  *         Contains info about the mouse click
	  */
	 public void mouseReleased(MouseEvent e) {
	 }

	 /**
	  * Called when the mouse enters our window.
	  * 
	  * @param e
	  *         Contains info about the mouse click
	  */
	 public void mouseEntered(MouseEvent e) 
	 {
	 }

	 /**
	  * Called when the mouse exits our window.
	  * 
	  * @param e
	  *         Contains info about the mouse click
	  */
	 public void mouseExited(MouseEvent e) 
	 {
	 }
	 
	 public void keyPressed(KeyEvent e)
	 {

	 }

	 /**
	  * Called when typing of a key is completed Required for any KeyListener
	  * 
	  * @param e
	  *            Contains info about the key typed
	  */
	 public void keyTyped(KeyEvent e) {
	 }

	 /**
	  * Called when a key is released Required for any KeyListener
	  * 
	  * @param e
	  *            Contains info about the key released
	  */
	 public void keyReleased(KeyEvent e) {
	 }

}
