import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class Aldair {
    public static boolean charIsDigit(char c) {
        return c == '0'
                || c == '1'
                || c == '2'
                || c == '3'
                || c == '4'
                || c == '5'
                || c == '6'
                || c == '7'
                || c == '8'
                || c == '9';
    }

    public static boolean charIsSymbol(char c){
        return c == '-' || c == '=' || c == '*' || c == '!' || c == '%' || c == '$' || c == '&' || c == '#';
    }

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("/workspaces/AoC23/day3/input.txt");
            BufferedReader br = new BufferedReader(fr);
            char[] lineTop = br.readLine().toCharArray();
            // char[] lineMid = br.readLine().toCharArray();
            // char[] lineBot = br.readLine().toCharArray();
            ArrayList<String> numsCaptured = new ArrayList<>();
            String capturedNumberString = "";
            boolean startNumber = false;
            for (int i = 0; i < lineTop.length; i++) {
                if (charIsDigit(lineTop[i])) {
                    startNumber = true;
                    capturedNumberString += lineTop[i];
                    // edge case, number ends in line last character
                    if (i == lineTop.length - 1) {
                        numsCaptured.add(capturedNumberString);
                        capturedNumberString = "";
                    }
                } else if (startNumber && !charIsDigit(lineTop[i])) {
                    numsCaptured.add(capturedNumberString);
                    capturedNumberString = "";
                    startNumber = false;
                }
            }
            System.out.println(numsCaptured);
            fr.close();
            br.close();
            System.out.println("Answer: ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}