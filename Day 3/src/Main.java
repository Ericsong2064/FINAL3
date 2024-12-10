import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int num1=0;
        int num2=0;
        int sum=0;
        ArrayList<String> allMatches =getFileData("src/file");
        ArrayList<String> muls=new ArrayList<>();
        for(int i = 0; i<allMatches.size();i++){
            String searchString = allMatches.get(i);
            String regex = "mul\\([0-9]{1,3},[0-9]{1,3}\\)";
            Matcher m = Pattern.compile(regex).matcher(searchString);
            while (m.find()) {
                muls.add(m.group(0));
            }
        }
        System.out.println(muls);
        for(int e = 0; e<muls.size();e++){
            num1=Integer.parseInt(muls.get(e).substring(4,muls.get(e).indexOf(",")));
            num2=Integer.parseInt(muls.get(e).substring(muls.get(e).indexOf(",")+1,muls.get(e).length()-1));
            sum+=num1*num2;
        }
        System.out.println(sum);
    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}