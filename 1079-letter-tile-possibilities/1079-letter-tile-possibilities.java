class Solution {
    public int numTilePossibilities(String tiles) {
        int[]freq=new int[26];

        for(char ch:tiles.toCharArray()){
            freq[ch-'A']++;
        }
        return backtracking(freq);
        
    
    }
    private int backtracking(int[] freq){
        int count=0;

        for(int i=0;i<26;i++){

            // if letter available
            if(freq[i]>0){

                // choose
                freq[i]--;

                // ek sequence ban gya
                count++;

                // explore further
                count=count+backtracking(freq);

                // undo
                freq[i]++;
            }
        }

        return count;
    }
}