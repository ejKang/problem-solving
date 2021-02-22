package com.ps.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KidsWithCandies {
    
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        // get maximum value 
        int max = Arrays.stream(candies).max().getAsInt();

        return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= max).collect(Collectors.toList());

    }

}
