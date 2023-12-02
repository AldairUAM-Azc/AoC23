import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day1Aldair {
    public static int findFirstDigit(String line){
        for(int i = 0; i < line.length(); i++){
            char currSymbol = line.charAt(i);
            if(currSymbol > 47 && currSymbol < 58){
                return currSymbol % 48;
            }
        }
        return -1;
    }

    public static int findLastDigit(String line){
        for (int i =line.length()-1; i >= 0;i--){
            char currSymbol = line.charAt(i);
            if (currSymbol >47 && currSymbol < 58) {
                return currSymbol % 48;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("/workspaces/AoC23/day1/aldair_input_day1.txt");
            br = new BufferedReader(fr);
            int sum = 0;
            while (br.ready()) {
                String line = br.readLine();
                int firstDigit = findFirstDigit(line);
                int lastDigit = findLastDigit(line);
                int num = firstDigit*10 + lastDigit;
                sum += num;
            }
            System.out.println(sum);
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }

    }
}