class Solution {
    public String simplifyPath(String path) {
        String directories[]=path.split("/+");//removes slashes from path and will store all directory names
        Deque<String> deque=new LinkedList<>();//obtaing the abspath

        for(int i=0;i<directories.length;i++){
            if(directories[i].equals("..") && !deque.isEmpty()){//removes previous directory if stack not empty
                deque.removeLast();
            }else if(directories[i].equals(".") || directories[i].equals("..")){
                continue;//if deque empty but still .. occurs then ignore them
            }
            else{
                deque.addLast(directories[i]);
            }
        }
        StringBuilder absPath=new StringBuilder();
        while(!deque.isEmpty()){
            if(!deque.getFirst().equals("")){
                absPath.append("/");
                absPath.append(deque.removeFirst());
            }else{deque.removeFirst();}
            
        }return absPath.length()==0 ? "/" : absPath.toString();


    }
}