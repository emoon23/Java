/******************************************************************** 
*                                                                   *  
*      MileageComparator.java                                       *                                               
*                                                                   *  
*  Programmer: Jake Judisch                                         * 
*              Franklin Adams                                       * 
*              Edward Moon                                          * 
*                                                                   *  
*                                                                   *                            
*                                                                   *
*  Purpose:   This class implements Comparator with <Destination>   *
*             and will compare the Destinations object's            *
*             getMilesRequired().                                   * 
*                                                                   *
********************************************************************/  

import java.util.Comparator;


//Comparator Class
class MileageComparator implements Comparator<Destination>
{
  public int compare(Destination d1, Destination d2)
  {
    return (d2.getMilesRequired() - d1.getMilesRequired());
    
  }//end of compare
}//end of MileageComparator
