package src;

import java.util.Arrays;

public class StringPermutation {
    //permute string in such a way that ab in abc is not together
    public void permute(String str){
        char[] s=str.trim().toCharArray();
        permute(s, 0, str.length()-1);
    }
    private void permute(char[] s, int l, int r) {
        if (l==r){
            System.out.println(s);
            return;
        }else {
            for(int i=l;i<=r;i++){
                if (isSafe(s,l,i,r)) {
                    swap(s, l, i);
                    permute(s, l + 1, r);
                    swap(s, l, i);
                }
            }
        }
    }

    private boolean isSafe(char[] s, int l, int i, int r) {
        if (l!=0 && s[l-1]=='A' && s[i]=='B')
            return false;
        if (r==l+1 && s[i]=='A' && s[l]=='B')
            return false;

        return true;
    }

    private void swap(char[] s, int i, int j) {
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }

    public static void main(String[] args) {
        StringPermutation permutation=new StringPermutation();
        permutation.permute("ABC");
    }
}
