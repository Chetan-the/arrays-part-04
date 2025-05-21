import java.util.*;
public class Foursum {
    //brute force solution was by using  the four loops and adding the terms if found add it to the answer
    public List<List<Integer>> findsum(int[]arr,int target){
        int n=arr.length;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){
                        long sum=(long) arr[i]+arr[j]+arr[k]+arr[l];
                        if(sum==target){
                            List<Integer> temp=Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        Collections.sort(temp);
                        if(!ans.contains(temp)){
                            ans.add(temp);
                        }

                        }
                        
                    }
                }
            }
            
        }
        return ans;

    }
    //better solution was 
   public List<List<Integer>> four(int[]nums,int target){
    int n=nums.length;
    Set<List<Integer>> st=new HashSet<>();
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            Set<Long> hashset=new HashSet<>();
            for(int k=j+1;k<n;k++){
                int sum=nums[i]+nums[j];
                sum+=nums[k];
                int  fourth=target-sum;
                if(hashset.contains(fourth)){
                    List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k]);
                    temp.add(fourth);
                    Collections.sort(temp);
                    st.add(temp);
                    

                }
                hashset.add((long)nums[k]);


            }

        }
    }
    List<List<Integer>> ans=new LinkedList<>(st);
    return ans;


   }
}
