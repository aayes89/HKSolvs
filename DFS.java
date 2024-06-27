public static Tree solve() {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt(); // Número de nodos del árbol

    // Llama a la función DFS para construir el árbol
    TreeNode rootNode = (TreeNode) dfs(scan, 0);

    scan.close();
    return rootNode;
}

public static Tree dfs(Scanner scan, int depth) {
    int value = scan.nextInt();
    int colorCode = scan.nextInt();
    Color color = (colorCode == 0) ? Color.RED : Color.GREEN;
    int numChildren = scan.nextInt();

    TreeNode node = new TreeNode(value, color, depth);
    for (int i = 0; i < numChildren; i++) {
        TreeNode child = (TreeNode) dfs(scan, depth + 1);
        node.addChild(child);
    }

    return node;
}
