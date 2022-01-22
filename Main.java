// Implementing CTCI questions and logging progress through GitHub
import java.util.*;

class Main {
  public static void main(String[] args) {
    List<String> uniqueListOne = Arrays.asList("abc", "bcc", "cdc", "dad", "fer");
    List<String> uniqueListTwo = Arrays.asList("bb", "agrtd", "ceaf", "ddec", "bb");
    String uniqueString = "abcdefg";
    String nonUniqueString = "abcddefg";

    System.out.println(ArrayMethods.isUnique(uniqueListOne));
    System.out.println(ArrayMethods.isUnique(uniqueListTwo));
    System.out.println(ArrayMethods.isUnique(uniqueString));
    System.out.println(ArrayMethods.isUnique(nonUniqueString));

  }
}