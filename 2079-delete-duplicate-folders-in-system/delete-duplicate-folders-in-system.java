import java.util.AbstractMap;
class Solution {

    static class TrieNode {
        String folderName;
        String encodedSubtree;
        Map<String, TrieNode> children;

        TrieNode(String folderName) {
            this.folderName = folderName;
            this.encodedSubtree = "";
            this.children = new HashMap<>();
        }
    }

    private TrieNode createNode(String folderName) {
        return new TrieNode(folderName);
    }

    private void addPath(TrieNode root, List<String> path) {
        for (String folder : path) {
            root.children.putIfAbsent(folder, createNode(folder));
            root = root.children.get(folder);
        }
    }

    private String encodeSubtree(TrieNode currentNode, Map<String, Integer> subtreeCountMap) {
        List<Map.Entry<String, String>> encodedChildren = new ArrayList<>();

        for (Map.Entry<String, TrieNode> entry : currentNode.children.entrySet()) {
            String encodedChild = encodeSubtree(entry.getValue(), subtreeCountMap);
            encodedChildren.add(new AbstractMap.SimpleEntry<>(entry.getKey(), encodedChild));
        }

        encodedChildren.sort(Comparator.comparing(Map.Entry::getKey));

        StringBuilder encoded = new StringBuilder();
        for (Map.Entry<String, String> entry : encodedChildren) {
            encoded.append("(").append(entry.getKey()).append(entry.getValue()).append(")");
        }

        currentNode.encodedSubtree = encoded.toString();

        if (!encoded.toString().isEmpty()) {
            subtreeCountMap.put(encoded.toString(), subtreeCountMap.getOrDefault(encoded.toString(), 0) + 1);
        }

        return encoded.toString();
    }

    private void removeDuplicateSubtrees(TrieNode currentNode, Map<String, Integer> subtreeCountMap) {
        Iterator<Map.Entry<String, TrieNode>> iterator = currentNode.children.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, TrieNode> entry = iterator.next();
            TrieNode childNode = entry.getValue();

            if (!childNode.encodedSubtree.isEmpty() && subtreeCountMap.get(childNode.encodedSubtree) > 1) {
                iterator.remove();
            } else {
                removeDuplicateSubtrees(childNode, subtreeCountMap);
            }
        }
    }

    private void collectPaths(TrieNode currentNode, List<String> currentPath, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : currentNode.children.entrySet()) {
            currentPath.add(entry.getKey());
            result.add(new ArrayList<>(currentPath));
            collectPaths(entry.getValue(), currentPath, result);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> folderPaths) {
        TrieNode root = createNode("/");

        // Build the trie structure
        for (List<String> path : folderPaths) {
            addPath(root, path);
        }

        // Encode and detect duplicate subtrees
        Map<String, Integer> subtreeCountMap = new HashMap<>();
        encodeSubtree(root, subtreeCountMap);

        // Remove duplicate subtrees
        removeDuplicateSubtrees(root, subtreeCountMap);

        // Collect the remaining valid paths
        List<List<String>> result = new ArrayList<>();
        collectPaths(root, new ArrayList<>(), result);

        return result;
    }
}
