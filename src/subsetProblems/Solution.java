package subsetProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        subseq("abc","");
        int [] a =    {1,2,3};



        ArrayList<ArrayList<Integer>> rs = subseqIterative(a);
        for(ArrayList<Integer> i : rs){
            System.out.println(i.toString());
        }
        System.out.println("#########permutations list###############");
        //permutation("","abcd");
        //System.out.println("Total no. of permutations: "+permutationCount("","abcd"));
        //permutationList("","aacd").stream().forEach(i-> System.out.println(i));
        System.out.println(letterCombinations("23"));
        System.out.println("ways toget 4when dice is rolled");
        dice("",4);
    }


    public static void subseq(String p, String up){
        if(up.length()==0){
            System.out.println(p);
            return ;
        }
        char ch = up.charAt(0);
        subseq(p+ch,up.substring(1)); //consider the char
        subseq(p      ,up.substring(1)); //do not consider the char
    }

    public  static ArrayList<ArrayList<Integer>> subseqIterative(int[] arr){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int num : arr){
            int n = result.size();   
            for(int i=0;i<n;i++) {
                ArrayList<Integer> temp = new ArrayList<>(result.get(i));
                temp.add(num);
                result.add(temp);
            }
        }                     
        return result;
    }

    public static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++) {
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            permutation(first+ch+second,up.substring(1));
        }
    }

    public static int permutationCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);
        int count = 0 ;
        for(int i=0;i<=p.length();i++) {
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            count = count + permutationCount(first+ch+second,up.substring(1));
        }
        return count;
    }

    public static ArrayList<String> permutationList(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list= new ArrayList<String>();
            list.add(p);
            return list;
        }
        ArrayList<String> res = new ArrayList<>();
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            res.addAll( permutationList(first+ch+second,up.substring(1)))    ;
        }
        return res;
    }

    public static List<String> letterCombinations(String digits) {
        System.out.println("All combinations from manual mobile");
        return helper("",digits);
    }

    public static List<String> helper(String p, String up){
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");

        if(up.isEmpty()){
            List<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }

        List<String> res = new ArrayList<>();
        char ch = up.charAt(0);
        String letters = hm.get(ch);

        for(int i=0;i<letters.length();i++){
            res.addAll(helper(p+letters.charAt(i),up.substring(1)));
        }
        return res;
    }

    public static void dice(String p, int target){
        if(target==0){
            System.out.println(p);
            return;
        }
        for(int i=1;i<=6 && i<=target;i++){
            dice(p+i,target-i);
        }
    }

}
