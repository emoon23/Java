/********************************************************************* 
*                                                                    *  
*     MileRedeemer.java                                              *                                               
*                                                                    *  
*  Programmer: Jake Judisch                                          * 
*              Franklin Adams                                        *
*              Edward Moon                                           * 
*                                                                    *  
*                                                                    *                            
*                                                                    *    
*  Purpose:   The MileRedeemer class encapsulate the logic for       *
*             redeeming mileage. This class should have private      *
*             instance variables for an array of Destination objects *
*             and integer to represent the remaining miles after     *
*             the user's miles have been redeemed                    *
*                                                                    * 
*                                                                    *  
*********************************************************************/  

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.lang.String;
import java.util.Arrays;

public class MileRedeemer
{
  private int remainingMiles;
  
  private String record;
  ArrayList<Destination> destinations = new ArrayList<Destination>();
  
  
  
  public MileRedeemer()
  {
    this.remainingMiles = 0;
  }//end of Destination() constructor
  
  public void readDestinations(Scanner fileScan) throws IOException
  {
    
    int    tempNormalMileageInt;       //temporarily store the normal mileage as a int
    int    tempSuperSaverMileageInt;   //temporarily store supersaver mileage as a int
    int    tempFirstClassMileageInt;   //temporarily store first class mileage as a int
    int    tempStartMonthInt;          //temporarily store start month as a int
    int    tempEndMonthInt;            //temporarily store end month as a int
    
    String tempStr; //temporary string variable
    String record;  //Current line being read from record
    String tempCityName; //temporarily holds the City Name from the record as a string          
    
    String[] splitMonths = new String[2]; //holds the results of splitting "#-#" into two strings
    String[] items = new String[5]; //temporary holds the results of splitting the line of text by ";"
    
    
    
    //while there is another line of input
    while ( fileScan.hasNext())
    {
      //read in the next line
      record = fileScan.nextLine();
      
      //split it by ";"
      items = record.split(";");
      
      //store the name of the Destination city
      tempCityName = items[0];
      
      //store the mileage of the Destination
      tempStr = items[1];
      tempNormalMileageInt = Integer.parseInt(tempStr);
      
      //store the supersaver mileage of the Destination
      tempStr = items[2];
      tempSuperSaverMileageInt = Integer.parseInt(tempStr);
      
      //store the cost to upgrade to first class of the Destination
      tempStr = items[3];
      tempFirstClassMileageInt = Integer.parseInt(tempStr);
      
      //read and split the supersaver months of the Destination
      tempStr = items[4];
      splitMonths = tempStr.split("-");
      
      //store the supersaver start month of the Destination
      tempStr = splitMonths[0];
      tempStartMonthInt = Integer.parseInt(tempStr);
      
      //store the supersaver end month of the Destination
      tempStr = splitMonths[1];
      tempEndMonthInt = Integer.parseInt(tempStr);
      
      //write all of this info into a destination and add it to the destinations ArrayList
      Destination tempDestination = new Destination( tempCityName,
                                                    tempNormalMileageInt,
                                                    tempSuperSaverMileageInt,
                                                    tempFirstClassMileageInt,
                                                    tempStartMonthInt,
                                                    tempEndMonthInt);
      destinations.add(tempDestination);
      
    }//end while
    
    //close the file
    fileScan.close();
    this.sortByMilesRequired();
    
  }//end of readDestinations
  
  public String[] getCityNames()
  {
    String[] cityNames = new String[destinations.size()];
    
    for (int i = 0; i < destinations.size(); i++)
    {
      cityNames[i] = destinations.get(i).getDestinationCity();
    }
    Arrays.sort(cityNames);
    return cityNames;
  }
  
  //assumes that the destinations array is sorted by distance
  public String[] redeemMiles(int miles, int month)
  {
    //make a string array big enough to store the name of each destination city we pick
    String[] pickedDestinations = new String[destinations.size()];
    //store the actual size of the above array
    int pickedDestinationsSize = 0;
    //store how many miles we have used
    remainingMiles = miles;
    

    //loop with regular miles
    for (int i = 0; i < destinations.size(); i++)
    { 
      //if the user can afford the destination
      if(enoughMiles(destinations.get(i), remainingMiles))
      {
        //add the city name to the pickedDestinations array
        pickedDestinations[pickedDestinationsSize] = destinations.get(i).getDestinationCity();
        //subtract the mile cost from our total
        remainingMiles -= destinations.get(i).getMilesRequired();
        pickedDestinationsSize++;
      }
    }
    
    
    //Make the output string array based on the final size
    String[] outputArray = new String[pickedDestinationsSize];
    
    
    //apply supersaver miles
    int pickedDestinationsLoc = 0;
    for (int i = 0; i < destinations.size(); i++)
    {     
      //if the destination is a supersaver this month and we are going there
      if((isInMonth(destinations.get(i), month)) && (destinations.get(i).getDestinationCity() == pickedDestinations[pickedDestinationsLoc]))
      {
        //add back the super saver miles
        remainingMiles += (destinations.get(i).getMilesRequired()-destinations.get(i).getSuperSaverMiles());
        //increment pickedDestinationsLoc
        pickedDestinationsLoc++;
      }
    }
    
    
    //try to upgrade the destinations to first class
    pickedDestinationsLoc = 0;
    for (int i = 0; i < destinations.size(); i++)
    {
      //if its a destination we are going to we add a line about it to the output array
      if(destinations.get(i).getDestinationCity() == pickedDestinations[pickedDestinationsLoc])
      {
        //if we can upgrade
        if(canUpgrade(destinations.get(i), remainingMiles))
        {
          outputArray[pickedDestinationsLoc] = "* A trip to " + pickedDestinations[pickedDestinationsLoc] + " in first class";
          remainingMiles -= destinations.get(i).getAdditionalMilesForUpgrade();
        }
        //if we cant upgrade
        else
        {
          outputArray[pickedDestinationsLoc] = "* A trip to " + pickedDestinations[pickedDestinationsLoc] + " in economy class";
        }
        pickedDestinationsLoc++;
        //subtract the cost of the upgrade
        
      }
    }
    
    
    return outputArray;
  }
  
  //this method takes in a 
  public Destination convertDestNameToDest(String str)
  {
    for (int i = 0; i < destinations.size(); i++)
    {     
      //if the destination is a supersaver this month and we are going there
      if(destinations.get(i).getDestinationCity() == str)
      {
        return destinations.get(i);
      }
    }
    return destinations.get(0);
  }
  
  
//checks if a departure month is within a destination's window
//months defined 1-12
  private boolean isInMonth(Destination dest, int month)
  {
    int start = dest.getStartMonth();
    int end = dest.getEndMonth();
    
    if(( start <= month ) && ( month <= end ))
    {
      return true;
    }
    return false;
  }
  
//checks if the user has enough miles to travel to a destination
  private boolean enoughMiles(Destination dest, int miles)
  {
    if(dest.getMilesRequired() <= miles)
    {
      return true;
    }
    return false;
  }
//checks if the user has enough miles to upgrade a flight
  private boolean canUpgrade(Destination dest, int miles)
  {
    if(dest.getAdditionalMilesForUpgrade() <= miles)
    {
      return true;
    }
    return false;
  }
  //return the remaining miles
  public int getRemainingMiles() 
  {
    return remainingMiles;
  }
  //sort by getMilesRequired()
  private void sortByMilesRequired()
  {
    Collections.sort(destinations, new MileageComparator());
    
  }

}//end of MileReedemer