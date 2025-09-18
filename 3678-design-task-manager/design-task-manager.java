class TaskManager {
    PriorityQueue<int[]> pq;
    Map<Integer, Integer> taskPriorityMap;
    Map<Integer, Integer> taskUserMap;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        taskPriorityMap = new HashMap<>();
        taskUserMap = new HashMap<>();

        for(List<Integer> task : tasks)
        {
            int priority = task.get(2);
            int taskId = task.get(1);
            int user = task.get(0);
            pq.add(new int[]{priority, taskId});
            taskPriorityMap.put(taskId, priority);
            taskUserMap.put(taskId, user);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        pq.add(new int[]{priority, taskId});
        taskPriorityMap.put(taskId, priority);
        taskUserMap.put(taskId, userId);
    }
    
    public void edit(int taskId, int newPriority) {
        taskPriorityMap.put(taskId, newPriority);
        pq.add(new int[]{newPriority, taskId});
    }
    
    public void rmv(int taskId) {
        taskPriorityMap.remove(taskId);
        taskUserMap.remove(taskId);
    }
    
    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll(); 
            int priority = top[0];
            int taskId = top[1];

            if (taskPriorityMap.containsKey(taskId) && taskPriorityMap.get(taskId) == priority) {
                int userId = taskUserMap.get(taskId);
                
                taskPriorityMap.remove(taskId);
                taskUserMap.remove(taskId);
                return userId;
            }
        }
        return -1;
    
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */