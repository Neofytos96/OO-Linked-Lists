//C1615033
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
public class questionA {
       static ArrayList<Integer> timerArrayMerge = new ArrayList<Integer>();
     static int counterSwapsBubble=0;
     static int counterComparisonsBubble=0;
     static int counterComparisonsMerge=0;
     static int counterSwapsMerge=0;


    public static void main(String[] args) throws Exception {
        ArrayList<String> unsortedList = parseData("data.txt");
        ArrayList<Long> timerBubble = new ArrayList<>();
        ArrayList<Long> timerMerge = new ArrayList<>();
        ArrayList<Integer> swapsBubble = new ArrayList<>();
        ArrayList<Integer> comparisonsBubble = new ArrayList<>();
        ArrayList<Integer> swapsMerge = new ArrayList<>();
        ArrayList<Integer> comparisonsMerge = new ArrayList<>();
        long averagetimeBubble = 0;
        int averageSwapsBubble = 0;
        int averageComparisonsBubble = 0;
        long averagetimeMerge = 0;
        int averageSwapsMerge = 0;
        int averageComparisonsMerge = 0;


        System.out.println('\n'+ "Results for bubble sort algorithm: "+'\n');
        //run bubble sort for 100,200...1000 words for 10 times each to get the average
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                long startTimeBubble = System.nanoTime();
                bubbleSort(new ArrayList<String>(unsortedList.subList(0, i * 100)));
                long endTimeBubble = System.nanoTime();
                averagetimeBubble += ( (endTimeBubble - startTimeBubble));
                averageComparisonsBubble += counterComparisonsBubble;
                averageSwapsBubble += counterSwapsBubble;
            }
            timerBubble.add(averagetimeBubble/10);
            averagetimeBubble=0;
            comparisonsBubble.add(averageComparisonsBubble/10);
            averageComparisonsBubble=0;
            swapsBubble.add(averageSwapsBubble/100);
            averageSwapsBubble=0;
        }
        System.out.println("Timer BUbble sort: "+timerBubble);
        System.out.println("Comparisons Bubble Sort: "+comparisonsBubble);
        System.out.println("Swaps Bubble sort: "+swapsBubble);
        System.out.println("Sorted list: "+bubbleSort(unsortedList));
        System.out.println('\n'+ "Results for merge sort algorithm: "+'\n');
//            }
        //        run merge sort for 100,200...1000 words in a list
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
//                if (i % 100 == 0 && i > 0) {
                long startTimeMerge = System.nanoTime();
                mergeSort((new ArrayList<String>(unsortedList.subList(0, i * 100))));
                long endTimeMerge = System.nanoTime();
                averagetimeMerge += ( (endTimeMerge - startTimeMerge));
                averageComparisonsMerge += counterComparisonsMerge;
                averageSwapsMerge += counterSwapsMerge;
            }
            timerMerge.add(averagetimeMerge/10);
            averagetimeMerge=0;
            comparisonsMerge.add(averageComparisonsMerge/10);
            averageComparisonsMerge=0;
            swapsMerge.add(averageSwapsMerge/10);
            averageSwapsMerge=0;
        }
        System.out.println("Timer Merge sort: "+timerMerge);
        System.out.println("Comparisons Merge Sort: "+comparisonsMerge);
        System.out.println("Swaps Merge sort: "+swapsMerge);
        System.out.println("Sorted list: "+mergeSort(unsortedList));

    }


    public static ArrayList parseData(String data) throws IOException {
        ArrayList<String> list = new ArrayList<String>();

        File file = new File(data);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            list.add(st);
        }
        List<String> myList = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < Arrays.asList(list.get(i).split(" ")).size(); j++) {

                if (Arrays.asList(list.get(i).split(" ")).get(j).length() > 3 &&
                        Arrays.asList(list.get(i).split(" ")).get(j).matches("[a-zA-Z]+")) {

                    myList.add(Arrays.asList(list.get(i).split(" ")).get(j).toLowerCase());

                } else if (myList.size() == 1000) {
                    break;
                }
            }
            if (myList.size() == 1000) {
                break;
            }

        }
        return (ArrayList) myList;
    }


    public static ArrayList< String > mergeSort(ArrayList< String > list)
    {


        ArrayList < String > sorted = new ArrayList< String >();
        if (list.size() == 1)
        {
            sorted = list;
        } else {
            int mid1 = list.size() /2;

            ArrayList< String > left = new ArrayList< String >();
            ArrayList< String > right = new ArrayList< String >();

            for ( int x = 0; x < mid1; x++) {
                left.add(list.get(x));
            }
            for ( int x = mid1; x < list.size(); x++) {
                right.add(list.get(x));
            }

            left = mergeSort(left);
            right = mergeSort(right);
            sorted = mergeArray(left,right);
        }

        return sorted;
    }

    private static ArrayList< String > mergeArray(ArrayList< String > left, ArrayList< String > right)
    {
        ArrayList< String > merged = new ArrayList< String >();

        int i = 0;
        int leftElement = 0;
        int rightElement = 0;

        while (leftElement < left.size() && rightElement < right.size())
        {   counterComparisonsMerge++;
            if ((left.get(leftElement)).compareTo(right.get(rightElement)) < 0)
            {   counterSwapsMerge++;
                merged.add(left.get(leftElement));
                leftElement++;
            }
            else
            {
                merged.add(right.get(rightElement));
                rightElement++;
            }
            i++;
        }
        while (leftElement < left.size())
        {
            merged.add(left.get(leftElement));
            leftElement++;
            i++;
        }
        while (rightElement < right.size())
        {
            merged.add(right.get(rightElement));
            rightElement++;
            i++;
        }
        return merged;
    }
    public static ArrayList bubbleSort( ArrayList<String> A) throws IOException {
        int n = A.size();
        int limit = n - 1;
        int done = 0;

        while (done ==0){
            done = 1;
            for (int j=0; j < limit; j++){
                counterComparisonsBubble++;
                if (A.get(j+1).compareTo(A.get(j))<0){
                    String temp = A.get(j);
                    A.set(j, A.get(j+1));
                    A.set(j+1, temp);
                    counterSwapsBubble++;
                    done = 0;

                }
            }
        } return A;
    }




    }