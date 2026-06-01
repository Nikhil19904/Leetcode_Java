class Solution {
    public int countSubstrings(String s) {

        int n=s.length();
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                if(isPalindrome(s,i,j)){
                    count++;
                }
            }
        }

        return count;
        
    }

    private boolean isPalindrome(String s,int i,int j){

        // base case
        if(i>=j){
            return true;
        }

        // characters don't match
        if(s.charAt(i)!=s.charAt(j)){
            return false;
        }

        // check inner substring
        return isPalindrome(s,i+1,j-1);
    }
}