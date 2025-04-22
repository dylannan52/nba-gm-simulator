/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dylan.nbagmsim;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
    Map<String, List<Player>> playerPool = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    
    public void generatePlayerPool() {
        Random rand = new Random();
        //create a list of first and last names
        List<String> firstName = Arrays.asList("Jalen","Randy","James","Aaron","Stephen","LeBron","Kobe",
            "Ja","Nick","Charles","Austin","Chet","Jimmy","Zion","Kevin","Devin","Kawhi","Fred",
            "Luka","Anthony","Karl","Anthony","Norman","Alex","Shai","Trey"); //26 first names
        List<String> lastName = Arrays.asList("Green","Jackson","Harden","Holiday","Curry","James","Bryant",
                "Morant","Collison","Barkley","Reeves","Holmgren","Butler","Williamson","Durant","Leonard",
                "Doncic","Davis","Towns","Powell","Black","Burns","Way","White","Brown","Pop"); //26 last names
        
        
        List<Player> pointGuards = new ArrayList<>();  
        //generating 3 point guards
        for(int i = 0 ; i < 3 ; i++){
            int pgS = rand.nextInt(25) + 75;    //shooting 75-99
            int pgF = rand.nextInt(25) + 75;    //finishing 75-99
            int pgP = rand.nextInt(20) + 80;    //playmaking 80-99
            int pgD = rand.nextInt(30) + 70;    //defense 70-99
            int pgA = rand.nextInt(30) + 70;    //athleticism 70-99
            int first = rand.nextInt(26);   //random first name
            int last = rand.nextInt(26);    //random last name
            String fullName = firstName.get(first) + " " + lastName.get(last); //generates random name
            pointGuards.add(new Player(fullName,"PG",pgS,pgF,pgP,pgD,pgA)); //player added to point guard list
        }
        playerPool.put("PG", pointGuards); //key = pg, value = list of generated point guards
        //repeat process for the rest of the positions
        //generating 3 shooting guards
        List<Player> shootingGuards = new ArrayList<>();  
        for(int i = 0 ; i < 3 ; i++){
            int sgS = rand.nextInt(20) + 80;
            int sgF = rand.nextInt(20) + 80;
            int sgP = rand.nextInt(30) + 70;
            int sgD = rand.nextInt(30) + 70;
            int sgA = rand.nextInt(30) + 70;
            int first = rand.nextInt(26);
            int last = rand.nextInt(26);
            String fullName = firstName.get(first) + " " + lastName.get(last); //generates random name
            shootingGuards.add(new Player(fullName,"SG",sgS,sgF,sgP,sgD,sgA));
        }
        playerPool.put("SG", shootingGuards);
        
        //generating 3 small forwards
        List<Player> smallForwards = new ArrayList<>();  
        for(int i = 0 ; i < 3 ; i++){
            int sfS = rand.nextInt(30) + 70;
            int sfF = rand.nextInt(30) + 70;
            int sfP = rand.nextInt(30) + 70;
            int sfD = rand.nextInt(30) + 70;
            int sfA = rand.nextInt(30) + 70;
            int first = rand.nextInt(26);
            int last = rand.nextInt(26);
            String fullName = firstName.get(first) + " " + lastName.get(last); //generates random name
            smallForwards.add(new Player(fullName,"SF",sfS,sfF,sfP,sfD,sfA));
        }
        playerPool.put("SF", smallForwards);
        
        //generating 3 power Forwards
        List<Player> powerForwards = new ArrayList<>();  
        for(int i = 0 ; i < 3 ; i++){
            int pfS = rand.nextInt(40) + 60;
            int pfF = rand.nextInt(20) + 80;
            int pfP = rand.nextInt(35) + 65;
            int pfD = rand.nextInt(20) + 80;
            int pfA = rand.nextInt(20) + 80;
            int first = rand.nextInt(26);
            int last = rand.nextInt(26);
            String fullName = firstName.get(first) + " " + lastName.get(last); //generates random name
            powerForwards.add(new Player(fullName,"PF",pfS,pfF,pfP,pfD,pfA));
        }
        playerPool.put("PF", powerForwards);
        
        //generating 3 centers
        List<Player> centers = new ArrayList<>();  
        for(int i = 0 ; i < 3 ; i++){
            int cS = rand.nextInt(40) + 60;
            int cF = rand.nextInt(20) + 80;
            int cP = rand.nextInt(40) + 60;
            int cD = rand.nextInt(20) + 80;
            int cA = rand.nextInt(40) + 60;
            int first = rand.nextInt(26);
            int last = rand.nextInt(26);
            String fullName = firstName.get(first) + " " + lastName.get(last); //generates random name
            centers.add(new Player(fullName,"C",cS,cF,cP,cD,cA));
        }
        playerPool.put("C", centers);
    }
    
    
    List<Player> team = new ArrayList<>(); //creates team of players
    List<Team> teams = new ArrayList<>(); //creating a list of teams
    
    //for each position (key), choose a player (value)
    public void assembleTeam() {
        System.out.println("---------------------------------------------");
        System.out.println("Starting with your point guard:");
        
        //choosing pg
        int count = 0;
        for(Player pg : playerPool.get("PG")) {
            count++;
            System.out.print(count + ") ");
            pg.displayPlayer();
        }
        count = 0;
        System.out.print("Select by typing (1-3): ");
        int input = validateChoice(scanner);
        team.add(playerPool.get("PG").get(input-1));
        System.out.println("---------------------------------------------");
        
        //choosing sg
        System.out.println("Now with your shooting guard:");
        for(Player sg : playerPool.get("SG")) {
            count++;
            System.out.print(count + ") ");
            sg.displayPlayer();
        }
        count = 0;
        System.out.print("Select by typing (1-3): ");
        input = validateChoice(scanner);
        team.add(playerPool.get("SG").get(input-1));
        System.out.println("---------------------------------------------");
        
        //choosing sf
        System.out.println("Now with your small forward:");
        for(Player sf : playerPool.get("SF")) {
            count++;
            System.out.print(count + ") ");
            sf.displayPlayer();
        }
        count = 0;
        System.out.print("Select by typing (1-3): ");
        input = validateChoice(scanner);
        team.add(playerPool.get("SF").get(input-1));
        System.out.println("---------------------------------------------");
        
        //choosing pf
        System.out.println("Now with your power forward:");
        for(Player pf : playerPool.get("PF")) {
            count++;
            System.out.print(count + ") ");
            pf.displayPlayer();
        }
        count = 0;
        System.out.print("Select by typing (1-3): ");
        input = validateChoice(scanner);
        team.add(playerPool.get("PF").get(input-1));
        System.out.println("---------------------------------------------");
        
        //choosing c
        System.out.println("Now with your center:");
        for(Player c : playerPool.get("C")) {
            count++;
            System.out.print(count + ") ");
            c.displayPlayer();
        }
        count = 0;
        System.out.print("Select by typing (1-3): ");
        input = validateChoice(scanner);
        team.add(playerPool.get("C").get(input-1));
        System.out.println("---------------------------------------------");
        
        //create 'Rockets' team from players chosen
        teams.add(new Team("Rockets" , team));
        
            
        
    }
    //method of execption handling
    public int validateChoice(Scanner scanner) {
        boolean valid = false;
        int input = -1;
        while(!valid) {
           try {
               input = Integer.parseInt(scanner.nextLine());
               
               if(input > 0 && input < 4) { //1-3
                   valid = true;
               } else {
                   System.out.print("Number is not within range. Try again: ");
               }
               
           } catch(NumberFormatException e) {
               System.out.print("That is not a valid number. Try again: ");
           }
        }
        return input;
    }
    
    //ratings are pulled from NBA website and inputted into the .csv file
    //generates all teams with their ratings from the .csv file and adds to the teams list
    public void generateTeamsfromCSV() {
        String file = "TeamRatings.csv"; //path to .csv file
          
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            boolean header = true;
             String line;
            while((line = br.readLine()) != null) {
                if(header) {
                    header = false; //skipping header
                    continue;
                }
                String[] values = line.split(",");
                String teamName = values[0]; //read column 1 (name)
                double offRating = Double.parseDouble(values[1]); //read column 2 (offensive rating)
                double defRating = Double.parseDouble(values[2]); //read column 3 (defensive rating)
                
                Team generatedTeam = new Team(teamName,offRating,defRating);
                teams.add(generatedTeam);
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //simulates one instance of a game between 2 teams
    public Game simulateGame(Team a, Team b) {
        Random rand = new Random();
        
        //introduce randomness and variation in the form of team performance for the game
        int aPerformance = rand.nextInt(-13,14);
        int bPerformance = rand.nextInt(-13,14);
      
        int expectedPointsA = (int)(a.offRating + b.defRating)/2;
        int expectedPointsB = (int)(b.offRating + a.defRating)/2;
        
        //true points is the expected points put by both teams +/- their performance for the night
        int truePointsA = expectedPointsA + aPerformance;
        int truePointsB = expectedPointsB + bPerformance;
        
        //in the case that there is a tie, randomly add 2 points to either team
        if(truePointsA == truePointsB) {
            int winner = rand.nextInt(2); //0,1
            if(winner == 0)
            {
                truePointsA += 2;
            } else {
                truePointsB += 2;
            }
        }
        
        //increment wins and losses respectively
        if(truePointsA > truePointsB) {
            a.recordWin();
            b.recordLoss();
        } else {
            b.recordWin();
            a.recordLoss();
        }
        return new Game(a,b,truePointsA,truePointsB);
        
    }
    
    List<Game> seasonGames = new ArrayList<>(); //initialize list of season games
    List<Game> rocketGames = new ArrayList<>(); //initialize a list of only rockets games
    
    //method to simulate all games
    public void SimulateSeason() {
        //double round robin format: each team plays each team twice
        for(int s = 0; s < 2 ; s++){ //loops for rounds
            for(int i = 0; i < teams.size() ; i++) { //go down the teams list 0->30
                for(int j = i+1 ; j < teams.size() ; j++) { //loop i->30
                    Game game = simulateGame(teams.get(i),teams.get(j)); //simulate game
                    seasonGames.add(game); //add the game to the seasonGame list
                    if(i == 0) {
                        rocketGames.add(game); //if a rockets game (i=0) add to rocketGames list as well
                    }
                }
            }
        }
    }
    //display every match played
    public void displayGames() {
        for(Game g : seasonGames) {
            g.printResult();
        }
    }
    //display only rockets matches
    public void displayRocketsGames(){ 
        for(Game r : rocketGames) {  
            r.printResult();
        }
    }
    
    //recursive method for sorting teams
    public void recursiveSortTeams(List<Team> list, int start) {
        if(start >= list.size() - 1) //base case | recursion stops once start is out of bounds
            return;
        
        //find the team with the highest wins and set the index at 0
        int maxIndex = start;
        for(int i = start + 1; i <list.size(); i++) {
            if(list.get(i).wins > list.get(maxIndex).wins) {
                maxIndex = i;
            }
        }
        
        //swaps the current team at index 0 with the index of the team with the highest wins tally 
        Collections.swap(list,start,maxIndex);
        recursiveSortTeams(list, start + 1); //recursive call the decrementing the size by 1
    }
    
    //displays the standings after the entire season is played through
    public void displayStandings() {
        recursiveSortTeams(teams,0); //call recursive sort to put teams in descending order
        int count = 0;
        for(Team t : teams) {
            count++;
            System.out.print("#" + count + ". ");
            System.out.println(t.name + ": " + t.wins + "W - " + t.losses + "L");
        }
    }
            
}
