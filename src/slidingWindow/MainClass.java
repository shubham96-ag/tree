package slidingWindow;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        int[] a = {12, -1, -7, 8, 78, 1};
        System.out.println("Max sum of window of is: " + findMaxSumGivenWindowSize(a, 4));
        System.out.println("first negative element in each window is: " + findFirstNegativeInAllWindow(a, 3));
        System.out.println("Number of anagrams present in string are: " + findAllAnagram("forxxorfxdofr", "for"));
    }

    public static int findMaxSumGivenWindowSize(int[] a, int k) {
        int i = 0, j = 0, max = Integer.MIN_VALUE, sum = 0;
        while (j < a.length) {
            sum = sum + a[j];
            //Window size is always j-i+1
            if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum = sum - a[i];
                i++;
            }
            j++;
        }
        return max;
    }

    public static ArrayList<Integer> findFirstNegativeInAllWindow(int[] a, int k) {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        while (j < a.length) {
            if (a[j] < 0)
                queue.add(a[j]);
            if (j - i + 1 == k) {
                if (queue.size() == 0) //if queue is empty this means there is no -ve in window so simply add 0 to result i
                    result.add(0);
                else {
                    result.add(queue.element());
                    if (queue.element() == a[i]) //only if the current element and queue element is same pop  it out
                        queue.remove();
                    i++;
                }
            }
            j++;
        }
        return result;
    }

    public static int findAllAnagram(String s, String pattern) {
        int i = 0, j = 0, count = 0, k = pattern.length(), ans = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for ( char ch : pattern.toCharArray()) {
            if (hashMap.containsKey(ch))
                hashMap.put(ch, hashMap.get(ch) + 1);
            else
                hashMap.put(ch, 1);
        }
        count= hashMap.size();

            while (j < s.length()) {
                //calculation
                char ch = s.charAt(j);
                if (hashMap.containsKey(ch)) {
                    hashMap.put(ch, hashMap.get(ch) - 1);
                    if (hashMap.get(ch) == 0) //this means that all occurences of and alphabet present in pattern has been covered. so decrement count.
                        count--; //this is additional optimization so that again the hashmap need not to be traversed .this keeps count of total no. of distinct letters
                }

                //Window size is met
                if (j - i + 1 == k) {
                    //Window is matched completely
                    if (count == 0) {
                        ans++;
                        System.out.println(s.substring(i, j + 1));
                    }

                    //Some alphabets are not matched hence before doing i++ the first alphabet which was part of previous window
                    //has to be added back to map and count needs to be incremented as that element is out from window
                    //this is just the reverse of the operation of increment of "j"
                    char ch1 = s.charAt(i);
                    if (hashMap.containsKey(ch1)) {
                        hashMap.put(ch1, hashMap.get(ch1) + 1);
                        if (hashMap.get(ch1) >= 1)
                            count++;
                    }
                    i++;
                }
                j++;
        }
        return ans;
    }





}



