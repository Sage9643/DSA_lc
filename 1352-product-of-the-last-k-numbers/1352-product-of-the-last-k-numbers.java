class ProductOfNumbers {
    static ArrayList<Integer> prod;
    static int zero;
    static int idx;

    public ProductOfNumbers() {
        prod=new ArrayList<>();
        zero=-1;idx=0;
    }
    
    public void add(int num) {
        if(num==0) zero=idx;
        if(prod.size()==0) prod.add(num);
        else {
            if(prod.get(prod.size()-1)==0) prod.add(num);
            else prod.add(prod.get(prod.size()-1)*num);
        }idx++;
    }
    public int getProduct(int k) {
        int startidx=prod.size()-k;
        if(startidx<=zero) return 0;
        else if(k==prod.size() || prod.get(startidx-1)==0) return prod.get(prod.size()-1);
        return prod.get(prod.size()-1)/prod.get(prod.size()-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */