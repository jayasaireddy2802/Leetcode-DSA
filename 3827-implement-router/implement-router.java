// import java.util.*;

// class Router {
//     List<List<Integer>> list;
//     int size;

//     public Router(int memoryLimit) {
//         list = new ArrayList<>();
//         size = memoryLimit;
//     }
    
//     public boolean addPacket(int source, int destination, int timestamp) {
//         if (Collections.frequency(list, Arrays.asList(source, destination, timestamp)) >= 1)
//             return false;

//         if (list.size() == size)
//             list.remove(0);
        
//         list.add(Arrays.asList(source, destination, timestamp));
//         return true;
//     }
    
//     public int[] forwardPacket() {
//         if (list.isEmpty())
//             return new int[0];
        
//         List<Integer> l = list.remove(0);
//         return new int[]{ l.get(0), l.get(1), l.get(2) };
//     }
    
//     public int getCount(int destination, int startTime, int endTime) {
//         int ct = 0;
//         for (List<Integer> l : list) {
//             int dest = l.get(1);
//             int time = l.get(2);
//             if (dest == destination && time >= startTime && time <= endTime)
//                 ct++;
//         }
//         return ct;
//     }
// }


// import java.util.*;

// class Router {
//     List<List<Integer>> list;
//     Set<List<Integer>> set;
//     int size;

//     public Router(int memoryLimit) {
//         list = new ArrayList<>();
//         set = new HashSet<>();
//         size = memoryLimit;
//     }
    
//     public boolean addPacket(int source, int destination, int timestamp) {
//         List<Integer> l = Arrays.asList(source, destination, timestamp);
//         if(set.contains(l))
//             return false;

//         if (list.size() == size)
//             list.remove(0);
        
//         list.add(l);
//         set.add(l);
//         return true;
//     }
    
//     public int[] forwardPacket() {
//         if (list.isEmpty())
//             return new int[0];
        
//         List<Integer> l = list.remove(0);
//         set.remove(l);
//         return new int[]{ l.get(0), l.get(1), l.get(2) };
//     }
    
//     public int getCount(int destination, int startTime, int endTime) {
//         int ct = 0;
//         for (List<Integer> l : list) {
//             int dest = l.get(1);
//             int time = l.get(2);
//             if (dest == destination && time >= startTime && time <= endTime)
//                 ct++;
//         }
//         return ct;
//     }
// }



// import java.util.*;

// class Router {
//     List<List<Integer>> list;
//     Set<List<Integer>> set;
//     // destination -> (timestamp -> count)
//     Map<Integer, TreeMap<Integer, Integer>> map;
//     int size;

//     public Router(int memoryLimit) {
//         list = new ArrayList<>();
//         set = new HashSet<>();
//         map = new HashMap<>();
//         size = memoryLimit;
//     }
    
//     public boolean addPacket(int source, int destination, int timestamp) {
//         List<Integer> l = Arrays.asList(source, destination, timestamp);
//         if(set.contains(l))
//             return false;

//         if (list.size() == size)
//         {
//             List<Integer> removed = list.remove(0);
//             set.remove(removed);
//             int dest = removed.get(1);
//             int time = removed.get(2);
            
//             TreeMap<Integer, Integer> tm = map.get(dest);
//             tm.put(time, tm.get(time) - 1);
//             if(tm.get(time) == 0)
//                 tm.remove(time);
//             if(tm.isEmpty())
//                 map.remove(dest);

//         }
        
//         list.add(l);
//         set.add(l);
//         map.putIfAbsent(destination, new TreeMap<>());
//         Map<Integer, Integer> tm = map.get(destination);
//         tm.put(timestamp, tm.getOrDefault(timestamp, 0) + 1);
//         return true;
//     }
    
//     public int[] forwardPacket() {
//         if (list.isEmpty())
//             return new int[0];
        
//         List<Integer> l = list.remove(0);
//         set.remove(l);
//         int destination = l.get(1);
//         int timestamp = l.get(2);
//         Map<Integer, Integer> tm = map.get(destination);
//         tm.put(timestamp, tm.getOrDefault(timestamp, 0) - 1);
//         if(tm.get(timestamp) == 0)
//             tm.remove(timestamp);
//         if(tm.isEmpty())
//             map.remove(destination);

//         return new int[]{ l.get(0), l.get(1), l.get(2) };
//     }
    
//     public int getCount(int destination, int startTime, int endTime) {
//         int ct = 0;
//         if (!map.containsKey(destination)) return 0;

//         TreeMap<Integer, Integer> tm = map.get(destination);
//         NavigableMap<Integer, Integer> submap = tm.subMap(startTime, true, endTime, true);

//         for(int val : submap.values())
//             ct += val;

//         return ct;
//     }
// }




// import java.util.*;

// class Router {
//     Queue<List<Integer>> list;
//     Set<List<Integer>> set;
//     // destination -> (timestamp -> count)
//     Map<Integer, TreeMap<Integer, Integer>> map;
//     int size;

//     public Router(int memoryLimit) {
//         list = new ArrayDeque<>();
//         set = new HashSet<>();
//         map = new HashMap<>();
//         size = memoryLimit;
//     }
    
//     public boolean addPacket(int source, int destination, int timestamp) {
//         List<Integer> l = Arrays.asList(source, destination, timestamp);
//         if(set.contains(l))
//             return false;

//         if (list.size() == size)
//         {
//             List<Integer> removed = list.poll();
//             set.remove(removed);
//             int dest = removed.get(1);
//             int time = removed.get(2);
            
//             TreeMap<Integer, Integer> tm = map.get(dest);
//             tm.put(time, tm.get(time) - 1);
//             if(tm.get(time) == 0)
//                 tm.remove(time);
//             if(tm.isEmpty())
//                 map.remove(dest);

//         }
        
//         list.add(l);
//         set.add(l);
//         map.putIfAbsent(destination, new TreeMap<>());
//         Map<Integer, Integer> tm = map.get(destination);
//         tm.put(timestamp, tm.getOrDefault(timestamp, 0) + 1);
//         return true;
//     }
    
//     public int[] forwardPacket() {
//         if (list.isEmpty())
//             return new int[0];
        
//         List<Integer> l = list.poll();
//         set.remove(l);
//         int destination = l.get(1);
//         int timestamp = l.get(2);
//         Map<Integer, Integer> tm = map.get(destination);
//         tm.put(timestamp, tm.getOrDefault(timestamp, 0) - 1);
//         if(tm.get(timestamp) == 0)
//             tm.remove(timestamp);
//         if(tm.isEmpty())
//             map.remove(destination);

//         return new int[]{ l.get(0), l.get(1), l.get(2) };
//     }
    
//     public int getCount(int destination, int startTime, int endTime) {
//         int ct = 0;
//         if (!map.containsKey(destination)) return 0;

//         TreeMap<Integer, Integer> tm = map.get(destination);
//         NavigableMap<Integer, Integer> submap = tm.subMap(startTime, true, endTime, true);

//         for(int val : submap.values())
//             ct += val;

//         return ct;
//     }
// }

import java.util.*;

class Router {
    Queue<List<Integer>> list;                 // maintains insertion order
    Set<List<Integer>> set;                     // for duplicate detection
    Map<Integer, TreeMap<Integer, Integer>> prefixSumMap; // destination -> timestamp -> cumulative count
    int size;

    public Router(int memoryLimit) {
        list = new ArrayDeque<>();
        set = new HashSet<>();
        prefixSumMap = new HashMap<>();
        size = memoryLimit;
    }

    // Add a packet if it’s not a duplicate
    public boolean addPacket(int source, int destination, int timestamp) {
        List<Integer> packet = Arrays.asList(source, destination, timestamp);
        if (set.contains(packet))
            return false;

        // Evict oldest packet if memory limit reached
        if (list.size() == size) {
            List<Integer> removed = list.poll();
            set.remove(removed);
            int oldDest = removed.get(1);
            int oldTime = removed.get(2);

            // Decrement count in prefix sum map
            TreeMap<Integer, Integer> ps = prefixSumMap.get(oldDest);
            adjustPrefixSum(ps, oldTime, -1);
            if (ps.isEmpty())
                prefixSumMap.remove(oldDest);
        }

        // Add new packet
        list.offer(packet);
        set.add(packet);

        prefixSumMap.putIfAbsent(destination, new TreeMap<>());
        TreeMap<Integer, Integer> ps = prefixSumMap.get(destination);
        adjustPrefixSum(ps, timestamp, +1);

        return true;
    }

    // Forward the oldest packet
    public int[] forwardPacket() {
        if (list.isEmpty())
            return new int[0];

        List<Integer> packet = list.poll();
        set.remove(packet);

        int dest = packet.get(1);
        int time = packet.get(2);

        TreeMap<Integer, Integer> ps = prefixSumMap.get(dest);
        adjustPrefixSum(ps, time, -1);
        if (ps.isEmpty())
            prefixSumMap.remove(dest);

        return new int[]{ packet.get(0), dest, time };
    }

    // Count packets for a destination in [startTime, endTime] in O(log n)
    public int getCount(int destination, int startTime, int endTime) {
        if (!prefixSumMap.containsKey(destination))
            return 0;

        TreeMap<Integer, Integer> ps = prefixSumMap.get(destination);

        Map.Entry<Integer, Integer> endEntry = ps.floorEntry(endTime);
        Map.Entry<Integer, Integer> startEntry = ps.floorEntry(startTime - 1);

        int endCount = (endEntry != null) ? endEntry.getValue() : 0;
        int startCount = (startEntry != null) ? startEntry.getValue() : 0;

        return endCount - startCount;
    }

    // Helper: update prefix sums
    private void adjustPrefixSum(TreeMap<Integer, Integer> ps, int timestamp, int delta) {
        // Get previous cumulative count before timestamp
        Integer prevCount = ps.floorEntry(timestamp) != null ? ps.floorEntry(timestamp).getValue() : 0;
        int newCount = prevCount + delta;

        // Update timestamp
        ps.put(timestamp, newCount);

        // Update all higher timestamps
        Map<Integer, Integer> tail = ps.tailMap(timestamp, false);
        for (Map.Entry<Integer, Integer> e : tail.entrySet()) {
            e.setValue(e.getValue() + delta);
        }

        // Clean up if cumulative count becomes zero
        if (ps.get(timestamp) == 0)
            ps.remove(timestamp);
    }
}
