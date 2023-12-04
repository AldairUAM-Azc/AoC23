package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

/**
 * Aldair
 */
public class Aldair {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("/workspaces/AoC23/day4/input.txt"));
            String line = br.readLine();
            int totalScore = 0;
            int matchCounter = 0;
            int cardScore = 0;
            while (line != null) {
                matchCounter = 0;
                cardScore = 0;
                String[] noPrefixLine = line.split(":\s+");
                String[] cleanInput = noPrefixLine[1].split("\s+\\|\s+");
                List<Integer> winNums = Arrays.stream(cleanInput[0].split("\s+")).map(Integer::parseInt).toList();
                List<Integer> myNums = Arrays.stream(cleanInput[1].split("\s+")).map(Integer::parseInt).toList();
                for (int win : winNums) {
                    if (myNums.contains(win)) {
                        matchCounter++;
                    }
                }
                if (matchCounter > 0) {
                    cardScore = 1;
                    while (matchCounter > 1) {
                        cardScore *= 2;
                        matchCounter--;
                    }
                }
                totalScore += cardScore;
                line = br.readLine();
            }
            System.out.println(totalScore);
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}