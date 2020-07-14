import java.util.*;
import java.io.*;

public class peasoup1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numofres = Integer.parseInt(sc.nextLine());
        for (int i = 0; i<numofres; i++){
            int menu = Integer.parseInt(sc.nextLine());
            boolean peasoup = false;
            boolean pancakes = false;
            String resname = sc.nextLine();

            for (int j=0; j<menu; j++){
                String menuitem = sc.nextLine();
                if (menuitem.equals("pea soup")){
                    peasoup = true;
                }
                if (menuitem.equals("pan cakes")){
                    pancakes = true;
                }

                if (peasoup && pancakes){
                    System.out.println(resname);
                    System.exit(0);
                }
            }
        
        }
        System.out.println("anywhere is fine");
    }

}
