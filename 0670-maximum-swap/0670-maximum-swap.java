class Solution {
    public int maximumSwap(int num) {
        char[]arr=String.valueOf(num).toCharArray();

        int[] last=new int[10];

        for(int i=0;i<arr.length;i++){
            last[arr[i]-'0']=i;
        }


        // left to right check
        for(int i = 0; i < arr.length; i++){


            int current = arr[i]-'0';


            // bigger digit search
            for(int d = 9; d > current; d--){


                if(last[d] > i){


                    // swap

                    char temp = arr[i];

                    arr[i] = arr[last[d]];

                    arr[last[d]] = temp;


                    return Integer.parseInt(new String(arr));
                }
            }
        }


        return num;
    }
}