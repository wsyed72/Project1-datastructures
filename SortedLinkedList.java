import org.w3c.dom.Node;
public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;

    public SortedLinkedList(){

        head = null;
        currentPos = null;
    } // SortedLinkedList

    public SortedLinkedList(NodeType head){
        this.head = head;
        this.currentPos = head;
    }

    public int getLength(){

        int count = 0;
        while (currentPos.next != null) {
            currentPos = currentPos.next;
            count++;
        }
        return count;
    } // getLength


    public void insertItem(ItemType item){
        NodeType n = new NodeType(item);
        if (head == null){
            head = n;
        }
        while(currentPos.next != null){
            currentPos = currentPos.next;
        }
        currentPos.next = n;
    } // insertItem

    public void deleteItem(ItemType item){
        NodeType comparison = new NodeType(item);
        if(head == comparison){
            head = null;
        }
        while(currentPos != comparison){
            if(currentPos == comparison){
                currentPos = null;
            }
            currentPos = currentPos.next;
        }
    } // deleteItem

    public int searchItem(ItemType item){   // returns -1 if notFound, and 1 if found
        NodeType n = new NodeType(item);
        boolean found = false;
    while(found ){
        if(currentPos == n){
            return 1;
        }
    }
        return -1;
    } // searchItem


    public ItemType getNextItem(){

    } //getNextItem


    public void resetList(){

    } // resetList


    public NodeType mergeList(NodeType list){

    } // mergeList


    public void deleteAltNodes(){

    } // deleteAltNodes


    public void intersection(){

    } // intersection
}
