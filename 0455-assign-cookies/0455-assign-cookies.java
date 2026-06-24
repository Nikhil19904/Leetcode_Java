class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // step-1 : sort greed factors
        Arrays.sort(g);

        // sort cookies
        Arrays.sort(s);

        int i=0;
        int j=0;

        int count=0;

        while(i<g.length && j<s.length){
            if(s[j]>=g[i]){

                count++; // child satisfied
                i++; // next child
                j++; //next cookie
            }
            else{
                j++;
            }
        }

        return count;
    }
}