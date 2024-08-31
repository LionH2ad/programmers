class Solution {
    boolean solution(String s) {
        int countOpen = 0;
        int countClose = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                countOpen++;
            } else if(s.charAt(i) == ')'){
                countClose++;
            }
            if(countOpen < countClose){
                return false;
            }
        }
        if (countOpen == countClose){
            return true;
        }

        return false;
    }
}