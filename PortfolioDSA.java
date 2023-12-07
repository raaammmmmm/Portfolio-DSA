import java.util.*;
import java.util.LinkedList;

// LINKED LIST
class NodeList {
    String data;
    NodeList next;

    public NodeList(String data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    private NodeList head;

    public CircularLinkedList() {
        this.head = null;
    }

    // Add a new element to the end of the circular list
    public void add(String data) {
        NodeList newNodeList = new NodeList(data);
        if (head == null) {
            head = newNodeList;
            head.next = head; // Point to itself in a circular manner
        }
        else {
         NodeList current = head;
         while (current.next != head) {
             current = current.next;
         }
         current.next = newNodeList;
         newNodeList.next = head; // Make the new NodeList point to the head for circularity
        }
    }

    // Display all elements in the circular list
    public void display() {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        NodeList current = head;
        System.out.println("> MY LINKED LIST <");
        do {
            System.out.print(current.data + ", ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}
// LINKED LIST END

// TREE
class TreeNodeList<T> {
    T data;
    List<TreeNodeList<T>> children;

    public TreeNodeList(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNodeList<T> child) {
        this.children.add(child);
    }

    public void displayTree() {
        displayTree(this, 0);
    }

    private void displayTree(TreeNodeList<T> NodeList, int depth) {
        System.out.println(getIndent(depth) + NodeList.data);
        for (TreeNodeList<T> child : NodeList.children) {
            displayTree(child, depth + 1);
        }
    }

    private String getIndent(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("  "); // Two spaces per depth level
        }
        return indent.toString();
    }
}
// TREE END

// BINARY TREE
class NodeTree {
    int item;
    NodeTree left, right;
    
    public NodeTree(int key) {
        item = key;
        left = right = null;
    }
}
// BINARY TREE END

// GRAPH
class Graph {
    // inner class
    class Edge {
        int src, dest;
    }

    int vertices, edges; // number of vertices and edges
    Edge[] edge; // array to store all edges

    Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        
        edge = new Edge[edges]; // initialize the edge array
        
        for (int i = 0; i < edges; i++) {
            // each element of the edge array
            // is an object of Edge type
            edge[i] = new Edge();
        }
    }
}

public class PortfolioDSA {
    // DISPLAY ARRAY
    private static void displayArr(int[] array, int size) {
        if (size == 0) {
            System.out.println("List is empty. Nothing to display.");
            return;
        }

        System.out.println("> MY LIST <");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // DISPLAY ALL ELEMENTS IN QUEUE
    private static void displayQueueAll(Queue<String> queue) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Nothing to display.");
        } else {
            System.out.println("> MY QUEUE <");
            int index = 1;
            for (String element : queue) {
                System.out.println("[" + index + "] " + element);
                index++;
            }
        }
    }

    private static void cipher(String txtClear, int k) {
        String txtCipher = encrypt(txtClear, k);
        System.out.println("Ciphertext: " + txtCipher);
    }

    // QUEUE ENCRYPT
    private static String encrypt(String cleartext, int k) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < cleartext.length(); i++) {
            char currentChar = cleartext.charAt(i);

            if (Character.isLetter(currentChar)) {
                char encryptedChar = (char) ((currentChar - 'A' + k) % 26 + 'A');
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(currentChar);
            }
        }

        return encryptedText.toString();
    }

    // DISPLAY SPECIFIC ELEMENT IN QUEUE
    private static void displayQueueSpecific(Queue<String> queue, Scanner scan) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Cannot display specific element.");
        } else {
            displayQueueAll(queue); // Display all elements with indices
            System.out.print("Enter the position of the element to display: ");

            int elementNumber = scan.nextInt();
            scan.nextLine(); // Consume the newline element

            if (elementNumber >= 1 && elementNumber <= queue.size()) {
                int currentIndex = 1;
                for (String element : queue) {
                    if (currentIndex == elementNumber) {
                        System.out.println("Selected: " + element);
                        break;
                    }
                    currentIndex++;
                }
            } else {
                System.out.println("Invalid element number.");
            }
        }
    }

    NodeTree root;
    PortfolioDSA() {
        root = null;
    }

    // DISPLAY THE NUMBER OF LEAF NODES IN THE TREE
    public static int countLeaf(NodeTree NodeTree) {
        if (NodeTree == null) {
            return 0;
        }
        if (NodeTree.left == null && NodeTree.right == null) {
            return 1;
        } else {
            return countLeaf(NodeTree.left) + countLeaf(NodeTree.right);
        }
    }

    // PREORDER DISPLAY OF TREE
    public static void displayPreOrder(NodeTree root) {
        if (root != null) {
            System.out.print((char) root.item + " "); // Convert Unicode value to character
            displayPreOrder(root.left);
            displayPreOrder(root.right);
        }
    }

    // INORDER DISPLAY OF TREE
    public static void displayInOrder(NodeTree root) {
        if (root != null) {
            displayInOrder(root.left);
            System.out.print((char) root.item + " "); // Convert Unicode value to character
            displayInOrder(root.right);
        }
    }

    // POSTORDER DISPLAY OF TREE
    public static void displayPostOrder(NodeTree root) {
        if (root != null) {
            displayPostOrder(root.left);
            displayPostOrder(root.right);
            System.out.print((char) root.item + " "); // Convert Unicode value to character
        }
    }

    // EXIT QUERY
    private static void exitQuery() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\n[Y] Exit the program? ");
        char ch = scan.next().charAt(0);
        if(ch == 'Y' || ch == 'y') {
            System.out.print("\nThank you for using the program!");
            scan.close();
            System.exit(0);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;

        // LOOP FOR PORTFOLIO MENU
        while (!exit) {
            // PORTFOLIO MENU
            System.out.print("\n\n=========================================\n");
            System.out.print("\t>>> Portfolio in DSA <<<\n");
            System.out.print("=========================================\n");
            System.out.print("[1] List\t[5] Tree\n[2] Linked List\t[6] Binary Tree\n");
            System.out.print("[3] Stack\t[7] Graph\n[4] Queue\t[8] Exit\n");
            System.out.print("=========================================\n");
            
            // USER INPUT
            System.out.print("\nSelect a Data Structure: ");
            int dsSelect = scan.nextInt();

            // SELECTION SWITCH
            switch (dsSelect) {
                case 1:
                    System.out.print("\n>> LIST AS A DATA STRUCTURE <<\n");
                    int choiceList, valArr;
                    int size = 0;
                    int[] intList = new int[999];

                    do {
                        System.out.print("LIST OPERATIONS\n");
                        System.out.print("[1] Add\n[2] Display\n[3] Exit\n");
                        System.out.print("Select an operation: ");
                        choiceList = scan.nextInt();

                        switch (choiceList) {
                            case 1:
                                System.out.print("Enter an integer to add: ");
                                valArr = scan.nextInt();
                                intList[size] = valArr;
                                size++;
                                System.out.print("Added " + valArr + " to the list.\n");
                                break;
                            case 2:
                                displayArr(intList, size);
                                break;
                            case 3:
                                System.out.println("Exiting list...");
                                break;
                            default:
                                System.out.println("Invalid input. Try again.");
                        }
                    } while(choiceList != 3);

                    exitQuery();
                    break;
                case 2:
                    System.out.print("\n>> LINKED LIST AS A DATA STRUCTURE <<\n");
                    CircularLinkedList dsCircularLinkedList = new CircularLinkedList();
                    int choiceLinkedList;

                    do {
                        System.out.print("LINKED LIST OPERATIONS\n");
                        System.out.print("[1] Add\n[2] Display\n[3] Exit\n");
                        System.out.print("Select an operation: ");
                        choiceLinkedList = scan.nextInt();
                        scan.nextLine(); // Consume the newline character
            
                        switch (choiceLinkedList) {
                            case 1:
                                System.out.print("Enter a String to add: ");
                                String addString = scan.nextLine();
                                dsCircularLinkedList.add(addString);
                                System.out.print("Added " + addString + " to the linked list.\n");
                                break;
                            case 2:
                                dsCircularLinkedList.display();
                                break;
                            case 3:
                                System.out.println("Exiting linked list...");
                                break;
                            default:
                                System.out.println("Invalid input. Try again.");
                        }
                    } while (choiceLinkedList != 3);

                    exitQuery();
                    break;
                case 3:
                    System.out.print("\n>> STACK AS A DATA STRUCTURE <<\n");
                    Stack<Integer> stack = new Stack<>();
                    int choiceStack;

                    do {
                        System.out.print("STACK OPERATIONS\n");
                        System.out.print("[1] Push\n[2] Pop\n[3] Print\n");
                        System.out.print("[4] Top\n[5] Exit\n");
                        System.out.print("Select an operation: ");
                        choiceStack = scan.nextInt();
                        
                        switch (choiceStack) {
                            case 1:
                                System.out.print("Enter an integer to push: ");
                                int element = scan.nextInt();
                                stack.push(element);
                                System.out.println(element + " got pushed onto the stack.");
                                break;
                            case 2:
                                if (!stack.isEmpty()) {
                                    int poppedElement = stack.pop();
                                    System.out.println("Popped element: " + poppedElement);
                                } else {
                                    System.out.println("Stack is empty. Cannot pop.");
                                }
                                break;
                            case 3:
                                if (!stack.isEmpty()) {
                                    System.out.print("MY STACK: ");
                                    for (Integer item : stack) {
                                        System.out.print(item + " ");
                                    }
                                    System.out.println();
                                } else {
                                    System.out.println("Stack is empty. Nothing to display.");
                                }
                                break;
                            case 4:
                                if (!stack.isEmpty()) {
                                    System.out.println("Top: " + stack.peek());
                                } else {
                                    System.out.println("Stack is empty. Cannot display the top of the stack.");
                                }
                                break;
                            case 5:
                                System.out.println("Exiting stack...");
                                break;
                            default:
                                System.out.println("Invalid input. Try again.");
                        }
                    } while(choiceStack != 5);

                    exitQuery();
                    break;
                case 4:
                    System.out.print("\n>> QUEUE AS A DATA STRUCTURE <<\n");
                    Queue<String> queue = new LinkedList<>();
                    int choiceQueue;

                    do {
                        System.out.print("QUEUE OPERATIONS\n");
                        System.out.print("[1] Add\n");
                        System.out.print("[2] Display Queue\n");
                        System.out.print("[3] Display a Specific Element\n");
                        System.out.print("[4] Cipher Text\n");
                        System.out.print("[5] Exit\n");
                        System.out.print("Select an operation: ");
                        choiceQueue = scan.nextInt();
                        scan.nextLine(); // Consume the newline element

                        switch (choiceQueue) {
                            case 1:
                                System.out.print("Enter String to add: ");
                                String strName = scan.nextLine();
                                queue.add(new String(strName));
                                System.out.println("Added " + strName + " to the queue.");
                                break;
                            case 2:
                                displayQueueAll(queue);
                                break;
                            case 3:
                                displayQueueSpecific(queue, scan);
                                break;
                            case 4:
                                System.out.print("Enter Cleartext: "); 
                                String txtClear = scan.nextLine().toUpperCase(); 
                                System.out.print("Enter a value for k: "); 
                                int k = scan.nextInt();
                                cipher(txtClear, k);
                                break;
                            case 5:
                                System.out.println("Exiting queue...");
                                break;
                            default:
                                System.out.println("Invalid input. Try again.");
                        }
                    } while (choiceQueue != 5);

                    exitQuery();
                    break;
                case 5:
                    System.out.print("\n>> Tree as a Data Structure <<\n");
                    TreeNodeList<String> root = new TreeNodeList<>("WHAT I EAT IN A DAY");

                    TreeNodeList<String> child1 = new TreeNodeList<>("Breakfast");
                    TreeNodeList<String> child2 = new TreeNodeList<>("Lunch");
                    TreeNodeList<String> child3 = new TreeNodeList<>("Dinner");

                    root.addChild(child1);
                    root.addChild(child2);
                    root.addChild(child3);

                    TreeNodeList<String> grandchild1 = new TreeNodeList<>("Pandesal");
                    TreeNodeList<String> grandchild2 = new TreeNodeList<>("Coffee");
                    TreeNodeList<String> grandchild3 = new TreeNodeList<>("Egg");
                    TreeNodeList<String> grandchild4 = new TreeNodeList<>("Rice");
                    TreeNodeList<String> grandchild5 = new TreeNodeList<>("Chicken");
                    TreeNodeList<String> grandchild6 = new TreeNodeList<>("Soup");
                    
                    child1.addChild(grandchild1);
                    child1.addChild(grandchild2);
                    child1.addChild(grandchild3);
                    child2.addChild(grandchild4);
                    child2.addChild(grandchild5);
                    child3.addChild(grandchild6);

                    // Display the tree
                    root.displayTree();

                    exitQuery();
                    break;
                case 6:
                    System.out.print("\n>> BINARY TREE AS A DATA STRUCTURE <<\n");
                    int choiceBTree;
                    PortfolioDSA tree = new PortfolioDSA();
                    tree.root = new NodeTree('p');

                    tree.root.left = new NodeTree('g');
                    tree.root.right = new NodeTree('w');
                    
                    tree.root.left.left = new NodeTree('c');
                    tree.root.left.right = new NodeTree('k');

                    tree.root.right.left = new NodeTree('s');
                    tree.root.right.right = new NodeTree('y');

                    tree.root.left.left.left = new NodeTree('a');
                    tree.root.left.left.right = new NodeTree('e');

                    tree.root.left.right.left = new NodeTree('i');
                    tree.root.left.right.right = new NodeTree('m');

                    tree.root.right.left.left = new NodeTree('q');
                    tree.root.right.left.right = new NodeTree('u');

                    tree.root.right.right.left = new NodeTree('x');
                    tree.root.right.right.right = new NodeTree('z');

                    do {
                        System.out.print("BINARY TREE OPERATIONS\n");
                        System.out.print("[1] Display Total Leaf Nodes\n");
                        System.out.print("[2] Display Pre-Order Traversal\n");
                        System.out.print("[3] Display In-Order Traversal\n");
                        System.out.print("[4] Display Post-Order Traversal\n");
                        System.out.print("[5] Exit\n");
                        System.out.print("Select an operation: ");
                        choiceBTree = scan.nextInt();
                        scan.nextLine(); // Consume the newline element

                        switch (choiceBTree) {
                            case 1:
                                int leafNodeTrees = countLeaf(tree.root);
                                System.out.println("Total Leaf NodeTrees: " + leafNodeTrees);
                                break;
                            case 2:
                                System.out.println("Pre-Order Traversal of Tree");
                                displayPreOrder(tree.root);
                                System.out.println("\n");
                                break;
                            case 3:
                                System.out.println("In-Order Traversal of Tree");
                                displayInOrder(tree.root);
                                System.out.println("\n");
                                break;
                            case 4:
                                System.out.println("Post-Order Traversal of Tree");
                                displayPostOrder(tree.root);
                                System.out.println("\n");
                                break;
                            case 5:
                                System.out.println("Exiting binary tree...");
                                break;
                            default:
                                System.out.println("Invalid input. Try again.");
                        }
                    } while (choiceBTree != 5);

                    exitQuery();
                    break;
                case 7:
                    System.out.print("\n>> GRAPH AS A DATA STRUCTURE <<\n");

                    // Get the number of vertices
                    System.out.print("Enter the number of vertices: ");
                    int noVertices = scan.nextInt();

                    // Get the number of edges
                    System.out.print("Enter the number of edges: ");
                    int noEdges = scan.nextInt();

                    Graph g = new Graph(noVertices, noEdges);

                    // create graph by taking user input
                    for (int i = 0; i < noEdges; i++) {
                        System.out.println("Enter details for edge " + (i + 1));

                        // Get source and destination vertices for each edge
                        System.out.print("Enter source vertex: ");
                        g.edge[i].src = scan.nextInt();

                        System.out.print("Enter destination vertex: ");
                        g.edge[i].dest = scan.nextInt();
                    }

                    System.out.println("\nGraph Edges");
                    for (int i = 0; i < noEdges; i++) {
                        System.out.println(g.edge[i].src + " - " + g.edge[i].dest);
                    }

                    exitQuery();
                    break;
                case 8:
                    System.out.print("\nThank you for using the program!");
                    scan.close();
                    exit = true;
                    break;
                default:
                    System.out.print("\nInvalid input. Try again.");
            }
        }
    }   
}
