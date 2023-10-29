import java.util.Scanner;
class carsten_logan_2 {
    static SLList slList = new SLList();
    static DLList dlList = new DLList();
    private static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {

        menuDriver();

    }

    static void menuDriver(){
        int option = 0;
        int el = 0;
        String input;
        String[] ins;
        displayMenu();

        do{
            input = keyboard.nextLine();
            ins = input.split(" ");
            if(ins.length >= 1){
                try{
                    option = Integer.parseInt(ins[0]);
                    if(ins.length == 2){
                        el = Integer.parseInt(ins[1]);
                    }
                } catch(NumberFormatException e){
                    System.out.println("Invalid input. Enter integer(s) separated by a space");
                }

            } else {
                System.out.println("Invalid input. Enter integer(s) separated by a space");

            }



            switch(option){
                case 0:
                    slList.addToHead(el);
                    displayMenu();
                    break;
                case 1:
                    slList.addToTail(el);
                    displayMenu();
                    break;
                case 2:
                    slList.delFromHead();
                    displayMenu();
                    break;
                case 3:
                    slList.delFromTail();
                    displayMenu();
                    break;
                case 4:
                    slList.searchDelete(el);
                    displayMenu();
                    break;
                case 5:
                    slList.printList();
                    displayMenu();
                    break;
                case 6:
                    dlList.addToHead(el);
                    displayMenu();
                    break;
                case 7:
                    dlList.addToTail(el);
                    displayMenu();
                    break;
                case 8:
                    dlList.deleteHead();
                    displayMenu();
                    break;
                case 9:
                    dlList.deleteTail();
                    displayMenu();
                    break;
                case 10:
                    dlList.searchDelete(el);
                    displayMenu();
                    break;
                case 11:
                    dlList.printList();
                    displayMenu();
                    break;
                case 12:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid menu option, try again");
                    displayMenu();

            }


        } while(option != 12);

    }

    static  void displayMenu(){
        System.out.println("MENU: Please Choose one of the following options & insert integer");
        System.out.println("SLL: IH(0), IT(1), DH(2), DT(3), SD(4), PS(5)");
        System.out.println("DLL: IH(6), IT(7), DH(8), DT(9), SD(10), PS(11)");
        System.out.println("Exit program (12)");
    }



}

class IntDLLNode {

    int info;
    IntDLLNode next, prev;

    IntDLLNode(){
        next = prev = null;
    }

    IntDLLNode(int el, IntDLLNode n, IntDLLNode p){
        info = el;
        next = n;
        prev = p;
    }

}

class DLList {

    IntDLLNode head,tail;

    void addToTail(int el){
        if(tail != null){
            tail = new IntDLLNode(el, null, tail);
            tail.prev.next = tail;
        } else {
            head = tail = new IntDLLNode(el, null, null);
        }
    }

    void addToHead(int el){
        if(head != null){
            head = new IntDLLNode(el, head, null);
            head.next.prev = head;
        } else {
            head = tail = new IntDLLNode(el, null, null);
        }
    }

    void deleteHead(){
        if(head == null) {
            System.out.println("Invalid Operation - empty list");
            return;
        }
        if(head == tail){
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    void deleteTail(){
        if(head == null){
            System.out.println("Invalid Operation - empty list");
            return;
        }
        if(head == tail){
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    void searchDelete(int el){

        if(head == null){
            System.out.println("Invalid option - empty list");
            return;
        }

        if(head == tail && el == head.info){
            head = tail = null;
            return;
        } else if(el == head.info){
            head.next.prev = null;
            head = head.next;
            return;
        }

        IntDLLNode tmp = head;
        while(tmp != null && tmp.info != el){
            tmp = tmp.next;
        }

        if(tmp == null){
            System.out.println("Element not found");
            return;
        }
        if(tmp.prev!= null){
            tmp.prev.next = tmp.next;
        }
        if(tmp.next != null){
            tmp.next.prev = tmp.prev;
        }
        if(tmp == tail){
            tail = tmp.prev;
        }

    }

    void printList(){
        if(head == null){
            System.out.println("Invalid operation - empty list");
            return;
        }
        IntDLLNode tmp;
        for(tmp = head; tmp!= null; tmp = tmp.next){
            System.out.print(tmp.info + " ");
        }
        System.out.println(" ");
    }


}

class IntSLLNode{
    IntSLLNode(){
        next = null;
    }

    IntSLLNode(int i, IntSLLNode node){
        info = i;
        next = node;
    }

    int info;
    IntSLLNode next;
}

class SLList{

    IntSLLNode head;
    IntSLLNode tail;

    SLList(){

        head = tail = null;
    }

    void addToHead(int el){
        if (tail != null){
            IntSLLNode tmp = new IntSLLNode(el,null);
            tmp.next = head;
            head = tmp;
        } else {
            head = new IntSLLNode(el,head);
            tail = head;
        }

    }

    void addToTail(int el){
        if(tail!=null){
            tail.next = new IntSLLNode(el, null);
            tail = tail.next;
        } else {
            head = tail = new IntSLLNode(el, null);
        }

    }

    void delFromHead(){

        if(head == null){
            System.out.println("Invalid operation- empty list.");
            return;
        } else {

            if(head == tail){
                head = tail = null;
            } else {
                head = head.next;
            }

        }

    }

    void delFromTail(){
        if(head == null){
            System.out.println("Invalid operation- empty list.");
            return ;
        } else if(head == tail) {
            head = tail = null;
        } else {

            IntSLLNode pred = null;
            IntSLLNode tmp = head;

            while(tmp.next != null){
                pred = tmp;
                tmp = tmp.next;
            }

            pred.next = null;
            tail = pred;
        }
    }

    void searchDelete(int el){

        if(head == null) {
            System.out.println("Invalid Option. Empty List");
            return;
        }

        if(el == head.info) {
            head = head.next;

            if(head == null){
                tail = null;
            }
            return;
        }

        IntSLLNode pred = head;
        IntSLLNode tmp = head.next;

        while(tmp!= null){
            if(tmp.info == el){
                pred.next = tmp.next;
                if(tmp == tail){
                    tail = pred;
                }
                return;
            }
            pred = tmp;
            tmp = tmp.next;
        }
        System.out.println("Element not found in list ");

    }

    void printList(){
        IntSLLNode tmp;
        if(head == null){
            System.out.println("Invalid option - empty list");
            return;
        }
        for(tmp = head; tmp != null; tmp = tmp.next){
            System.out.print(tmp.info + " ");
        }
        System.out.println(" ");
    }


}


