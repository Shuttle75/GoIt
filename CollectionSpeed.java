import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * Created by shuttle on 23.06.16.
 */
public class CollectionSpeed {

    /************************************** ArrayList **************************************/

    public static long CheckArrayListAdd(int size) {
        long timeValue = 0;
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                arrayList.add(j, 1);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;

            arrayList.clear();
        }
        timeValue /= 100;
        return timeValue;
    }

    public static long CheckArrayListGet(int size) {
        long timeValue = 0;
        ArrayList arrayList = new ArrayList();

        for (int j = 0; j < size; j++) {
            arrayList.add(j, j);
        }

        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                arrayList.get(1000);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;
        }
        timeValue /= 100;
        return timeValue;
    }

    public static long CheckArrayListRemove(int size) {
        long timeValue = 0;
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < size; j++) {
                arrayList.add(j, 1);
            }

            Instant startedTime = Instant.now();
            for (int j = size - 1; j >= 0; j--) {
                arrayList.remove(j);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;
        }

        timeValue /= 100;
        return timeValue;
    }

    public static long CheckArrayListContains(int size) {
        long timeValue = 0;
        ArrayList arrayList = new ArrayList();

        for (int j = 0; j < size; j++) {
            arrayList.add(j, j);
        }
        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                arrayList.contains(0);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;
        }

        timeValue /= 100;
        return timeValue;
    }

    public static long CheckArrayListPopulate(int size) {
        long timeValue = 0;
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                arrayList.add(1);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;

            arrayList.clear();
        }
        timeValue /= 100;
        return timeValue;
    }

    public static long CheckArrayListIteratorAdd(int size) {
        long timeValue = 0;
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 100; i++) {
            ListIterator it = arrayList.listIterator();

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                it.hasNext();
                it.add(1);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;

            arrayList.clear();
        }
        timeValue /= 100;
        return timeValue;
    }

    public static long CheckArrayListIteratorRemove(int size) {
        long timeValue = 0;
        ArrayList arrayList = new ArrayList();
        for (int j = 0; j < size; j++) {
            arrayList.add(j, 1);
        }

        for (int i = 0; i < 100; i++) {
            ListIterator it = arrayList.listIterator();

            Instant startedTime = Instant.now();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;

            arrayList.clear();
        }
        timeValue /= 100;
        return timeValue;
    }

    /************************************** LinkedList **************************************/

    public static long CheckLinkedListAdd(int size) {
        long timeValue = 0;
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                linkedList.add(j, 1);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;

            linkedList.clear();
        }
        timeValue /= 100;
        return timeValue;
    }

    public static long CheckLinkedListGet(int size) {
        long timeValue = 0;
        LinkedList linkedList = new LinkedList();

        for (int j = 0; j < size; j++) {
            linkedList.add(j, j);
        }

        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                linkedList.get(1000);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;
        }
        timeValue /= 100;
        return timeValue;
    }

    public static long CheckLinkedListRemove(int size) {
        long timeValue = 0;
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < size; j++) {
                linkedList.add(j, 1);
            }

            Instant startedTime = Instant.now();
            for (int j = size - 1; j >= 0; j--) {
                linkedList.remove(j);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;
        }

        timeValue /= 100;
        return timeValue;
    }

    public static long CheckLinkedListContains(int size) {
        long timeValue = 0;
        LinkedList linkedList = new LinkedList();

        for (int j = 0; j < size; j++) {
            linkedList.add(j, j);
        }
        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                linkedList.contains(0);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;
        }

        timeValue /= 100;
        return timeValue;
    }

    public static long CheckLinkedListPopulate(int size) {
        long timeValue = 0;
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                linkedList.add(1);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;

            linkedList.clear();
        }
        timeValue /= 100;
        return timeValue;
    }

    public static long CheckLinkedListIteratorAdd(int size) {
        long timeValue = 0;
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 100; i++) {
            ListIterator it = linkedList.listIterator();

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                it.hasNext();
                it.add(1);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;

            linkedList.clear();
        }
        timeValue /= 100;
        return timeValue;
    }

    public static long CheckLinkedListIteratorRemove(int size) {
        long timeValue = 0;
        LinkedList linkedList = new LinkedList();

        for (int j = 0; j < size; j++) {
            linkedList.add(j, 1);
        }

        for (int i = 0; i < 100; i++) {
            ListIterator it = linkedList.listIterator();

            Instant startedTime = Instant.now();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;

            linkedList.clear();
        }
        timeValue /= 100;
        return timeValue;
    }

    /************************************** HashSet **************************************/

    public static long CheckHashSetAdd(int size) {
        long timeValue = 0;
        HashSet hashSet = new HashSet();

        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                hashSet.add(1);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;

            hashSet.clear();
        }
        timeValue /= 100;
        return timeValue;
    }

    public static long CheckHashSetRemove(int size) {
        long timeValue = 0;
        HashSet hashSet = new HashSet();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < size; j++) {
                hashSet.add(1);
            }

            Instant startedTime = Instant.now();
            for (int j = size - 1; j >= 0; j--) {
                hashSet.remove(j);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;
        }

        timeValue /= 100;
        return timeValue;
    }

    public static long CheckHashSetContains(int size) {
        long timeValue = 0;
        HashSet hashSet = new HashSet();

        for (int j = 0; j < size; j++) {
            hashSet.add(j);
        }
        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                hashSet.contains(0);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;
        }

        timeValue /= 100;
        return timeValue;
    }

    public static long CheckHashSetPopulate(int size) {
        long timeValue = 0;
        HashSet hashSet = new HashSet();

        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                hashSet.add(1);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;

            hashSet.clear();
        }
        timeValue /= 100;
        return timeValue;
    }

    /************************************** TreeSet **************************************/

    public static long CheckTreeSetAdd(int size) {
        long timeValue = 0;
        TreeSet treeSet = new TreeSet();

        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                treeSet.add(1);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;

            treeSet.clear();
        }
        timeValue /= 100;
        return timeValue;
    }

    public static long CheckTreeSetRemove(int size) {
        long timeValue = 0;
        TreeSet treeSet = new TreeSet();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < size; j++) {
                treeSet.add(1);
            }

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                treeSet.remove(0);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;
        }

        timeValue /= 100;
        return timeValue;
    }

    public static long CheckTreeSetContains(int size) {
        long timeValue = 0;
        TreeSet treeSet = new TreeSet();

        for (int j = 0; j < size; j++) {
            treeSet.add(j);
        }
        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                treeSet.contains(0);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;
        }

        timeValue /= 100;
        return timeValue;
    }

    public static long CheckTreeSetPopulate(int size) {
        long timeValue = 0;
        TreeSet treeSet = new TreeSet();

        for (int i = 0; i < 100; i++) {

            Instant startedTime = Instant.now();
            for (int j = 0; j < size; j++) {
                treeSet.add(1);
            }
            timeValue += Duration.between(startedTime, Instant.now()).toNanos() / 1000;

            treeSet.clear();
        }
        timeValue /= 100;
        return timeValue;
    }


    public static void CheckAll(int size) {
        System.out.println("Check speed in microsec, for " + size);
        System.out.println("          \tadd\t\t\tget\t\t\tremove\t\tcontains\tpopulate\titerator.add\titerator.remove");

        System.out.println("ArrayList \t"
                + CheckArrayListAdd(size) + "\t\t\t"
                + CheckArrayListGet(size) + "\t\t\t"
                + CheckArrayListRemove(size) + "\t\t\t"
                + CheckArrayListContains(size) + "\t\t\t"
                + CheckArrayListPopulate(size) + "\t\t\t"
                + CheckArrayListIteratorAdd(size) + "\t\t\t\t"
                + CheckArrayListIteratorRemove(size));

        System.out.println("LinkedList \t"
                + CheckLinkedListAdd(size) + "\t\t\t"
                + CheckLinkedListGet(size) + "\t\t\t"
                + CheckLinkedListRemove(size) + "\t\t\t"
                + CheckLinkedListContains(size) + "\t\t\t"
                + CheckLinkedListPopulate(size) + "\t\t\t"
                + CheckLinkedListIteratorAdd(size) + "\t\t\t\t"
                + CheckLinkedListIteratorRemove(size));

        System.out.println("HashSet \t"
                + CheckHashSetAdd(size) + "\t\t\t\t\t\t"
                + CheckHashSetRemove(size) + "\t\t\t"
                + CheckHashSetContains(size) + "\t\t\t"
                + CheckHashSetPopulate(size));

        System.out.println("TreeSet \t"
                + CheckTreeSetAdd(size) + "\t\t\t\t\t\t"
                + CheckTreeSetRemove(size) + "\t\t\t"
                + CheckTreeSetContains(size) + "\t\t\t"
                + CheckTreeSetPopulate(size));
    }

    public static void main(String[] args) {
        CheckAll(10000);
        CheckAll(100000);
        CheckAll(1000000);

    }
}


/*

Check speed in microsec, for 10000
          	add			get			remove		contains	populate	iterator.add	iterator.remove
ArrayList 	270			140			190		    290		    260		    430		        140
LinkedList 	460			22580		190 		210	    	250		    390		        30
HashSet 	310						320	    	360	    	260
TreeSet 	270						340		    560	    	250
Check speed in microsec, for 100000
          	add			get			remove		contains	populate	iterator.add	iterator.remove
ArrayList 	1080		0			260	    	110	    	570		    1370		    11490
LinkedList 	1630		215880		530	    	10	    	1600		1510		    30
HashSet 	840						1590		140	    	960
TreeSet 	610						210	    	4210		960
Check speed in microsec, for 1000000
          	add			get			remove		contains	populate	iterator.add	iterator.remove
ArrayList 	9690		10			4870		880		    5050		10960		    1681150
LinkedList 	11790		2151180		6120		0		    10600		13300		    100
HashSet 	6740					8260		970		    5140
TreeSet 	5120					1920		94470		4770

Process finished with exit code 0
 */