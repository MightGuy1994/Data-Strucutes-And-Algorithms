class ValidParathesis {
    public boolean isValid(String s) {

        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)) {
                if(!stack.isEmpty() && map.get(ch) == stack.peek()) {
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else {
                stack.push(ch);
            }
        }
        return (stack.isEmpty())?true : false;

    }
}

// use stack. after compelete iteration it should be empty. whenever you find a closing bracket and see the corresponding
// open bracket at top of stack pop it else return false