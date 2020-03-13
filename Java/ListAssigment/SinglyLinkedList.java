package ListAssigment;

public class SinglyLinkedList {
	
	private int size;
	public Node head;
	
    public SinglyLinkedList() {
        this.size = 0;
        
    }
    
    public void add(int value) {
        Node newNode = new Node(value);
        this.size++;
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }    
    public void showNodeValue(Node node) {
		
    	while(node.next != null) {
    		System.out.println(node.value);
    		node = node.next;
    	}
    	if(node.next == null){
    		System.out.println(node.value);
    	}
    }
    public void printValues() {	
    	showNodeValue(this.head);
    }
    
    public void remove() {
    	
    	Node node = this.head;
    	Node aux = null;
    	while(node.next != null) {
    		aux = node;
    		node = node.next;
    	}
    	if(node.next == null){
    		aux.next = null;
    		System.out.println("Removiendo");
    		node = null;
    	}
    }
}
