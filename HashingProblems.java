/*
 
 * ***Jesse amodemaja / 001 ***
 *
 *
 * This HashingProblems object contains three methods / problems that you must
 * complete utilize the HashMap object within the Java's Collection Framework Library.
 *
 * The three methods / problems you need to solve are:
 *  - getAverage
 *  - odd
 *  - twoSums
 */

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.HashSet;
 
 class HashingProblems {
 
     /*
      * Method getAverage()
      *
      * This method accepts two parameters. The first is a HashMap object, while the second
      * is an array of integers. This method must compute the average of the values for each
      * 'key' that is found in BOTH the HashMap and the array.
      *
      * For example, if only the keys 1 and 2 from the array are present in the HashMap, and
      * let's say their values were 10 and 20, respectively, then the average is calculated
      * as (10+20)/2 = 15. Let's also say the keys ‘7’ and ‘8’ are in the array, but those keys
      * are not present in the HashMap. That means their corresponding values in the HashMap
      * are not included in the average calculation.
      *
      * Note: if NO values found in common between the HashMap and supplied array,
      * returning 0.0 is NOT correct, as that is not the average value. Whereas
      * returning 0.0/0.0 IS correct (which would return a non-number).
      */
     public double getAverage(HashMap<Integer, Integer> map, int[] array) {
         // -----------------------------------------------------
         // 1. Initialize sum and count to keep track of the total and number of common keys.
         // 2. Loop through each key in the provided array:
         //    a. For each key, check if it exists in the map.
         //    b. If the key is present:
         //       i. Retrieve its value from the map.
         //       ii. Add the value to sum.
         //       iii. Increment count by 1.
         // 3. After iterating through the array:
         //    a. If count is 0, return NaN (0.0/0.0).
         //    b. Otherwise, calculate the average as sum/count.
         // 4. Return the calculated average.
         // -----------------------------------------------------
         int sum = 0;
         int count = 0;
         for (int key : array) {
             if (map.containsKey(key)) {
                 sum += map.get(key);
                 count++;
             }
         }
         if (count == 0) {
             return 0.0 / 0.0; // returns NaN
         }
         return (double) sum / count;
     }
 
     /*
      * Method odd()
      *
      * This method accepts a HashMap object, and returns an ArrayList object with the
      * values of the corresponding keys that are odd.
      *
      * Hint: Consider iterating over the HashMap using the keySet method.
      */
     public ArrayList<String> odd(HashMap<Integer, String> map) {
         // -----------------------------------------------------
         // 1. Create an ArrayList called 'result' to store values for odd keys.
         // 2. Iterate over each key in the map:
         //    a. Check if the key is odd (i.e., key % 2 != 0).
         //    b. If it is odd, add the corresponding value to 'result'.
         // 3. Return the result list.
         // -----------------------------------------------------
         ArrayList<String> result = new ArrayList<>();
         for (Integer key : map.keySet()) {
             if (key % 2 != 0) {
                 result.add(map.get(key));
             }
         }
         return result;
     }
 
     /*
      * Method twoSums()
      *
      * You ARE to solve this problem in time complexity O(n). The submittals will be spot checked.
      *
      * Problem statement:
      * Suppose you are given an integer array containing the values [1,4,5,7,8,9] along with the
      * value k=4, where k is the difference between two array elements. How many times does k appear
      * in that list?
      *
      * With the above numbers, it will be three times:
      *    k = 4
      *    (5 - 1) = k
      *    (8 - 4) = k
      *    (9 - 5) = k
      *    k appears 3 times.
      *
      * All combinations must be considered. But, any other combination of the numbers in the array
      * results in a difference value that is not equal to k (k=4 in this case).
      *
      * This can be solved using nested for-loops, checking all combinations of the values in the array.
      * But the time complexity would be O(n^2).
      *
      * In order to solve this problem in O(n) complexity, utilize a HashMap (or a HashSet).
      *
      * You are to solve this using a HashMap (or you can use a HashSet, which is implemented
      * using HashMap). To solve this, you should populate the HashMap (or HashSet) based on
      * the array (this will be complexity time on the order of 'n'). After populating the HashMap,
      * consider a for-loop that does a lookup (probe) of the HashMap (or HashSet) on each iteration
      * of the loop. This will also have a complexity on the order of 'n', as the hashing probes are a
      * constant time complexity (after removing any constant based on collisions).
      *
      * This will result in a time complexity of O(n) for the overall method.
      *
      * NOTE: Solving using a HashMap or HashSet is fine (either is okay). HashSet may be easier to code?
      */
     public int twoSums(int[] numbers, int k) {
         // -----------------------------------------------------
         // 1. Create a HashSet and add all numbers from the array for quick lookup.
         // 2. Initialize a counter 'count' to 0.
         // 3. For each number in the set:
         //    a. Check if (number + k) exists in the set.
         //    b. If it exists, increment 'count'.
         // 4. Return 'count' as the total number of valid pairs.
         // -----------------------------------------------------
         HashSet<Integer> set = new HashSet<>();
         for (int num : numbers) {
             set.add(num);
         }
         int count = 0;
         for (int num : set) {
             if (set.contains(num + k)) {
                 count++;
             }
         }
         return count;
     }
 }
 