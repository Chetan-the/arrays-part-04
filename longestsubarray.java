public class longestsubarray {
    //give an array we have to find the longest sub array with sum k 
    //return the longest among all of the sub arrays
    /*
     Brute force soln was generate the all the sub arrays among them find the max sub array and return the answer

     */
    public int longsubarra(int[]arr,int k){
        int  n=arr.length;
        int len=0;
       
        for(int i=0;i<n;i++){
             int sum=0;
            for(int j=i+1;j<n;j++){
                sum+=arr[j];
                if(sum==k){
                    len=Math.max(len,j-i+1);
                }


            }
        }
        return len;

    }
    
}
