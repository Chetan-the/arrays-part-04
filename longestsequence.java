import java.util.*;
public class longestsequence {
    //given an array we have to find the longest consecutive numbers in an array
    //Brute force solution was
    //take an elemnt and check the whole array if find increment by 1
    public boolean ls(int[]arr,int value){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==value){
                return true;
            }
        }
        return false;
    }
    public int consecutive(int[]arr){
        int n=arr.length;
        int longest=1;
        for(int i=0;i<n;i++){
            int x=arr[i];
            int cnt=1;
            while(ls(arr,x+1)==true){
                x=x+1;
                cnt=cnt+1;
            }
           longest=Math.max(cnt,longest);
             
        }
        return longest;
       
       
        
    }

    //better solution was after doing sort and check with the help of last element 
    public int longestconseq(int[]arr){
        int n=arr.length;
        int lastelement=Integer.MIN_VALUE;
        int cnt=0;
        int longest=1;
        for(int i=0;i<n;i++){
            if(arr[i]-1==lastelement){
                cnt+=1;
                lastelement=arr[i];
            }
            else if(arr[i]!=lastelement){
                cnt=1;
                lastelement=arr[i];
            }
            longest=Math.max(longest,cnt);
        }
        return longest;
        
    }
    //optimal solution was using hashset
    public int longseq(int[]arr){
        int n=arr.length;
        int longest=1;
        Set<Integer> st=new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(arr[i]);
        }
        for(int it:st){
            if(!st.contains(it-1)){
                int cnt=1;
                int x=it;
                while(st.contains(x+1)){
                    x=x+1;
                    cnt+=1;

                }
                longest=Math.max(longest,cnt);
                
            }
           
        }
         return longest;
    }
    //better solution was by using hashing 
    public int longsub(int[]arr,int k){
        int n=arr.length;
        int sum=0;
        int maxlen=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==k){
                maxlen=Math.max(maxlen,i+1);
            }
            int rem=sum-k;
            if(mp.containsKey(rem)){
                int len=i-mp.get(rem);
                maxlen=Math.max(len,maxlen);
            }
            if(!mp.containsKey(sum)){
                mp.put(sum,i);

            };
        }
        return maxlen;
    }
}
