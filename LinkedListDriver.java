import java.util.Scanner;

// Class to represent an item with an integer value
class ItemType {
    private int value;

    // Constructor to initialize the value
    public ItemType(int value) {
        this.value = value;
    }

    // Compares the current item with another item
    public int compareTo(ItemType item) {
        if (this.value < item.value) {
            return -1;
        } else if (this.value == item.value) {
            return 0;
        } else {
            return 1;
        }
    }

    // Returns the value of the item
    public int getValue() {
        return value;
    }

    // Initializes the value of the item
    public void initialize(int num) {
        this.value = num;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ItemType itemType = (ItemType) obj;
        return value == itemType.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}

// Class to represent a node in the linked list
class NodeType {
    public ItemType info; // The item stored in the node
    public NodeType next; // The reference to the next node

    // Constructor to initialize the node with an item
    public NodeType(ItemType info) {
        this.info = info;
        this.next = null;
    }
}

// Class to represent a sorted linked list
class SortedLinkedList {
    private NodeType head; // The head of the linked list
    private NodeType currentPos; // The current position in the list for iteration

    // Constructor to initialize an empty linked list
    public SortedLinkedList() {
        this.head = null;
        this.currentPos = null;
    }

    // Returns the length of the linked list
    public int getLength() {
        int length = 0;
        NodeType temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // Inserts an item into the linked list while maintaining sorted order
    public void insertItem(ItemType item) {
        NodeType newNode = new NodeType(item);
        if (head == null || head.info.compareTo(item) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            NodeType temp = head;
            while (temp.next != null && temp.next.info.compareTo(item) < 0) {
                temp = temp.next;
            }
            if (temp.next != null && temp.next.info.compareTo(item) == 0) {
                System.out.println("Sorry. You cannot insert the duplicate item");
                return;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Deletes an item from the linked list
    public void deleteItem(ItemType item) {
        if (head == null) {
            System.out.println("You cannot delete from an empty list");
            return;
        }
        if (head.info.equals(item)) {
            head = head.next;
        } else {
            NodeType temp = head;
            while (temp.next != null && !temp.next.info.equals(item)) {
                temp = temp.next;
            }
            if (temp.next == null) {
                System.out.println("Item not found");
                return;
            }
            temp.next = temp.next.next;
        }
    }

    // Searches for an item in the linked list and returns its index
    public int searchItem(ItemType item) {
        NodeType temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.info.equals(item)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        System.out.println("Item not found");
        return -1;
    }

    // Returns the next item in the list during iteration
    public ItemType getNextItem() {
        if (currentPos == null) {
            currentPos = head;
        } else {
            currentPos = currentPos.next;
        }
        if (currentPos != null) {
            return currentPos.info;
        } else {
            System.out.println("The end of the list has been reached");
            currentPos = head;
            return null;
        }
    }

    // Resets the current position in the list for iteration
    public void resetList() {
        currentPos = null;
    }

    // Merges another sorted linked list into the current list, maintaining sorted order
    public void combineList(SortedLinkedList otherList) {
        NodeType temp = otherList.head;
        while (temp != null) {
            this.insertItem(temp.info);
            temp = temp.next;
        }
    }

    // Removes alternate nodes from the linked list
    public void removeAlternateNodes() {
        if (head == null) return;
        NodeType prev = head;
        NodeType curr = head.next;
        while (prev != null && curr != null) {
            prev.next = curr.next;
            curr = null;
            prev = prev.next;
            if (prev != null) curr = prev.next;
        }
    }

    // Finds the intersection of two linked lists and returns the result as a new linked list
    public SortedLinkedList findIntersection(SortedLinkedList otherList) {
        SortedLinkedList result = new SortedLinkedList();
        NodeType temp1 = this.head;
        NodeType temp2 = otherList.head;
        while (temp1 != null && temp2 != null) {
            if (temp1.info.equals(temp2.info)) {
                result.insertItem(temp1.info);
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else if (temp1.info.compareTo(temp2.info) < 0) {
                temp1 = temp1.next;
            } else {
                temp2 = temp2.next;
            }
        }
        return result;
    }

    // Prints the linked list
    public void displayList() {
        NodeType temp = head;
        System.out.print("The list is: ");
        while (temp != null) {
            System.out.print(temp.info.getValue() + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Driver class for the linked list program
public class LinkedListDriver {
    public static void main(String[] arguments) {
        SortedLinkedList list = new SortedLinkedList();
        Scanner inputScanner = new Scanner(System.in);
        char userCommand;

        do {
            // Display available commands
            System.out.println("Commands:");
            System.out.println("(i) - Insert value");
            System.out.println("(d) - Delete value");
            System.out.println("(s) - Search value");
            System.out.println("(n) - Print next iterator value");
            System.out.println("(r) - Reset iterator");
            System.out.println("(a) - Delete alternate nodes");
            System.out.println("(m) - Merge lists");
            System.out.println("(t) - Find intersection");
            System.out.println("(p) - Print list");
            System.out.println("(l) - Print length");
            System.out.println("(q) - Quit program");
            System.out.print("Enter a command: ");
            userCommand = inputScanner.next().charAt(0);

            // Execute the command entered by the user
            switch (userCommand) {
                case 'i':
                    System.out.print("Enter a number to insert: ");
                    int valueToInsert = inputScanner.nextInt();
                    ItemType itemToInsert = new ItemType(valueToInsert);
                    list.displayList();
                    list.insertItem(itemToInsert);
                    list.displayList();
                    break;
                case 'd':
                    System.out.print("Enter a number to delete: ");
                    int valueToDelete = inputScanner.nextInt();
                    ItemType itemToDelete = new ItemType(valueToDelete);
                    list.displayList();
                    list.deleteItem(itemToDelete);
                    list.displayList();
                    break;
                case 's':
                    System.out.print("Enter a number to search: ");
                    int valueToSearch = inputScanner.nextInt();
                    ItemType itemToSearch = new ItemType(valueToSearch);
                    int foundIndex = list.searchItem(itemToSearch);
                    if (foundIndex != -1) {
                        System.out.println("The item is present at index " + foundIndex);
                    }
                    break;
                case 'n':
                    ItemType nextItem = list.getNextItem();
                    if (nextItem != null) {
                        System.out.println(nextItem.getValue());
                    }
                    break;
                case 'r':
                    list.resetList();
                    System.out.println("Iterator is reset");
                    break;
                case 'a':
                    list.displayList();
                    list.removeAlternateNodes();
                    list.displayList();
                    break;
                case 'm':
                    System.out.print("Enter the length of the new list: ");
                    int length = inputScanner.nextInt();
                    SortedLinkedList newList = new SortedLinkedList();
                    System.out.print("Enter the numbers: ");
                    for (int i = 0; i < length; i++) {
                        ItemType newItem = new ItemType(inputScanner.nextInt());
                        newList.insertItem(newItem);
                    }
                    System.out.print("The list 1: ");
                    list.displayList();
                    System.out.print("The list 2: ");
                    newList.displayList();
                    list.combineList(newList);
                    list.displayList();
                    break;
                case 't':
                    System.out.print("Enter the length of the new list: ");
                    int len = inputScanner.nextInt();
                    SortedLinkedList interList = new SortedLinkedList();
                    System.out.print("Enter the numbers: ");
                    for (int i = 0; i < len; i++) {
                        ItemType interItem = new ItemType(inputScanner.nextInt());
                        interList.insertItem(interItem);
                    }
                    System.out.print("The list 1: ");
                    list.displayList();
                    System.out.print("The list 2: ");
                    interList.displayList();
                    SortedLinkedList intersectionList = list.findIntersection(interList);
                    System.out.print("Intersection of lists: ");
                    intersectionList.displayList();
                    break;
                case 'p':
                    list.displayList();
                    break;
                case 'l':
                    System.out.println("The length of the list is " + list.getLength());
                    break;
                case 'q':
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid command, try again!");
            }
        } while (userCommand != 'q');
    }
}
