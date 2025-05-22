import java.util.*;
public class substring {
    //we can give longest substring with out repeating characters
    //brute force soln was by generating all the sub arrays and check and return the answer
    public int substr(String word){
        int n=word.length();
        if(n==0){
            return 0;
        }

        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            Set<Character> st=new HashSet<>();
            for(int j=i;j<n;j++){
                if(st.contains(word.charAt(j))){
                    ans=Math.max(ans,j-i+1);
                    break;
                }
                else{
                    st.add(word.charAt(j));
                }
                
            }


        }
        return ans;
        //tc-o(n^2) and sc-o(n) using set data structure

    }
    //better solution was using two pointer approach
    public int substrwithout(String word){
        int n=word.length();
        Set<Character> st=new HashSet<>();
        int left=0;
        int right=0;
        int len=0;
        while(right<n){
            char w=word.charAt(right);
            while(st.contains(w)){
                st.remove(word.charAt(left));
                left++;
                
            }
            st.add(w);
            int l=right-left+1;
            len=Math.max(len,l);
            right++;
        }
        return len;
    }
    
}
