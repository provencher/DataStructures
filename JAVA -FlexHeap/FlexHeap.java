public class FlexHeap {

    boolean min = true; // to know what kind of heap it is
    ArrayTree arrayTree; // the object arraytree

    FlexHeap() { // constructor that constructs the heap
        arrayTree = new ArrayTree();
    }

    void insert(int elem) { // method to insert into array
        arrayTree.insert(elem);
        upBalance(); // calls to balance tree using up bubbling
    }

    int remove() { // removes the first elemnt of the array (either min or max)
        int j = arrayTree.getElem(1); // retrieves first element
        arrayTree.remove(); // removes it
        downBalance(1); // balances tree using downheap bubling
        return j; // returns first element
    }

    void toggleHeap() { // function that toggles the heap
        for (int j = arrayTree.getTail() / 2; j > 0; j--) { // calls the balance
            // n/2 times.

            downBalance(j);
            // this is essentially bottom up
            // construction from class.
        }



    }

    void switchMinHeap() { // call to switch heap to min type
        if (min == false) {
            System.out.println("Current Structure: MaxHeap" );
            min = !min;
            toggleHeap();
            System.out.print(" - MinHeap Conversion complete\n");
        }
    }

    void switchMaxHeap() { // call to switch heap to max type
        if (min == true) {
            System.out.println("Current Structure: MinHeap" );
            min = !min;
            toggleHeap();
            System.out.print(" - MaxHeap Conversion Complete\n");
        }
    }

    void upBalance() { // method to balance after insert, up bubbling
        int focus = arrayTree.getTail();

        if (min == true) {// if min heap type
            while ((arrayTree.getElem(focus / 2) > arrayTree.getElem(focus)) && (focus != 0)) { // conditions
                // if
                // one
                // above
                // is
                // smaller
                arrayTree.swap(focus, focus / 2); // then swap
                focus = focus / 2; // continue and check while condition
            }
        } else { // same but for max heap type

            while ((focus / 2 > 0) && arrayTree.getElem(focus / 2) < arrayTree.getElem(focus)) {
                arrayTree.swap(focus, focus / 2);
                focus = focus / 2;
            }
        }

    }

    void downBalance(int focus) { // method to balance after removal and for
        // construction

        if (min == true) { // for the min heap type

            while (((focus * 2 <= arrayTree.getTail())) && ((arrayTree.getElem(focus) > arrayTree.getElem(focus * 2)) || (arrayTree.getElem(focus) > arrayTree.getElem(focus * 2 + 1)))) {

               // conditions, if parent is bigger than child -> continue
                if (arrayTree.getElem(focus * 2) > arrayTree.getElem(focus * 2 + 1)&& focus * 2 + 1 <= arrayTree.getTail()) {

                    focus = focus * 2 + 1;
                    // if child1 > child2 and number not out of bounds
                } else
                    focus = focus * 2;
                arrayTree.swap(focus, focus / 2); // swaps parent which is not
                // focus/2 and child(focus

            }

        } else { // same but for max
            while (focus * 2 <= arrayTree.getTail()
                    && (arrayTree.getElem(focus) < arrayTree.getElem(focus * 2) || arrayTree
                    .getElem(focus) < arrayTree.getElem(focus * 2 + 1))) {
                if (arrayTree.getElem(focus * 2) < arrayTree
                        .getElem(focus * 2 + 1)
                        && focus * 2 + 1 <= arrayTree.getTail()) {
                    focus = focus * 2 + 1;
                } else
                    focus = focus * 2;
                arrayTree.swap(focus, focus / 2);

            }
        }

    }

    public String toString() {
        String y = new String();
        for (int i = 1; i <= arrayTree.getTail(); i++) {

            y = y + "|| " + arrayTree.getElem(i);

        }
        return y;
    }
}
