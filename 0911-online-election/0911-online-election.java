class TopVotedCandidate {
    int winners[];
    int times[];
    public TopVotedCandidate(int[] persons, int[] times) {
        this.winners=new int[times.length];
        this.times=times;

        int winner=-1;
        int maxVotes=0;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<persons.length;i++){
            map.put(persons[i],map.getOrDefault(persons[i],0)+1);

            if(maxVotes<=map.get(persons[i])){
                maxVotes=map.get(persons[i]);
                winner=persons[i];
            } winners[i]=winner;
        }


    }
    public int q(int t){
        int start=0;int end=times.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(t>=times[mid]){
                start=mid+1;
            }else end=mid-1;
        }
        return winners[end];
        
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */