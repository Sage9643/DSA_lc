class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] n1=num1.split("\\+");
        int a=Integer.parseInt(n1[0]);
        int b=Integer.parseInt(n1[1].replace("i", ""));

        String[] n2=num2.split("\\+");
        int c=Integer.parseInt(n2[0]);
        int d=Integer.parseInt(n2[1].replace("i", ""));
        
        int real=a*c-b*d;
        int imag=a*d+b*c;
        
        return real + "+" + imag + "i";
    }
}