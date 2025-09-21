class MovieRentingSystem {

    // movie -> {price, shop}
    Map<Integer, TreeSet<int[]>> unrented;

    //price - shop - movie
    TreeSet<int[]> rented;

    // movie -> {shop -> price}
    Map<Integer, Map<Integer, Integer>> getPrice;

    public MovieRentingSystem(int n, int[][] entries) {
        getPrice = new HashMap<>();
        unrented = new HashMap<>();
        rented = new TreeSet<>((a, b) -> a[0] == b[0] ? (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]) : a[0] - b[0]);
        for(int[] entry : entries)
        {
            int shop = entry[0];
            int movie = entry[1];
            int price = entry[2];

            getPrice.computeIfAbsent(movie, k -> new HashMap<>()).put(shop, price);
            unrented.computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0])).add(new int[]{price, shop});
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        int ct = 0;
        if(!unrented.containsKey(movie))
            return result;

        for(int[] arr : unrented.get(movie))
        {
            result.add(arr[1]);
            ct++;
            if(ct >= 5)
                break;
        }

        return result;
    }
    
    public void rent(int shop, int movie) {
        int price = getPrice.get(movie).get(shop);
        rented.add(new int[]{price, shop, movie});
        unrented.get(movie).remove(new int[]{price, shop});
        
    }
    
    public void drop(int shop, int movie) {
        int price = getPrice.get(movie).get(shop);
        unrented.get(movie).add(new int[]{price, shop});
        rented.remove(new int[]{price, shop, movie});
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int ct = 0;

        for(int[] arr : rented)
        {
            result.add(Arrays.asList(arr[1], arr[2]));
            ct++;
            if(ct >= 5)
                break;
        }

        return result;

    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */