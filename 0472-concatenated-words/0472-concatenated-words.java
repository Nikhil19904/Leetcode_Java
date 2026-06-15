import java.util.*;

class Solution {

    class TrieNode {

        TrieNode[] child = new TrieNode[26];
        boolean isEnd = false;
    }


    TrieNode root = new TrieNode();


    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> ans = new ArrayList<>();


        // insert all words
        for(String word : words){
            insert(word);
        }


        // check every word
        for(String word : words){

            boolean[] dp = new boolean[word.length()+1];

            if(canBreak(word,0,dp,0)){
                ans.add(word);
            }
        }


        return ans;
    }



    void insert(String word){

        TrieNode node = root;


        for(char c : word.toCharArray()){

            int idx = c-'a';


            if(node.child[idx]==null){
                node.child[idx] = new TrieNode();
            }


            node = node.child[idx];
        }


        node.isEnd = true;
    }





    boolean canBreak(String word, int start, boolean[] dp, int count){

        if(start == word.length()){

            // at least 2 words required
            return count >= 2;
        }


        if(dp[start]){
            return false;
        }


        TrieNode node = root;



        for(int i=start;i<word.length();i++){


            int idx = word.charAt(i)-'a';


            if(node.child[idx]==null){
                break;
            }


            node = node.child[idx];



            if(node.isEnd){


                if(canBreak(word,i+1,dp,count+1)){
                    return true;
                }

            }

        }


        dp[start]=true;

        return false;
    }
}