/**
 * Created by Eric on 21/10/14.
 */



public class List {

	Node first;
	Node last;
	private int size;
	Node[] arr;

	// expansion rule
	char exp = 'd';

	final int defaultSize = 10;
	
	String showSize(){
		return "\nList size : " + size+" \nArray length : "+arr.length;
	}

	// default constructor
	List() {
		this.arr = new Node[defaultSize];
		this.size = 0;
		this.exp = 'd';
		first = null;
		last = null;

	}

	// Parameterized constructor
	List(int inSize) {
		this.arr = new Node[inSize];
		this.size = 0;
		this.exp = 'd';
	}

	private boolean isEmpty() {
		return size == 0;
	}

	Position first() throws Exception {

		// test if list is empty
		if (isEmpty()) {
			throw new Exception("Empty list");
		} else
			return buildPos(1);

	}

	Position last() throws Exception {

		if (isEmpty()) {
			throw new Exception("Empty list");
		} else
			return buildPos(size);
	}

	Position prev(String p) throws Exception {

		int pos = desPos(p);

		if (isEmpty()) {
			throw new Exception("Empty list");
		} else {
			return buildPos(pos - 1);
		}

	}

	Position next(String p) throws Exception {

		int pos = desPos(p);

		return (buildPos(pos+1));

	}

	int set(String p, int e) throws Exception {
		int pos = desPos(p);
		int old;

		old = buildPos(pos).element();
		arr[pos-1] = new Node(e, pos);
		return old;

	}

	Position addFirst(int e) throws Exception {

		if (size == 0) {
			arr[0] = new Node(e, 1);
			size++;
			return buildPos(1);
		} else {

			// Does the array need expanding?
			if (limitCheck()) {
				expandArray(0);
				arr[0] = new Node(e, 1);

			} else {
				copyArray(0, arr.length);
				arr[0] = new Node(e, 1);
			}
			size++;
			return arr[0];

		}

	}

	Position addLast(int e) throws Exception {

		if (size == 0) {
			return addFirst(e);
		} else {

			// Does the array need expanding?
			if (limitCheck()) {
				expandArray(size);
				arr[size] = new Node(e, size+1);

			} else {
				arr[size] = new Node(e, size+1);
			}
			size++;
			return arr[size];

		}

	}

	Position addBefore(String p, int e) throws Exception {
		int pos = desPos(p);

		if (pos > size) {
			throw new RuntimeException(
					"No such position currently exists in list");
		}

		// If position before is less than first element, build new first
		// element
		if ((pos - 1) < 1) {
			return addFirst(e);

		} else {

			// Does the array need expanding?
			if (limitCheck()) {
				expandArray(pos - 1);
				arr[pos-1] = new Node(e, pos);

			} else {
				copyArray(pos - 1, arr.length);
				arr[pos-1] = new Node(e, pos);

			}
			size++;
			return arr[pos];
		}

	}
	Position addAfter(String p, int e) throws Exception {
		int pos = desPos(p);

		if (pos > size) {
			throw new RuntimeException(
					"No such position currently exists in list");
		}

		// If position before is less than first element, build new first
		// element
		if ((pos - 1) < 0) {
			return addFirst(e);

		} else {

			// Does the array need expanding?
			if (limitCheck()) {
				expandArray(pos);
				arr[pos] = new Node(e, pos+1);

			} else {
				copyArray(pos, arr.length);
				arr[pos] = new Node(e, pos+1);

			}
			size++;
			return arr[pos+1];
		}

	}
	
	int delete(String p){
		int pos = desPos(p);
		int old;
		if (pos > size) {
			throw new RuntimeException(
					"No such position currently exists in list");
		}

		old = arr[pos-1].element();
		Node[] temp = new Node[arr.length];

		for (int i = pos; i < size; i++) {
            temp[i - 1] = arr[i];
            temp[i-1].setPosition(i);
		}

		arr = temp;
		
		size--;	
		return old;	
		
	}
	
	void swap(String p1, String p2) throws Exception{
		int pos1 = desPos(p1);
		int pos2 = desPos(p2);
		
		Node temp = buildPos(pos1);
		arr[pos1-1] = arr[pos2-1];
		arr[pos2-1] = temp;
	}
	
	void truncate(){
		Node[] temp = new Node[size];

		for (int i = 0; i < size; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}

	// expansion rule
	void SetExpansionRule(char x) throws Exception {
		if (x == 'd' || x == 'c')
			exp = x;
		else
			throw new Exception("Character must be c or d");
	}

	// expands array
	private void expandArray(int pos) {
		int a;
		if (exp == 'd')
			a = 2 * (arr.length);
		else
			a = arr.length + 10;

		copyArray(pos, a);

	}

	private void copyArray(int pos, int sizeA) {
		Node[] temp = new Node[sizeA];
		Node temp1;

		for (int i = pos; i < size; i++) {
			temp1 = new Node(arr[i].element(), i+2);
			temp[i + 1] = temp1;
		}
		for (int i = 0; i < pos; i++) {
			temp[i] = arr[i];
		}

		arr = temp;
	}

	// checks if array needs expanding
	private boolean limitCheck() {
		if (0.8 * (arr.length) < size + 1) {
			return true;
		} else {
			return false;
		}
	}

	// Constructs position name for user
	private Node buildPos(int p) throws Exception {
		Node temp;
		try {
			temp = arr[p - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new Exception("No such element given exists");
		} catch (NullPointerException x) {
			throw new Exception("No such element given exists");
		}
		return temp;
	}

	int find(Position x) {
		for (int i = 0; i < size; i++) {
			if (x == arr[i])
				return i + 1;
		}
		return -1;
	}

	// returns index from position name
	private static int desPos(String p) {
		return Character.getNumericValue(p.charAt(1));
	}
	
	public String toString() {
		String x = "";
		for (int i = 0; i<size; i++){
			x = x.concat(" | "+arr[i]+" "+arr[i].element()+" | ");
		}
		return x;
	}

	// Node and data is safe as inner class
	private class Node extends Position {

		public Node(int data, int pos) {
			position = pos;
			element = data;
		}


        public int getPosition(){
            return position;
        }

        public void setPosition(int p){
            position = p;
        }

        public void setElement(int e){
            element = e;
        }




        public String toString() {
			return "P"+position;
		}

	}

}
