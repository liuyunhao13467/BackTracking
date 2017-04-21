package com.lyh;

import java.util.ArrayList;

public class Permutation_Sequence {
    public String getPermutation(int n, int k) {
    	ArrayList<Integer> list = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int factorial = 1;
        for(int i = 2; i <= n - 1; i ++)
            factorial *= i;
        for(int i = 1; i <= n; i ++)
            list.add(i);
        k --;
        int round = n - 1;
        while(round >= 0) {
            int num = list.get(k / factorial);
            sb.append(num);
            list.remove(k / factorial);
            if(round > 0) {
                k = k % factorial;
                factorial /= round;
            }
            round --;
        }
        return sb.toString();
    }
}
