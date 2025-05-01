class Solution {

    public int maxTaskAssign(
        int[] taskDifficulties,
        int[] workerStrengths,
        int pillsAvailable,
        int pillStrengthBoost
    ) {
        Arrays.sort(taskDifficulties);
        Arrays.sort(workerStrengths);
        int totalTasks = taskDifficulties.length;
        int totalWorkers = workerStrengths.length;
        int low = 1, high = Math.min(totalWorkers, totalTasks), maxTasks = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canAssign(taskDifficulties, workerStrengths, pillsAvailable, pillStrengthBoost, mid)) {
                maxTasks = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return maxTasks;
    }

    private boolean canAssign(
        int[] taskDifficulties,
        int[] workerStrengths,
        int pillsLeft,
        int pillBoost,
        int numTasksToAssign
    ) {
        TreeMap<Integer, Integer> availableWorkers = new TreeMap<>();
        for (int i = workerStrengths.length - numTasksToAssign; i < workerStrengths.length; ++i) {
            availableWorkers.put(workerStrengths[i], availableWorkers.getOrDefault(workerStrengths[i], 0) + 1);
        }

        for (int i = numTasksToAssign - 1; i >= 0; --i) {
            Integer strongestWorker = availableWorkers.lastKey();

            if (strongestWorker >= taskDifficulties[i]) {
                availableWorkers.put(strongestWorker, availableWorkers.get(strongestWorker) - 1);
                if (availableWorkers.get(strongestWorker) == 0) {
                    availableWorkers.remove(strongestWorker);
                }
            } else {
                if (pillsLeft == 0) {
                    return false;
                }
                Integer boostedWorker = availableWorkers.ceilingKey(taskDifficulties[i] - pillBoost);
                if (boostedWorker == null) {
                    return false;
                }
                availableWorkers.put(boostedWorker, availableWorkers.get(boostedWorker) - 1);
                if (availableWorkers.get(boostedWorker) == 0) {
                    availableWorkers.remove(boostedWorker);
                }
                --pillsLeft;
            }
        }

        return true;
    }
}
