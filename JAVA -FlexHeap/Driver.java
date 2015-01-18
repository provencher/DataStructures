public class Driver {

	public static void main(String[] args) throws Exception {
		
		FlexHeap x = new FlexHeap();

        System.out.println("\nAdding 1000000 random numbers to the heap\n");
		for (int i = 1; i <1000001 ; i++){

			x.insert((int)(Math.random()*99*i));
		}

		double time1 = System.nanoTime();
		x.switchMaxHeap();
		double time2 = System.nanoTime();
		x.switchMinHeap();
		double time3 = System.nanoTime();
		
		System.out.println("\nTime to convert to Max heap = "+((time2-time1)/(1.0E9))+" seconds."+"\nTime to convert to Min heap = "+((time3-time2)/(1.0E9))+" seconds\n");


        System.out.println("\nRemoving 40 numbers");
		for (int i = 1; i <41; i ++ ){
			System.out.print(x.remove() + " ");

		}


        System.out.println("\n");

		x.switchMaxHeap();

        System.out.println("\nRemoving 15 numbers");
		for (int i = 1; i <16; i ++ ){
            System.out.print(x.remove() + " ");

		}

        System.out.println("\n");

        System.out.println("\nAdding 27 random number");
        for (int i = 1; i <28 ; i++){
            int num = (int)(Math.random()*99*i);
            System.out.print(num + " ");
            x.insert(num);
        }

        System.out.println("\n");

		x.switchMinHeap();

        System.out.println("\nRemoving 34 numbers");
		for (int i = 1; i <35; i ++ ){
            System.out.print(x.remove() + " ");

		}


	}

}
