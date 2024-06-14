public class NodeType {

    public ItemType info;
    public NodeType next;

    public NodeType(){
        info = null;
        next = null;
    } // Default Constructor

    public NodeType(ItemType info){
        this.info = info;
        this.next = null;
    }

    public NodeType(ItemType info, NodeType next){
        this.info = info;
        this.next = next;
    } // Creates Node

    public ItemType getInfo(){

        return info;
    } // getInfo


    public NodeType getNext(){

        return next;
    } // getNext


    public void setInfo(ItemType info){

        this.info = info;
    } // setInfo


    public void setNext(NodeType next){

        this.next = next;
    } //NodeType
}
