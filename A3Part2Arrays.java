// Name: Zainab Mohammed
// Class: CS 3305/W01
// Term: Fall 2022
// Instructor: Sharon Perry
// Assignment: 3 – Part 2 Capitals

import java.util.*;
public class A3Part2Arrays {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        String[][] capitalstateArray = {{"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"}, {"Connecticut", "Hartford"},
                {"Delaware", "Dover"}, {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"}, {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"}, {"Illinois", "Springfield"},
                {"Maryland", "Annapolis"}, {"Minnesota", "Saint Paul"},
                {"Iowa", "Des Moines"}, {"Maine", "Augusta"},
                {"Kentucky", "Frankfort"}, {"Indiana", "Indianapolis"},
                {"Kansas", "Topeka"}, {"Louisiana", "Baton Rouge"},
                {"Oregon", "Salem"}, {"Oklahoma", "Oklahoma City"},
                {"Ohio", "Columbus"}, {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismark"},
                {"New York", "Albany"}, {"New Mexico", "Santa Fe"},
                {"New Jersey", "Trenton"}, {"New Hampshire", "Concord"},
                {"Nevada", "Carson City"}, {"Nebraska", "Lincoln"},
                {"Montana", "Helena"}, {"Missouri", "Jefferson City"},
                {"Mississippi", "Jackson"},
                {"Massachusettes", "Boston"},
                {"Michigan", "Lansing"},
                {"Pennslyvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}
        };
        Random r = new Random();
        for (int i=0;i<10;i++) {//change this
            int randomNum = r.nextInt(capitalstateArray.length);
            System.out.println("Please enter that capital of "+capitalstateArray[randomNum][0] +": ");
            String answer=sc.nextLine();
            if (answer.equalsIgnoreCase(capitalstateArray[randomNum][1])){
                score++;
                System.out.println("You are correct!");

            }
            else {
                System.out.println("You are incorrect. The correct answer is "+capitalstateArray[randomNum][1]);
            }
        }
        System.out.println("You got "+score+" out of 10 correct");
    }
}
