package com.ps.sort;

public class SalaryMaxMin {
    public static void main(String[] args) {
        int[] salary = {300,400,500,700};
        System.out.println(SalaryMaxMin.average(salary));
    }

    public static double average(int[] salary) {
        int min = salary[0], max = salary[0], sum =0;
        
        for (int i : salary) {
            min = Math.min(i, min);
            max = Math.max(i, max);
            
            sum += i;
        }
        
        return (double)( sum - min - max) / ( salary.length -2 );
    }
}
