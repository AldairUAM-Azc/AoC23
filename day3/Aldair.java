import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

class Aldair {
    private static boolean symbolAroundNumber(int i, int j) {
        return true;
    }

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

    public static boolean charIsSymbol(char c) {
        return c == '-' || c == '=' || c == '*' || c == '!' || c == '%' || c == '$' || c == '&' || c == '#';
    }

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("/workspaces/AoC23/day3/input.txt");
            BufferedReader br = new BufferedReader(fr);  
            List<String> lines = br.lines().collect(Collectors.toList());
            System.out.println(lines);
            // char[] line = br.readLine().toCharArray();
            // int i = 0;
            // int j = 0;
            // while (i < line.length - 1) {
            //     // get index of first and last digit of a number in line
            //     if (charIsDigit(line[i])) {
            //         while (charIsDigit(line[j]) && j < line.length - 1) {
            //             j++;
            //         }
            //         if (j < line.length) {
            //             j--;
            //         }
            //     } else {
            //         j = i;
            //     }
            //     // search the symbol around the number.
            //     // if (symbolAroundNumber(i, j)) {
            //     System.out.println(i + j);
            //     // }
            // }
            fr.close();
            br.close();
            System.out.println("Answer: ");
        } catch (

        Exception e) {
            System.out.println(e);
        }

    }
}