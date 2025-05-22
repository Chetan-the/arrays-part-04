import java.util.*;
public class subarraywithxork {
    //brute force solution was generate the all sub arrays and find the answer
    public int subarray(int[]arr,int k){
        int n=arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int xor=0;
            for(int j=i;j<n;j++){
                xor=xor^arr[j];
                if(xor==k){
                    cnt++;

                }
            }

        }
        return cnt;
    }
    //better solution was by using hashing
    public int subarrayxork(int[]arr,int k){
        int n=arr.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        int xor=0;
        int cnt=0;
        mp.put(0,1);
        for(int i=0;i<n;i++){
            xor=xor^arr[i];
            int x=xor^k;
            if(mp.containsKey(x)){
                cnt+=mp.get(x);

            }
            if(mp.containsKey(xor)){
                mp.put(xor,mp.get(xor)+1);
            }
            else{
                mp.put(xor,1);
            }

        }
        return cnt;
    }
    
}
