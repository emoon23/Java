/**
 *  Program HelpClass Demo
 *  written by Edward Moon
 */

//Imports
import java.util.*;



public class HelpClassDemo {


    void helpOn(int what){
        switch(what){


            //First case here
            case '1':
                System.out.println("The if: \n");
                System.out.println("if(condition) statement;");
                System.out.println("else statement");
                break;
            //Second case here
            case '2':
                System.out.println("The switch:\n");
                System.out.println("Switch(expression) {");
                System.out.println("  case constant:");
                System.out.println("     statement sequence");
                System.out.println("     break;");
                System.out.println("    // ...");
                System.out.println("}");
                break;
            //Third case
            case '3':
                System.out.println("The for:\n");
                System.out.println("for(init; condition; iteration)");
                System.out.println(" statement;");
                break;
            //Fourth case
            case '4':
                System.out.println("The while:\n");
                System.out.println("while(condition) statement");
                break;
            //Fifth Case
            case '5':
                System.out.println("The do-while:\n");
                System.out.println("do {");
                System.out.println("  statement;");
                System.out.println("} while (condition);");
                break;
            //Sixth Case
            case '6':
                System.out.println("The break:\n");
                System.out.println("break; or break label;");
                break;
            //Seventh Case
            case '7':
                System.out.println("The continue:\n");
                System.out.println("continue; or continue label;");
                break;
        }
        System.out.println();
    }//end of void helpOn

    void showMenu(){


        System.out.println("Help on:");
        System.out.println("  1. If");
        System.out.println("  2. Switch");
        System.out.println("  3. For");
        System.out.println("  4. While");
        System.out.println("  5. Do-While");
        System.out.println("  6. Break");
        System.out.println("  7. Continue\n");
        System.out.println("Choose one (q to quit): ");

    }  //end of showMenu

    //Create a isValid() Method
    boolean isValid( int ch){


        if(ch < '1' | ch > '7' & ch != 'q') return false;
        else return true;

    }//end of boolean method

    //Create a foregoing methods into the Help Class
public static void main(String [] args) throws java.io.IOException{

        char choice, ignore;
        HelpClassDemo helpobj = new HelpClassDemo();

        for(;;){
            do {
                helpobj.showMenu();

                choice = (char) System.in.read();

                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');

            }while( !helpobj.isValid(choice));
            if(choice == 'q') break;
            System.out.println("\n");
            helpobj.helpOn(choice);
        }

}

}//end of HelpClassDemo
