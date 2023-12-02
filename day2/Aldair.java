import java.io.BufferedReader;
import java.io.FileReader;

public class Aldair {

    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("/workspaces/AoC23/day2/test_input.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int gameId = 1;
            int sumIds = 0;
            while (line != null) {
                String lineWithoutGameSuffix = line.replaceFirst(".*: ", "");
                if (validGame(lineWithoutGameSuffix)) {
                    sumIds += gameId;
                }
                gameId++;
                line = br.readLine();
            }
            fr.close();
            br.close();
            System.out.println("Answer: " + sumIds);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean validGame(String setOfCubes) {
        int redLimit = 12;
        int greenLimit = 13;
        int blueLimit = 14;
        // sequence to break down the setOfCubes input
        // 1. "4 red, 8 green; 8 green, 6 red; 13 red, 8 green; 2 blue, 4 red, 4 green"
        // 2. ["4 red, 8 green, 8 green, 6 red, 13 red, 8 green", "2 blue, 4 red, 4 green"]
        // 3. ["4 red", "8 green", "8 green", "6 red", "13 red", "8 green"]
        // 4. ["4", "red"]
        String[] sets = setOfCubes.split(";\s*"); // seq 2.
        for (String set : sets) {
            String[] cubes = set.split("\s*,\s*"); // seq 3.
            for (String cube : cubes) {
                // 3 blue
                String[] numColorPair = cube.split(" "); // seq 4.
                int numBalls = Integer.parseInt(numColorPair[0]);
                String colorBalls = numColorPair[1];
                if (colorBalls.trim().equals("red")) {
                    if (numBalls > redLimit) {
                        return false;
                    }
                } else if (colorBalls.trim().equals("blue")) {
                    if (numBalls > blueLimit) {
                        return false;
                    }
                } else if (colorBalls.trim().equals("green")) {
                    if (numBalls > greenLimit) {
                        return false;
                    }
                }
            }

        }

        return true;
    }
}
