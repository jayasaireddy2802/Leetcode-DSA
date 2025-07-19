class Solution {

    public List<String> removeSubfolders(String[] folderPaths) {
        // Create a set for fast lookup of all folder paths
        Set<String> allFolders = new HashSet<>(Arrays.asList(folderPaths));
        List<String> filteredFolders = new ArrayList<>();

        // Check each folder path
        for (String currentPath : folderPaths) {
            boolean isSubfolder = false;
            String parentPath = currentPath;

            // Traverse up the directory tree to check for parent folders
            while (!parentPath.isEmpty()) {
                int lastSlashIndex = parentPath.lastIndexOf('/');
                if (lastSlashIndex == -1) break;

                // Get the parent folder
                parentPath = parentPath.substring(0, lastSlashIndex);

                // If parent folder exists in set, this is a subfolder
                if (allFolders.contains(parentPath)) {
                    isSubfolder = true;
                    break;
                }
            }

            // Add to result if it's not a subfolder
            if (!isSubfolder) {
                filteredFolders.add(currentPath);
            }
        }

        return filteredFolders;
    }
}
