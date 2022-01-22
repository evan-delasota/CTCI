// Implementing CTCI questions and logging progress through GitHub
import java.util.*;

class Main {
  public static void main(String[] args) {
    String uniqueString = "abcdefg";
    String nonUniqueString = "abcddefg";

    System.out.println(ArrayMethods.isUnique(uniqueString));
    System.out.println(ArrayMethods.isUnique(nonUniqueString));
    
    String testOne = "Mr John Smith         ";
    char[] testCharArray = testOne.toCharArray();
    ArrayMethods.urlify(testCharArray, 13);
    String urlifyTestResult = new String(testCharArray);
    System.out.println(urlifyTestResult);
  }
}