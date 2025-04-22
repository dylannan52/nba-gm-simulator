/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dylan.nbagmsim;


public class Player {
    String name;
    String position;
    int shotRating;
    int finishRating;
    int playRating;
    int defRating;
    int athRating;
    
    //constructor
    public Player(String name, String position, int sRate, int fRate, int pRate, int dRate, int aRate) {
        this.name = name;
        this.position = position;
        this.shotRating = sRate;
        this.finishRating = fRate;
        this.playRating = pRate;
        this.defRating = dRate;
        this.athRating = aRate;   
    }
    //adjust ratios for balancing
    public int getOffRating() {
        return (int)(shotRating*0.4 + finishRating*0.35 + playRating*0.35 + athRating*0.3);
    }
    //adjust ratios for balancing
    public int getDefRating() {
        return (int)(defRating*0.75 + athRating*0.25);
    }
    
    public void displayPlayer() {
        String player = name + " | " + position + " | Shooting: " + shotRating + ", Finishing: " + finishRating +
                ", Playmaking: " + playRating + ", Defence: " + defRating + ", Athleticism: " + athRating;
        System.out.println(player);
    }
    
}
