class Robot {
    List<int[]> list;
    int idx;
    boolean moved;

    public Robot(int width, int height) {
        list = new ArrayList<>();
        idx = 0;

        // 1. "North", 2. "East", 3. "South", 4. "West".


        // from left to right(East)
        for(int i = 0; i < width; i++)
        {
            list.add(new int[]{i, 0, 2});
        }

        // from bottom to up(North)
        for(int i = 1; i < height; i++)
        {
            list.add(new int[]{width - 1, i, 1});
        }

        // left to right (West)
        for(int i = width - 2; i >= 0; i--)
        {
            list.add(new int[]{i, height - 1, 4});
        }

        // up to bottom (South)
        for(int i = height - 2; i >= 1; i--)
        {
            list.add(new int[]{0, i, 3});
        }
    }
    
    public void step(int num) {
        idx = (idx + num) % list.size();
        if(num > 0) moved = true;
    }
    
    public int[] getPos() {
        return new int[]{list.get(idx)[0], list.get(idx)[1]};
    }
    
    public String getDir() {

        if(idx == 0 && moved) return "South";

        int dir = list.get(idx)[2];
        if(dir == 1) return "North";
        else if(dir == 2) return "East";
        else if(dir == 3) return "South";
        else return "West";
        
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */