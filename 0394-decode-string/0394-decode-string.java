class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder curr = new StringBuilder();
                StringBuilder nums = new StringBuilder();
                StringBuilder output = new StringBuilder();

                // ✅ Collect string between brackets in correct order
                while (!stack.peek().equals("[")) {
                    curr.insert(0, stack.pop()); // instead of reverse
                }

                stack.pop(); // remove '['

                // collect number
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    nums.insert(0, stack.pop());
                }

                int num = Integer.parseInt(nums.toString());

                for (int j = 0; j < num; j++) {
                    output.append(curr);
                }

                stack.push(output.toString());
            } else {
                stack.push(Character.toString(s.charAt(i)));
            }
        }

        // Build final decoded string
        StringBuilder decode = new StringBuilder();
        while (!stack.isEmpty()) {
            decode.insert(0, stack.pop());
        }

        return decode.toString();
    }
}
