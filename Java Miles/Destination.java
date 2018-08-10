/******************************************************************                                                                                                                                                    *  
*  Destination.java                                               *                                               
*                                                                 *  
*  Programmer: Jake Judisch                                       * 
*              Franklin Adams                                     * 
*              Edward Moon                                        * 
*                                                                 *  
*                                                                 *                            
*                                                                 *  
*  Purpose:   The Destination class encapsulates the information  *
*             such as the name of the destination city. The normal*
*             miles, supersaver, additional miles for upgrading,  *
*             start and end of the month for a supersaver program.*
*             The constructor initialized takes the information.  *
*                                                                 *
*                                                                 *
*****************************************************************/  

public class Destination
{
  private String m_destinationCity;         //destination city
  private int m_milesRequired;              //normal miles required for a ticket
  private int m_supersaverMiles;            //supersaver miles
  private int m_additionalMilesForUpgrade;  //additional miles for upgrading
  private int m_startMonth;                 //start month of the supersaver program
  private int m_endMonth;                   //end month of the supersaver program
  
  //main constructor
  public Destination( String destinationCity, int milesRequired, int supersaverMiles,
                     int additionalMilesForUpgrade, int startMonth, int endMonth)
  {
    m_destinationCity = destinationCity;
    m_milesRequired = milesRequired;
    m_supersaverMiles = supersaverMiles;
    m_additionalMilesForUpgrade = additionalMilesForUpgrade; 
    m_startMonth = startMonth;
    m_endMonth = endMonth;
    
  }
  //get destination city
  public String getDestinationCity()
  {
    return m_destinationCity;
  }
  //get normal miles required for a ticket
  public int getMilesRequired()
  {
    return m_milesRequired;
  }
  //get supersaver miles
  public int getSuperSaverMiles()
  {
    return m_supersaverMiles;
  }
  //get additional miles for upgrading
  public int getAdditionalMilesForUpgrade()
  {
    return m_additionalMilesForUpgrade;
  }
  //get start month of the supersaver program
  public int getStartMonth()               
  {
    return m_startMonth;
  }
  //get end month of the supersaver program
  public int getEndMonth()  
  {
    return m_endMonth;
  }
  
  //set destination city
  public void setDestinationCity(String destinationCity)
  {
    m_destinationCity = destinationCity;
  }
  //set normal miles required for a ticket
  public void setMilesRequired(int milesRequired)
  {
    m_milesRequired = milesRequired;
  }
  //set supersaver miles
  public void setSupersaverMiles(int supersaverMiles)
  {
    m_supersaverMiles = supersaverMiles;
  }
  //set additional miles for upgrading
  public void setAdditionalMilesForUpgrade(int additionalMilesForUpgrade)
  {
    m_additionalMilesForUpgrade = additionalMilesForUpgrade;
  }
  //set start month of the supersaver program
  public void setStartMonth(int startMonth)               
  {
    m_startMonth = startMonth;
  }
  //set end month of the supersaver program
  public void setEndMonth(int endMonth)  
  {
    m_endMonth = endMonth;
  }

}