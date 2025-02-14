// class ProductOfNumbers {

//     List<Integer> list;

//     public ProductOfNumbers() {
//         list = new ArrayList<>();
//     }
    
//     public void add(int num) {
//         list.add(num);
//     }
    
//     public int getProduct(int k) {
//         int size = list.size() - 1;
//         int res = 1;
//         for(int i = 0; i < k; i++)
//         {
//             res = res * list.get(size - i);
//         }
//         return res;
//     }
// }

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

 class ProductOfNumbers {

    
    List<Integer> prefix;
    int size;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        size = 0;
    }
    
    public void add(int num) {
        if(num == 0)
        {
            prefix.clear();
            size = 0;
        }
        else
        {
            if(size > 0)
                prefix.add(prefix.get(size - 1) * num);
            else
                prefix.add(num);
            size++;
        }
    }
    
    public int getProduct(int k) {
        if(k > size)   
            return 0;
        else if(k == size)
            return prefix.get(size - 1);
        int num1 = prefix.get(size - 1);
        int num2 = prefix.get(size - k - 1);
        return num1 / num2;
       
    }
}