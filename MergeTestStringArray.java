import java.util.*;

public class MergeTestStringArray
{


    public static void main(String[] args)
    {
        ArrayList< String > array = new ArrayList< String >();

        array.add("John");
        array.add("Victor");
        array.add("Joe");
        array.add("Jackson");
        array.add("Anthony");
        array.add("Angelina");
        array.add("George");
        array.add("Paul");

        ArrayList< String > sortedArray = new ArrayList< String >();

        sortedArray = mergeSort(array);

        for (int i = 0; i < sortedArray.size(); i++)
        {
            System.out.println(" " + sortedArray.get(i) );
        }
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

            System.out.println("Left Array: " + left);
            System.out.println("Right Array)" + right);

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
        int l = 0;
        int r = 0;

        while (l < left.size() && r < right.size())
        {
            if ((left.get(l)).compareTo(right.get(r)) < 0)
            {
                merged.add(left.get(l));
                l++;
            }
            else
            {
                merged.add(right.get(r));
                r++;
            }

            i++;
        }


        while (l < left.size())
        {
            merged.add(left.get(l));
            l++;
            i++;
        }

        // Append rest of the values in the right half, if any...
        while (r < right.size())
        {
            merged.add(right.get(r));
            r++;
            i++;
        }

        return merged;


    }

}