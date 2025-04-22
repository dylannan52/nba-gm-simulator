/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dylan.nbagmsim;


import java.util.*;

public class NbaGMsim {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the NBA GM Simulator!");
        System.out.println("You are the new GM for the Houston Rockets.");
        
        System.out.print("What is your name? ");
        String gmName = scanner.nextLine();
        System.out.println("---------------------------------------------");
        System.out.println("GM " + gmName + ", I'ts time to choose your starting 5.");
        
        Simulator nbaSim = new Simulator();
        nbaSim.generatePlayerPool();
        nbaSim.assembleTeam();
        nbaSim.generateTeamsfromCSV();
        nbaSim.SimulateSeason();
        
        System.out.println("Simulating Season... \n");
        
        String in;
        boolean valid = false;
        while(!valid){
            System.out.print("Would you like to see the results of your matches? (y/n): ");
            in = scanner.nextLine();
            switch(in) {
                case "Y":
                case "y":
                    System.out.println("---------------------------------------------");
                    System.out.println("HOUSTON ROCKETS SEASON RESULTS:");
                    nbaSim.displayRocketsGames();
                    valid = true;
                    break;
                case "N":
                case "n":
                    valid = true;
                    break;
                default:
                    System.out.println("Invalid input. Try Again:");
               
            }
        }   
        
        valid = false;
        while(!valid){
            System.out.print("Would you like to see the results of all matches? (y/n): ");
            in = scanner.nextLine();
            switch(in) {
                case "Y":
                case "y":
                    System.out.println("---------------------------------------------");
                    System.out.println("ALL MATCH RESULTS:");
                    nbaSim.displayGames();
                    valid = true;
                    break;
                case "N":
                case "n":
                    valid = true;
                    break;
                default:
                    System.out.println("Invalid input. Try Again:");
               
            }
        } 
        
        System.out.println("---------------------------------------------");
        System.out.print("Press Enter to see the final standings of the NBA regular season.");
        String next = scanner.nextLine();
        System.out.println("Displaying Standings for the NBA regular season: \n");
        nbaSim.displayStandings();
        System.out.println("Thanks for playing the NBA GM SIMULATOR!");
        
        
    }
}
