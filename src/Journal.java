import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Journal {
    private static final String SAMPLE_CSV_FILE_PATH = "journalEvents_ru.csv";

    public static void main(String[] args) {
        int lines = count("\\n");
        String[] isSquirel = new String[lines];
        String[] Actions_line = new String[lines];
        String[][] Actions_all = new String[lines][];
        try {
            Scanner sc = new Scanner(new File(SAMPLE_CSV_FILE_PATH));
            sc.useDelimiter(",");
            Scanner scan = new Scanner(new File(SAMPLE_CSV_FILE_PATH));
            scan.useDelimiter("\\n");
            for (int i = 0; i < lines; i++) {
                Actions_line[i] = scan.next();
            }
            int len_array;
            for (int i = 0; i < lines; i++) {
                len_array = count_len(Actions_line[i]);
                Actions_all[i] = new String[len_array];
                for (int j = 0; j < len_array; j++) {
                    if (j != len_array) {
                        Actions_all[i][j] = take_word(Actions_line[i], j, len_array);
                    }
                }
                isSquirel[i] = take_word(Actions_line[i], len_array, len_array);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.deepToString(Actions_all));
        System.out.println(Arrays.deepToString(isSquirel));
    }

    static int count(String delimit) {
        int lines = 0;
        try {
            Scanner sc = new Scanner(new File(SAMPLE_CSV_FILE_PATH));
            sc.useDelimiter(delimit);
            while (sc.hasNext()) {
                lines++;
                sc.next();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

    static int count_len(String lin) {
        int count_le = 0;
        char[] arr = lin.toCharArray();
        for (int ii = 0; ii < lin.length(); ii++) {
            if (arr[ii] == ',') {
                count_le++;
            }
        }
        return count_le;
    }

    static String take_word(String line, int i, int len) {
        int count = 0;
        int start = 0;
        int end = 0;
        String[] stroka = new String[99];
        String result = "";
        char[] arr = line.toCharArray();
        for (int ii = 0; ii < line.length(); ii++) {
            if (arr[ii] == ',') {
                start = end;
                if (start != 0) {
                    start++;
                }
                end = ii;
                stroka[count] = line.substring(start, end);
                count++;
            } else if (ii == line.length() - 1) {
                start = end + 1;
                end = line.length() - 1;
                stroka[count] = line.substring(start, end);
            }
        }
        result = stroka[i];
        return result;
    }
}
