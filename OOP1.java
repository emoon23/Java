/**
 *
 *  Object Oriented Practice in Java...
 *  This program is to see test out the properties from a BMW M3 and a
 *  Subaru WRX
 *  By Edward Moon
 *
 */


//The Start of OOP1
public class OOP1 {



    //Declaration of variables here
        String car = "BMW";
        String name = "M3";
        int speed = 0;
        int gear = 1;
        int cadence = 0;


        void changeGear(int newValue) {


            gear = newValue;

        }

        //Here is where the properties for the M3
        void changeCadence (int newValue){
            cadence = newValue;
        }
        void changeSpeed(int increment){

            speed = speed + increment;
        }

        void applyBrake(int decrement){

            speed = speed - decrement;
        }

        void printstats(){

            System.out.println("Name of car: " + car + " Cadence: "+ cadence+ " Speed: "+ speed + " Gear: " + gear);

        }


        //WRX CLASS (2nd Class)
   public static class Subaru extends OOP1{

            String model = "STI";
            int year = 0;
            double price = 0.00;


            void Smodel(String newValue){

                model = newValue;

            }

            //Setting the properties for newValue
            void Syear(int newValue){
                year = newValue;
            }

            void Sprice(double newValue){

                price = newValue;

            }


            void printstats2(){
                System.out.println("Subaru " + model + " Year: "+ year + " Price: " + price);
            }


    }

    //Main program where the functions, drivers, and Constructors go into...
    public static void main(String [] args){

    //Constructor here
        OOP1 op1 = new OOP1();
        OOP1 op2 = new OOP1();

        //Second constructor here
        Subaru sub1 = new Subaru();


        //Invoke methods
        op1.changeCadence(50);
        op1.changeSpeed(10);
        op1.changeGear(2);
        op1.printstats();

        op2.changeCadence(50);
        op2.changeGear(2);
        op2.changeSpeed(10);
        op2.changeCadence(40);
        op2.changeSpeed(10);
        op2.changeGear(3);
        op2.printstats();


        //Newline
        System.out.println("\nSecond car..");

        //Invoke 2nd methods
        sub1.Syear(2018);
        sub1.Sprice(35000.00);
        sub1.printstats2();


    }





}// end of class OOP1
