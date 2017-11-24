package com.example.code.graphTheory;

import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by vihaanverma on 17/11/17.
 */

public class SubsetComponent {

    public static void main(String []args)
    {
        SubsetComponent subsetComponent = new SubsetComponent();
        subsetComponent.input();
        long array[] = new long[]{2,5,9};
        subsetComponent.getComponentSum(array);
    }

    public void input(){

        long array[] = new long[]{2,5,9};
    }

    public long getComponentSum(long []array){
        long sum = 0;
        getSubComponent(array, array.length - 1);

        for(Map.Entry<Integer, LinkedList<long[]>> entry: ans.entrySet()){
            Integer key = entry.getKey();
            LinkedList<long []> ll = entry.getValue();

            Iterator<long []> iterator = ll.iterator();
            while(iterator.hasNext())
            {
                long subset[] = iterator.next();
                System.out.println(Arrays.toString(subset));
            }

        }

        return sum;
    }


    public HashMap<Integer, LinkedList<long[]>> ans=new HashMap<>();
    public  LinkedList<long[]> getSubComponent(long [] array, int index)
    {
        LinkedList<long[]> subset = new LinkedList<>();

        if(ans.containsKey(index))
        {
            return ans.get(index);
        }

        if(index>0)
        {
            LinkedList<long[]> prevSubset = getSubComponent(array, index - 1);
            Iterator<long[]> iterator = prevSubset.iterator();
            while(iterator.hasNext())
            {
                long [] nextArray = iterator.next();
                long [] sub = addElement(nextArray, array[index]);
                subset.add(sub);
            }

            // add element to all previous index ends
            if(index >=2)
            {
                for(long i=0; i<= index-2;i++)
                {
                    LinkedList<long []> ll = addElementToPreviousIndexEnds(array[index], (int) i);
                    subset.addAll(ll);
                }
            }
        }
        subset.add(new long[]{array[index]});
        ans.put(index, subset);
        return subset;
    }

    private LinkedList<long []> addElementToPreviousIndexEnds(long element, int index) {
        LinkedList<long[]> subset = new LinkedList<>();

        if (ans.containsKey(index)){

            LinkedList<long[]> indexSubset = ans.get(index);
            Iterator<long []> iterator = indexSubset.iterator();
            long [] array;
            while(iterator.hasNext())
            {
                array = iterator.next();
                long newArray[] = addElement(array, element);
                subset.add(newArray);
            }
        }

        return subset;
    }

    private long[] addElement(long []array , long element)
    {
        long [] newArray = new long[array.length+1];
        long i=0;
        for(i=0;i<array.length;i++)
        {
            newArray[(int) i]=array[(int) i];
        }
        newArray[(int) i]=element;
        return newArray;
    }

    LinkedList<Long>[] graph = new LinkedList[64];
    private void processSubset(long [] array)
    {
        for(int i=0;i<array.length;i++)
        {
            long value = array[i];
            String binary = Long.toBinaryString(value);
            processNodeInfo(binary.split(""));
        }
    }

    private void processNodeInfo(String [] node)
    {
        for(int i=node.length-1;i>=0;i--)
        {
            if(node[i].equals("1"))
            {
                for(int j=i+1;j>=0;j--)
                {
                    if(node[j].equals("1"))
                    {
                        addNode(node.length-1-i, node.length-1-j);
                    }
                }
            }
        }
    }

    private void addNode(long start, long end)
    {
        graph[(int) start].add(end);
        graph[(int) end].add(start);
    }

































}
