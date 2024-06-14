public class ItemType {

    private int value;

    public ItemType(int value){
        this.value = value;
    }
    public int compareTo(ItemType item){
        if(this.value < item.value){
            return -1;
        }
        if(this.value == item.value){
            return 0;
        }
        else{
            return 1;
        }
    } // compareTo

    public int getValue(){
        return value;
    } // getValue

    public void initialize(int num){
        value = num;
    } // intitialize

} // ItemType
