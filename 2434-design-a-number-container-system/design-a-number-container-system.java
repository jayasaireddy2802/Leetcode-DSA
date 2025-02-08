// class NumberContainers {

//     Map<Integer, Integer> map;
//     public NumberContainers() {
//         map = new HashMap<>();
//     }
    
//     public void change(int index, int number) {
//         map.put(index, number);

//     }
    
//     public int find(int number) {
//         long idx = (long)1e10;
//         for(int x : map.keySet())
//         {
//             if(number == map.get(x)){
//                 idx = Math.min(idx, x);
//             }
//         }
//         if(idx == (long)1e10)
//             return -1;
//         return (int)idx;
//     }
// }



class NumberContainers {

    Map<Integer, Integer> numbermap;
    Map<Integer, TreeSet<Integer>> indexmap;
    public NumberContainers() {
        numbermap = new HashMap<>();
        indexmap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(!numbermap.containsKey(index))
        {
            numbermap.put(index, number);
        }
        else
        {
            int prev_num = numbermap.get(index);
            numbermap.put(index, number);

            indexmap.get(prev_num).remove(index);
        }

        if(indexmap.containsKey(number))
        {
            indexmap.get(number).add(index);
        }
        else
        {
            indexmap.put(number, new TreeSet<>());
            indexmap.get(number).add(index);
        }

    }
    
    public int find(int number) {
       
        if(indexmap.containsKey(number) && !indexmap.get(number).isEmpty())
        {
            return  indexmap.get(number).first();
        }
        
        return -1;
        
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */