package com.ps.array;

public class XorOperation {
    
    
    public int xorOperation(int n, int start) {

        int rst = start ;

        for (int i = 1 ; i< n; i++) {
            rst = rst ^ (start + 2*i);
        }
        return rst;   
    }
}
