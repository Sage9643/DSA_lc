class Solution {
    public String solveEquation(String equations) {
        int i=0;
        char sign=equations.charAt(0)=='-'?'-':'+';
        int rtX=0,rtSum=0;
        int ltX=0,ltSum=0;
        
        StringBuilder sb=new StringBuilder();

        while(equations.charAt(i)!='='){
            if(equations.charAt(i)=='+' || equations.charAt(i)=='-'){
                if(sb.length() > 0 && sb.charAt(sb.length()-1)=='x'){
                    if(sb.length()==1) ltX+=sign=='+'?1:-1;
                    else ltX+=sign=='+'? Integer.parseInt(sb.substring(0,sb.length()-1)):-Integer.parseInt(sb.substring(0,sb.length()-1));
                }
                else if((sb.length() > 0)) ltSum+=sign=='+'? Integer.parseInt(sb.toString()):-Integer.parseInt(sb.toString());

                sb.setLength(0);
                sign=equations.charAt(i);
            }else sb.append(equations.charAt(i));
            i++;
        }i++;
        if(sb.length() > 0 && sb.charAt(sb.length()-1)=='x'){
            if(sb.length()==1) ltX+=sign=='+'?1:-1;
            else ltX+=sign=='+'? Integer.parseInt(sb.substring(0,sb.length()-1)):-Integer.parseInt(sb.substring(0,sb.length()-1));
        }
        else if((sb.length() > 0)) ltSum+=sign=='+'? Integer.parseInt(sb.toString()):-Integer.parseInt(sb.toString());
        sb.setLength(0);

        sign=equations.charAt(i)=='-'?'-':'+';
        
        while(i!=equations.length()){
            if(equations.charAt(i)=='+' || equations.charAt(i)=='-'){
                if(sb.length() > 0 && sb.charAt(sb.length()-1)=='x'){
                    if(sb.length()==1) rtX+=sign=='+'?1:-1;
                    else rtX+=sign=='+'? Integer.parseInt(sb.substring(0,sb.length()-1)):-Integer.parseInt(sb.substring(0,sb.length()-1));
                }
                else if((sb.length() > 0)) rtSum+=sign=='+'? Integer.parseInt(sb.toString()):-Integer.parseInt(sb.toString());

                sb.setLength(0);
                sign=equations.charAt(i);
            }else sb.append(equations.charAt(i));
            i++;
        }
        if((sb.length() > 0) && sb.charAt(sb.length()-1)=='x'){
            if(sb.length()==1) rtX+=sign=='+'?1:-1;
            else rtX+=sign=='+'? Integer.parseInt(sb.substring(0,sb.length()-1)):-Integer.parseInt(sb.substring(0,sb.length()-1));
        }
        else if((sb.length() > 0)) rtSum+=sign=='+'? Integer.parseInt(sb.toString()):-Integer.parseInt(sb.toString());
        sb.setLength(0);

        int totX=ltX-rtX;
        int totSum=rtSum-ltSum;
        if(totX==0 && totSum==0) return "Infinite solutions";
        else if(totX==0 && totSum!=0) return "No solution";
        else {
            int res=totSum/totX;
            return "x="+ String.valueOf(res);
        }
    }
}