import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Day1Aldair {
    public static int findIndexFirstDigit(String line) {
        for (int i = 0; i < line.length(); i++) {
            char currSymbol = line.charAt(i);
            if (currSymbol > 47 && currSymbol < 58) {
                return i;
            }
        }
        return -1;
    }

    public static int findIndexLastDigit(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            char currSymbol = line.charAt(i);
            if (currSymbol > 47 && currSymbol < 58) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] numberNames = new String[] { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        HashMap<Integer, Integer> indexDigitMap = new HashMap<>();

        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("/workspaces/AoC23/day1/aldair_input_day1.txt");
            br = new BufferedReader(fr);
            int result = 0;
            while (br.ready()) {
                String line = br.readLine();
                int idxFirstDigit = findIndexFirstDigit(line);
                int idxLastDigit = findIndexLastDigit(line);
                indexDigitMap.put(idxFirstDigit, Character.getNumericValue(line.charAt(idxFirstDigit)));
                indexDigitMap.put(idxLastDigit, Character.getNumericValue(line.charAt(idxLastDigit)));
                // Find the number in letter inside line
                for (int i = 0; i < numberNames.length; i++) {
                    int position = line.indexOf(numberNames[i]);
                    if (position != -1) {
                        indexDigitMap.put(position, i+1);
                    }
                }
                
                Set<Integer> keySet = indexDigitMap.keySet();
                // System.out.println("START");
                // System.out.println(indexDigitMap);
                // System.out.println(Collections.min(keySet) + indexDigitMap.get(Collections.max(keySet)));
                // System.out.println(indexDigitMap.get(Collections.min(keySet))*10 + indexDigitMap.get(Collections.max(keySet)));
                result += indexDigitMap.get(Collections.min(keySet))*10 + indexDigitMap.get(Collections.max(keySet));
                indexDigitMap.clear();
            }
            System.out.println(result);
            br.close();
            fr.close();
        } catch (

        FileNotFoundException e) {
            System.out.println("File not Found");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }

    }
}