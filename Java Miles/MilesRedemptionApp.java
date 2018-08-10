/********************************************************************* 
  *                                                                  *  
  *     MilesRedemptionApp                                           *                                               
  *                                                                  *  
  *  Programmer: Jake Judisch                                        * 
  *              Franklin Adams                                      * 
  *              Edward Moon                                         * 
  *                                                                  *  
  *                                                                  *                            
  *                                                                  *  
  *  Purpose:   Creates a scanner object, hands it to the            *
  *             MileRedeemer class, reads in the destination data,   *
  *             and passes it to MilesRedemptionFrame to be displayed*
  *******************************************************************/  
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.*;
import javax.swing.*;
import java.lang.*;

public class MilesRedemptionApp
{
  public static void main(String[] args) throws IOException
  {
    
    String fileName = "miles.txt";     //Name of file to be read, e.g.: "miles.txt"
    
    //create a new MileRedeemer, give it the file we are scanning and ask it to read the file
    MileRedeemer redeemer = new MileRedeemer();
    Scanner fileScan = new Scanner( new File(fileName));  
    redeemer.readDestinations(fileScan);
    fileScan.close();

    
    
    //Create the frame, passing in the String[] of the city names
    
    JFrame frame = new MilesRedemptionFrame(redeemer);
    frame.setLocationRelativeTo(null); //set the location to default
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //default exit on the "x" button clicked
    frame.setVisible(true); //default to show the frame in the gui
    
  }//end of main 
  
}//end of class MilesRedemption

