package org.example


/**
 * You have given an array A which contains only a,e,i,o,u (only vowels) and it contains duplicates also.
 *
 * Question is to find out the subsequence
 * a. which should contain all vowels
 * b. which should have vowels in non-decreasing order
 * c. which should be the max. length
 *
 * a a a e e e e a a a i i o o o a a u
 *
 * a a e e i e i i i i i o u
 * 1 2 3 4 5 5 6 7 8 9 10 11 12
 *
 * aeiou
 *
 * eeeaeiou
 * 00012345
 *
 * a a a e e e e i i o o o u
 *
 * i
 * pick-i, i+1
 * don't pick-i, i+1
 *
 * sliding window
 * untill we find all characters - expand
 * window keep till this condition is met not met - expand
 * if the condition is not met - shrink
 *
 * dynamic programming
 *
 */

fun main() {

    //a a e e i e i i i i i o u
    val input = "aaeeieiiiiiou"
    val mp = HashMap<Char, Int>()
    val dp = IntArray(input.length)

    val firstA = -1;
    for (i = 0; i < input.length; i++) {
        if (c == 'a') {
            firstA = i;
        }
    }

    if (firstA == -1) {
        return -1;
    }

    for(int i=0; i < firstA ;i++) {
        dp[i] = 0;
    }

    dp[firstA] = 1
    mp.put('a', firstA);

    for(int i=firstA+1;i< input.length; i++) {
        char c = input.charAt(i);
        if (c == 'a') {
            val indx = mp.getOrDefault('a', -1)
            if (indx != -1) {
                dp[i] = dp[inx] +1;
            }
        } else if (c == 'e') {
            val indxA = mp.getOrDefault('a', -1)
            val indxe = mp.getOrDefault('e', -1)
            int val = 0;
            if (indxA != -1) {
                val = dp[indA]
            }
            int val2
            if (indxe != -1) {
                val2 = dp[indxe]
            }
            dp[i] = Math.max(val, val2) +1;
        }
    }

}
