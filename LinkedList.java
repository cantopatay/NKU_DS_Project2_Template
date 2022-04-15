import java.util.List;
import java.util.ArrayList;

public class LinkedList {
    private Node head;

    public LinkedList(){
        head = null;
    }

    public LinkedList(int[] arr){
        head = null;
        for (int i = 0; i < arr.length; i++){
            Node n = new Node(arr[i]);
            Append(n);
        }
    }

    public void Append(int val){
        Node newNode = new Node();
        newNode.value = val;
        newNode.next  = null;
        // Yukaridaki 3 satirlik ifade yerine asagidaki yoruma cevrilmis ifade yazilabilirdi.
        // Node newNode = new Node(val); 

        if (head == null){
            head = newNode;
            return;
        }

        Node n = head;
        while (n.next != null){
            n = n.next;
        }
        n.next = newNode;
    }

    public void Append(Node newNode){
        if (head == null){
            head = newNode;
            return;
        }

        Node n = head;
        while (n.next != null){
            n = n.next;
        }
        n.next = newNode;
    }

    public void Print(){
        Node n = head;
        while (n != null){
            System.out.print("| " + n.value + " |" + " --> ");
            n = n.next;
        }
        System.out.println("|NULL|");
    }

    // Bu metod bagli listenin elemanlarini sondan basa dogru sirali okarak ekrana yazdirir.
    // Bu metodun ciktisi Print metodununun ciktisinin yonu degistirilmis sekli olmalidir.
    // Bu metodu kodlamak icin dizi, ArrayList, String metodlari vb. kullanmayiniz.
    // Bu metodu recursive (oz yinelemeli) sekilde yazabilirsiniz. Bu metodu yazmak icin baska
    // bir metod tanimlayip PrintReverse metodu icinde tanimlamis oldugunuz bu metodu kullanabilirsiniz.

    public void PrintReverse(){
        LinkedList tmp = new LinkedList();
        Node n = this.head;
        while (n!= null){tmp.Prepend(n.value); n=n.next;}
        tmp.Print();
    }

    public void Prepend(int v){
        Node n = new Node(v);
        n.next = this.head;
        this.head=n;
    }

    // Bu metod bagli listedeki elemanlarin toplamini dondurur.

    public int Sum(){
       Node current = this.head;
       int sum =0;
       while (current != null){
           sum+= current.value;
           current=current.next;
       }
       return sum;
    }

    // IsSorted() bagli liste kucukten buyuge sirali ise true aksi durumda false dondurur.
    // Bagli liste bos ise veya tek elemanli ise IsSorted() true dondurur.

    public boolean IsSorted(){
        if(this.head == null || this.head.next==null) return true;

        Node prev;
        prev = this.head;
        while(prev.next != null){
            if(prev.value > prev.next.value) return false;
            prev = prev.next;
        }
        return true;
    }

    // MergeSortedLists(LinkedList m, LinkedList n) parametre olarak iki tane kucukten
    // buyuge sirali bagli liste alir ve bu listelerdeki elemanlarin kucukten buyuge
    // siralandigi bir bagli liste dondurur.

    public static LinkedList MergeSortedLists(LinkedList m, LinkedList n){
        List<Integer> liste = new ArrayList<Integer>();
        Node node = m.head;
        while(node!=null){ liste.add(node.value); node=node.next; }
        node = n.head;
        while(node!=null){ liste.add(node.value); node=node.next; }
        liste.sort(null); //sort ascending

        LinkedList ll = new LinkedList();
        for(int sayi : liste)ll.Append(sayi);

        return ll;

    }
}
