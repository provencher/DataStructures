public class ArrayTree {

	int[] tree;

	int tailIndex;

	ArrayTree() { //default constructor for the array
		tree = new int[10]; //initializes at size 10
		tailIndex = 0; //puts tail index at 0 due to no elements
	}

	void swap(int index1, int index2) { //method that swaps two elements
		
		if(index1 <= 0){ //just precautions due to focus being divided by 2. (1/2 = .5 -> 0)
			index1 = 1;
		}
		if(index2 <= 0){
			index2 = 1;
		}

		int temp = tree[index1]; //very basic swap
		tree[index1] = tree[index2];
		tree[index2] = temp;
	}

	int getTail() { //method that returns index of the tail/last element
		return tailIndex;
	}

	int getElem(int index){ //method that returns the element based on the index
		return tree[index];
		

	}

	void remove() { //method that just places the last index on the first.


            tree[1] = tree[tailIndex]; //doesn't actually delete but decreases tail index.  can be overwritten later.
            tailIndex--;



	}

	void insert(int elem) { //inserts an element into the array, at the last index
		tailIndex++;
		tree[tailIndex] = elem;
		if (tailIndex + 2 >= tree.length) { //will check if the next insert will cause out of bounds and expands before
			expand();
		}
	}

	void expand() { //function to expand the array.
		int[] tmp = new int[tree.length * 2 + 10];

		for (int i = 1; i <= tailIndex; i++) {
			tmp[i] = tree[i];
		}

		tree = tmp;
	}

}
