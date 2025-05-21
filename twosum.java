//given an target element if you find the sum of the that two numbers which it will give the target
//then return yes or else return the indices
import java.util.*;
//brute force solution
public class twosum{
    public int[] having(int[]arr,int target){
        int n=arr.length;
        int[]ans=new int[2];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target){
                    ans[0]=i;
                    ans[1]=j;

                }
            }
        }
        return ans;

    }
   
    public int[] check(int[]arr,int target){
        int n=arr.length;
        int[]ans=new int[2];
        HashMap<Integer,Integer> mp=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            int value=target-arr[i];
            if(mp.containsKey(value)){
                arr[0]=mp.get(value);
                arr[1]=i;

            }
            else{
                mp.put(arr[i],i);
            }

        } 
        return ans;
} 
    //optimal solution 
    /*
     using two pointer approach that by keeping two pointers one is at low and another is at high
     if(arr[low]+arr[high])<target increment low else decrement right 
     */
    public int[] twosumof(int[]arr,int target){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int[]ans=new int[2];
        while(low<high){
            if(arr[low]+arr[high]==target){
                ans[0]=low;
                ans[1]=high;
            }
            else if(arr[low]+arr[high]>target){
                high--;
            }
            else{
                low++;
            }
        }
        return ans;
    }

}