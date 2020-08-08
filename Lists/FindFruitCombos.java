public class FindFruitCombos{
    public int winPrizes(String[][] codeList,String[] shoppingCart){
        //coroner cases
        if(codeList==null || codeList.length==0)
            return 1;
        if(shoppingCart==null || shoppingCart.length==0)
            return 0;

        // logic two pointer i,j: i represents each list in codeList and j represents each fruit in shoppingCart.
        // at a given time compare a List in codeList with with the shoppingCart to find whether it is a sublist of shopping cart
        int i=0, j=0;
        while(i<codeList.length && j+codeList[i]<=shoppingCart.length){
            boolean match = true;
            for(int k = 0; k<codeList[i].length; k++){
                if(!codeList[i][k].equals("anything") && !codeList[i][k].equals(shoppingCart[j+k])){
                    match = false;
                    break;
                }
            }
            if(match){
                j+=codeList[i].length;
                i++;
            }
            else {
                j++;
            }
        }
        if(i == codeList.length)?1:0;
    }
}
TimeComplexity: O(nk) where n is the length of shopping cart and k is the length of largest list in codeList;
SpaceComplexity : O(1)