import java.util.*;
public class threesum {
    //similar to the foursum
  //brute force solution was 
//in here target=0;
  public List<List<Integer>> three(int[]nums){
    
    List<List<Integer>> ans=new LinkedList<>();
    
    int n=nums.length;
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            for(int k=j+1;k<n;k++){
                
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> temp= Arrays.asList(nums[i],nums[j],nums[k]);
                    Collections.sort(temp);
                    
                if(!ans.contains(temp)){
                    ans.add(temp);


                }

                }

                

            }
        }

    }
    return ans;
    

  }
  //better solution was similarly following the foursum approach
  public List<List<Integer>> threes(int[]arr){
    int target=0;
    int n=arr.length;
    Set<List<Integer>> st=new HashSet<>();
    for(int i=0;i<n;i++){
        Set<Long> hashset=new HashSet<>();
        for(int j=i+1;j<n;j++){
            long sum=arr[i]+arr[j];
            long third=(long)target-sum;
            if(hashset.contains(third)){
                List<Integer> temp=new LinkedList<>();
                temp.add(arr[i]);
                temp.add(arr[j]);
                temp.add((int)third);
                Collections.sort(temp);
                st.add(temp);
            }
            hashset.add((long)third);
 
        }
    }
    List<List<Integer>> ans=new LinkedList<>(st);
    return ans;

  }
    
}
