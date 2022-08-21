package com.life.algorithm;

public class LeetCode1455 {

    public static int isPrefixOfWord(String sentence, String searchWord) {

        String[] split = sentence.split(" ");
        int index,ans=-1;
        for (int i = 0; i <= split.length - 1; i++) {
            index = split[i].indexOf(searchWord);
            if(index ==0){
                ans = i+1;
                return ans;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        String sentence = "i love eating burger";

        String searchText = "eat";

        System.out.println(isPrefixOfWord(sentence, searchText));

    }






}
