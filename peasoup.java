import java.util.*;
import java.io.*;

public class peasoup {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    int numofres = Integer.parseInt(sc.nextLine());
    for (int i=0;i<numofres;i++){
      
      int numofdish = Integer.parseInt(sc.nextLine());
      String resname = sc.nextLine();
      //String[] menu = new String[numofdish];
      ArrayList<String> menu = new ArrayList<String>();
      for (int j=0;j<numofdish;j++){
        menu.add(sc.nextLine());
      }
      if (menu.contains("pea soup") & menu.contains("pancakes")){
        System.out.print(resname);
        break;
        //return resname;
      }
      
      
    }

    System.out.print("Anywhere is fine I guess");

    
    
      
  }
}