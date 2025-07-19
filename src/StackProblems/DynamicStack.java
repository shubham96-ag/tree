package StackProblems;

import java.util.Arrays;

public class DynamicStack extends CustomStack{
    @Override
    public boolean push(int n) throws StackException {
        if(isFull()){
            int [] data2 = new int[data.length*2] ;
            int j = 0;
            for(int i : data){
                data2[j++] = i;
            }
         }
        return super.push(n);
    }
}
