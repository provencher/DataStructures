/**
 * Created by Eric on 21/10/14.
 */

public class Driver {
    public static void main (String[] args) throws Exception{

    	List x = new List();
    	System.out.println("Generating list with doubling expansion rule");

        System.out.println("\nAdd last : 12");
    	x.addLast(12);

        System.out.println("\nAdd first : 1");
        x.addFirst(1);


    	System.out.println("\nCurrent size : " + x.showSize());

        System.out.println("\nAdd 3 before P2");
    	x.addBefore("P2", 3);

        System.out.println("\nAdd 15 after P3");
    	x.addAfter("P3", 15);


        System.out.println("\nAdd 20 then 30 at the end");
    	x.addLast(20);
    	x.addLast(30);


    	System.out.println("\nCurrent size : " +x.showSize());

        System.out.println("\nCurrent list:");
    	System.out.println(x.toString());


        System.out.println("\nSwap values P3 and P5");
    	x.swap("P3", "P5");

        System.out.println("\nCurrent list:");
    	System.out.println(x.toString());


        System.out.println("\nAdd 4 after P6");
    	x.addAfter("P6",4);

        System.out.println("\nAdd 10 at the beginning");
    	x.addFirst(10);

    	System.out.println("\nCurrent size : " +x.showSize());
    	
    	System.out.println(x.toString());
    	x.addLast(10);
    	
    	System.out.println(x.showSize());


        System.out.println("\nCurrent list:");
    	System.out.println(x.toString());

        System.out.println("\nTruncate list");
    	x.truncate();
    	
    	System.out.println("\nCurrent size : " +x.showSize());

        System.out.println("\nCurrent list:");
    	System.out.println(x.toString());


        System.out.println("\nDelete element at P1");
    	x.delete("P1");

        System.out.println("\nCurrent list:");
        System.out.println(x.toString());
    	System.out.println("\nCurrent size : " + x.showSize());


        System.out.println("\nSwitch to constant expansion mode");
        x.SetExpansionRule('c');

        System.out.println("\nAdd 5 at the end of the list");
        x.addLast(5);
        System.out.println("\nCurrent list:");
        System.out.println(x.toString());
        System.out.println("\nCurrent size : " + x.showSize());

        System.out.println("\nCreating new list with doubling expansion mode");

        List y = new List();

        System.out.println("\nStress testing list --  Add 10 000 numbers to end of list");

        long timeCheck1 = System.currentTimeMillis();


        for(int i =0; i<10000; i++){
            y.addLast(i);
        }

        long timeCheck2 = System.currentTimeMillis();


        System.out.println("\nTime to execute: "+ (timeCheck2 - timeCheck1)+" milliseconds");



        System.out.println("\nCreating new list with constant expansion mode");

        List z = new List();
        z.SetExpansionRule('c');

        System.out.println("\nStress testing list --  Add 10 000 numbers to end of list");

        timeCheck1 = System.currentTimeMillis();


        for(int i =0; i<10000; i++){
            z.addLast(i);
        }

        timeCheck2 = System.currentTimeMillis();


        System.out.println("\nTime to execute: "+ (timeCheck2 - timeCheck1)+" milliseconds");







    }
    
}
