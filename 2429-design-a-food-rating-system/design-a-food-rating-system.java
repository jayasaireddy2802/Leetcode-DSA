// class FoodRatings {
//     Map<String, List<String>> cuisineMap;
//     Map<String, Integer> foodToIndex;
//     int[] ratingArray;

//     public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
//         int n = ratings.length;
//         cuisineMap = new HashMap<>();
//         foodToIndex = new HashMap<>();
//         ratingArray = new int[n];

//         for(String cuisine : cuisines)
//         {
//             cuisineMap.put(cuisine, new ArrayList<>());
//         }

//         for(int i = 0; i < n; i++)
//         {
//             String cuisine = cuisines[i];
//             List<String> list = cuisineMap.get(cuisine);
//             list.add(foods[i]);
//             cuisineMap.put(cuisine, list);
//         }

//         int j = 0;
//         for(String food : foods)
//         {
//             foodToIndex.put(food, j);
//             j++;
//         }

//         for(int i = 0; i < n; i++)
//         {
//             int idx = foodToIndex.get(foods[i]);
//             ratingArray[idx] = ratings[i];
//         }
//     }
    
//     public void changeRating(String food, int newRating) {
//         int idx = foodToIndex.get(food);
//         ratingArray[idx] = newRating;
//     }
    
//     public String highestRated(String cuisine) {
//         int max = 0;
//         String ans = "";
//         List<String> foods = cuisineMap.get(cuisine);
//         for(String food : foods)
//         {
//             int idx = foodToIndex.get(food);
//             if(ratingArray[idx] >= max)
//             {
//                 if(ratingArray[idx] == max)
//                 {
//                     int value = ans.compareTo(food);
//                     if(value > 0)
//                         ans = food;
//                 }

//                 else
//                 {
//                     ans = food;
//                     max = ratingArray[idx];
//                 }
//             }
//         }

//         return ans;
//     }
// } 


/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */

// class Pair
// {
//     String food;
//     int rating;

//     public Pair(String food, int rating)
//     {
//         this.food = food;
//         this.rating = rating;
//     }
// }

//  class FoodRatings {
//     Map<String, List<Pair>> cuisineMap;
//     Map<String, Pair> foodsMap;

//     public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
//         int n = ratings.length;
//         cuisineMap = new HashMap<>();
//         foodsMap = new HashMap<>();

//         for(String cuisine : cuisines)
//         {
//             cuisineMap.put(cuisine, new ArrayList<>());
//         }

//         for(int i = 0; i < n; i++)
//         {
//             String cuisine = cuisines[i];
//             List<Pair> list = cuisineMap.get(cuisine);
//             Pair food = new Pair(foods[i], ratings[i]);
//             list.add(food);
//             cuisineMap.put(cuisine, list);
//             foodsMap.put(foods[i], food);
//         }
//     }
    
//     public void changeRating(String food, int newRating) {
//         Pair p = foodsMap.get(food);
//         p.rating = newRating;
//     }
    
//     public String highestRated(String cuisine) {
//         int max = 0;
//         String ans = "";
//         List<Pair> foods = cuisineMap.get(cuisine);
//         for(Pair pair : foods)
//         {
//             int rating = pair.rating;
//             if(rating >= max)
//             {
//                 if(rating == max)
//                 {
//                     int value = ans.compareTo(pair.food);
//                     if(value > 0)
//                         ans = pair.food;
//                 }

//                 else
//                 {
//                     ans = pair.food;
//                     max = rating;
//                 }
//             }
//         }

//         return ans;
//     }
// } 

class Pair
{
    String food;
    int rating;

    public Pair(String food, int rating)
    {
        this.food = food;
        this.rating = rating;
    }
}

 class FoodRatings {
    Map<String, PriorityQueue<Pair>> cuisineMap;
    Map<String, Pair> foodsMap;
    Map<String, String> foodCuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = ratings.length;
        cuisineMap = new HashMap<>();
        foodsMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();

        for(String cuisine : cuisines)
        {
            cuisineMap.put(cuisine, new PriorityQueue<>((a, b) -> a.rating == b.rating ? a.food.compareTo(b.food) : b.rating - a.rating));
        }

        for(int i = 0; i < n; i++)
        {
            String cuisine = cuisines[i];
            PriorityQueue<Pair> pq = cuisineMap.get(cuisine);
            Pair food = new Pair(foods[i], ratings[i]);
            pq.add(food);
            cuisineMap.put(cuisine, pq);
            foodsMap.put(foods[i], food);
            foodCuisineMap.put(foods[i], cuisine);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Pair p = new Pair(food, newRating);
        String cuisine = foodCuisineMap.get(food);
        PriorityQueue<Pair> pq = cuisineMap.get(cuisine);
        pq.add(p);
        cuisineMap.put(cuisine, pq);
        foodsMap.put(food, p);
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Pair> pq = cuisineMap.get(cuisine);
        while(true)
        {
            Pair top = pq.peek();
            Pair latest = foodsMap.get(top.food);

            if(top == latest)
                return top.food;
            pq.poll();
        }
    }
} 

