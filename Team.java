/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dylan.nbagmsim;

import java.util.*;
public class Team {
    String name;
    double offRating; //average points scored per game
    double defRating; //average points conceded per game
    int wins = 0;
    int losses = 0;
    
    
    //constructor
    public Team(String name, double offRate, double defRate){
        this.name = name;
        this.offRating = offRate;
        this.defRating = defRate;
    }
    //constructor for the user's team
    public Team(String name , List<Player> players) {
        this.name = name;
        double totalOff = 0.0;
        double totalDef = 0.0;
        for(Player p : players) { //adds all players offense and defense rating
            totalOff += p.getOffRating();
            totalDef += p.getDefRating();
        }
        this.offRating = totalOff/5.0;
        this.defRating = 200 - (totalDef/5.0); //inverse defRating (higher defRating = worse defense)
    }
    
    public void recordWin() {
      wins++;  
    }
    
    public void recordLoss() {
        losses++;
    }
    
}
