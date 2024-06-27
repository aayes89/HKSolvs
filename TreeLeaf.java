public static Tree solve() {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt(); // Número de nodos del árbol

    // Lee los valores de los nodos y sus colores
    int[] values = new int[n];
    Color[] colors = new Color[n];

    for (int i = 0; i < n; i++) {
        values[i] = scan.nextInt();
        int colorCode = scan.nextInt();
        colors[i] = (colorCode == 0) ? Color.RED : Color.GREEN;
    }

    Tree[] nodes = new Tree[n];

    // Construye el árbol a partir de las conexiones
    for (int i = 0; i < n - 1; i++) {
        int parentIndex = scan.nextInt() - 1; // Resta 1 para que coincida con el índice del arreglo
        int childIndex = scan.nextInt() - 1;

        if (nodes[parentIndex] == null) {
            nodes[parentIndex] = new TreeNode(values[parentIndex], colors[parentIndex], 0);
        }

        if (nodes[childIndex] == null) {
            nodes[childIndex] = new TreeNode(values[childIndex], colors[childIndex], nodes[parentIndex].getDepth() + 1);
        }

        // Agrega el hijo al padre, con el hijo derecho como el que tiene más hijos
        TreeNode parentNode = (TreeNode) nodes[parentIndex];
        TreeNode childNode = (TreeNode) nodes[childIndex];

        if (parentNode.getChildren().isEmpty() || (parentNode.getChildren().size() == 1 && parentNode.getChildren().get(0) instanceof TreeLeaf)) {
            parentNode.addChild(childNode);
        }
    }

    // Encuentra la raíz (un nodo sin padre)
    TreeNode rootNode = null;
    for (int i = 0; i < n; i++) {
        if (nodes[i] != null && nodes[i].getDepth() == 0) {
            rootNode = (TreeNode) nodes[i];
            break;
        }
    }

    // Convierte los nodos sin hijos en TreeLeaf
    for (int i = 0; i < n; i++) {
        if (nodes[i] != null && nodes[i] instanceof TreeNode && ((TreeNode) nodes[i]).getChildren().isEmpty()) {
            nodes[i] = new TreeLeaf(values[i], colors[i], nodes[i].getDepth());
        }
    }

    scan.close();
    return rootNode;
}
