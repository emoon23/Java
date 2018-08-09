/**
 *
 *  ZODIAC PROGRAM
 *  Programmer: Edward Moon
 *  This program was created in dedication of the discussion what each of my friend's
 *  zodiac signs were.
 *
 */

import java.util.*;

public class Zodiac {

    int id;
    String name;
    String sign;

    public Zodiac(int id, String name, String sign) {

        this.id = id;
        this.name = name;
        this.sign = sign;

    }



    public static void main(String[] args) {

        List<Zodiac>list = new ArrayList<Zodiac>();
        //Assign the names and the signs
        Zodiac z1 = new Zodiac(1, "Edward", " Virgo");
        Zodiac z2 = new Zodiac(2, "Chris", "Sagittarius");
        Zodiac z3 = new Zodiac(3, "David", "Aquarius");
        Zodiac z4 = new Zodiac(4, "Vince", "Libra");
        Zodiac z5 = new Zodiac(5, "Sam", "Capricorn");
        Zodiac z6 = new Zodiac(6 , "Dennis", "Cancer");
        Zodiac z7 = new Zodiac(7, "Jerome", "Gemini");
        Zodiac z8 = new Zodiac(8, "Jake", "Scorpio");

        //Adding Zodiac to list
        list.add(z1);
        list.add(z2);
        list.add(z3);
        list.add(z4);
        list.add(z5);
        list.add(z6);
        list.add(z7);
        list.add(z8);

        for(Zodiac z:list){

                System.out.println(z.id+ " " + z.name+" "+z.sign+" ");

    }


}






}
