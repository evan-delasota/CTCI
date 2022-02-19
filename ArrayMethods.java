import java.util.*;

class ArrayMethods {
  // 1.1 Unique Characters
  public static boolean isUnique(List<String> list) {
    Set<String> seen = new HashSet<>();
    for (int i = 0; i < list.size(); ++i) {
      if (seen.contains(list.get(i))) {
        return false;
      }
      seen.add(list.get(i));
    }

    return true;
  }

  public static boolean isUnique(String string) {
    Set<Character> seen = new HashSet<>();
    for (int i = 0; i < string.length(); ++i) {
      char ch = string.charAt(i); 
      if (seen.contains(ch)) {
        return false;
      }

      seen.add(ch);
    }

    return true;
  }

  // 1.2 Permutation 
  public static boolean isPermutation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    Map<Character, Integer> seenOne = new HashMap<>();
    Map<Character, Integer> seenTwo = new HashMap<>();
    
    for (int i = 0; i < s1.length(); ++i) {
      char ch = s1.charAt(i);
      seenOne.put(ch, seenOne.getOrDefault(ch, 0) + 1);
    }

    for (int i = 0; i < s2.length(); ++i) {
      char ch = s2.charAt(i);
      seenTwo.put(ch, seenTwo.getOrDefault(ch, 0) + 1);
    }
    
    for (int i = 0; i < s1.length(); ++i) {
      char ch = s1.charAt(i);
      if (seenOne.get(ch) != seenTwo.get(ch)) {
        return false;
      }
    }

    return true;
  }
  // 1.3 urlify
  public static String urlify(char[] url) {
    int i = 0;
    int numOfSpaces = 0;
    // calculate amount of spaces in string
    for (i = 0; i < url.length; ++i) {
      if (url[i] == ' ') {
        numOfSpaces++;
      }
    }
    // account for any spaces in front of string, subtract from original space count
    while (url[i - 1] == ' ') {
      numOfSpaces--;
      i--;
    }

    int newLength = i + numOfSpaces * 2;
    int newIndex = newLength - 1;
    char[] oldUrl = url;
    url = new char[newLength];
    // starts at first non-space character of original string, works down to beginning
    for (int j = i - 1; j >= 0; --j) {
      if (oldUrl[j] == ' ') {
        url[newIndex] = '0';
        url[newIndex - 1] = '2';
        url[newIndex - 2] = '%';
        newIndex -= 3;
      } else {
        url[newIndex] = oldUrl[j];
        newIndex--;
      }
    }

    return new String(url);
  }

  // 1.4 Palindrome Permutation
  public static boolean isPalindromePermutation(String string) {
    if (string.length() < 2) {
      return false;
    }
    String trimmedString = string.replaceAll("[^a-zA-Z]", "").toLowerCase();
    int oddCount = 0;
    Map<Character, Integer> characterCount = new HashMap<>();

    for (int i = 0; i < trimmedString.length(); ++i) {
      char ch = trimmedString.charAt(i);
      characterCount.put(ch, characterCount.getOrDefault(ch, 0) + 1);
    }

    Iterator mapIterator = characterCount.entrySet().iterator();
    while (mapIterator.hasNext()) {
      Map.Entry element = (Map.Entry)mapIterator.next();
      if ((int)element.getValue() % 2 == 1) {
        oddCount++;
      }

      if (oddCount > 1) {
        return false;
      }
    }

    return true;
  }

  // 1.5 One Away
  public static boolean oneAway(String s1, String s2) {
    if (Math.abs(s1.length() - s2.length()) > 1) {
      return false;
    } 
    int lengthOne = s1.length();
    int lengthTwo = s2.length();
    int editCount = 0;
    int i = 0;
    int j = 0;

    while (i < lengthOne && j < lengthTwo) {
      // If two or more nonequivalent characters found, return false
      if (s1.charAt(i) != s2.charAt(j)) {
        if (editCount == 1) {
          return false;
        }
        // nonequivalent character and first string length is greater than second string length
        if (lengthOne > lengthTwo) {
          i++;
        // nonequivalent character and second string length is greater than first string length
        } else if (lengthTwo > lengthOne) {
          j++;
        // nonequivalent character and both strings are of equivalent length
        } else {
          i++;
          j++;
        }

        editCount++;
        // equivalent character, increment both string iterators
      } else {
        i++;
        j++;
      }
    }
    // Account for any leftover characters
    if (i < lengthOne || j < lengthTwo) {
      editCount++;
    }

    return (editCount == 0 || editCount == 1);
  }
  // 1.6 Compress String
  public static String compress(String string) {
    if (string.length() < 1) {
      return string;
    }
    StringBuilder sb = new StringBuilder();
    int characterCount = 1;

    for (int i = 1; i < string.length(); ++i) {
      char prev = string.charAt(i - 1);
      char current = string.charAt(i);
      // if current character is different from previous, append previous + count, reset count to 0
      if (current != prev) {
        sb.append(prev);
        sb.append(characterCount);
        characterCount = 0;
      }
      characterCount++;
    }
    // Adding the last character + count to string
    sb.append(string.charAt(string.length() - 1));
    sb.append(characterCount);

    String result = sb.toString();
    return (result.length() < string.length()) ? result : string;
  }

  // 1.7 Rotate Matrix
    
  // 1.8 Zero Matrix

  // 1.9 String Rotation

  // Maximum Sum Subarray of Size K
  public static double[] findSubarrayAverages(int[] arr, int k) {
    double[] result = new double[arr.length - k + 1];
    double windowSum = 0;
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < arr.length; ++windowEnd) {
      windowSum += arr[windowEnd];

      if (windowEnd >= k - 1) {
        result[windowStart] = windowSum / k;
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
      
    return result;
  }
}