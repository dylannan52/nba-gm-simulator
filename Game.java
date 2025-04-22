/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dylan.nbagmsim;

public class Game {
    Team teamA;
    Team teamB;
    int scoreA;
    int scoreB;
    
    public Game(Team a , Team b, int scoreA, int scoreB) {
        this.teamA = a;
        this.teamB = b;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }
    
    public void printResult() {
        System.out.println(teamA.name + " " + scoreA + " - " + scoreB + " " + teamB.name);
    }
}
