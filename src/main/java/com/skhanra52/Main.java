package com.skhanra52;

import com.skhanra52.practiceArrayList.GroceryItems;

import java.util.*;

final class Fruit {
    String name;
    Fruit(String name) { this.name = name; }
    public String toString() { return name; }
}

public class Main {
    public static void main(String[] args) {

//******************Initializing Array and Traversing array************************
//        int[] sampleArr = new int[6];
//        sampleArr[0] = 5;
//        sampleArr[1] = 10;
//        sampleArr[2] = 11;
//        sampleArr[3] = -1;
//        sampleArr[4] = 2;
//        sampleArr[5] = 3;
//        sampleArr[6] = 15; // this will give out of bounds error

//        Or we can add the items like below if we already know the elements,
//        in this case we don't have to mention the array size
        int[] sampleArr = new int[] {5,10,11,-1,2,3,15};
        System.out.println("Printing array elements with respective indexes");
//         Traditional for loop
        for(int i=0; i<sampleArr.length; i++){
            System.out.println("Item at "+i +" is "+sampleArr[i]);
        }

//**********For each loop or enhanced for loop***********
        for(int item : sampleArr){
            if(item == 11){
                System.out.println("Item "+item +" found in the array");
            }
        }

//********** Creating an unassigned array and assign the values from the for loop**************
        int[] initialArray;
        initialArray = new int[10];

        for(int i=0;i<initialArray.length;i++){
            initialArray[i] = i+1;
        }
        System.out.println("Array elements are "+ Arrays.toString(initialArray));

//*************Initializing and Traversing 2D array*************************
        int[][] sampleArr2;
        sampleArr2= new int[][] {{5},{10},{11,20,30,50},{-1},{2},{3},{15}};
        for(int[] item : sampleArr2) {
            for (int innerItem : item) {
                if (innerItem == 11) {
                    System.out.println("Item " + innerItem + " found in the array");
                }
                    System.out.println("InnerItem "+innerItem);
            }
        }
//***********printing the random array*******************************
        int[] samArray = getRandomArray(10);
//        for(int i=0;i<samArray.length;i++){
//            System.out.println("Element at "+i+" "+samArray[i]);
//        }
//        System.out.println("Random Array "+Arrays.toString(samArray));
//************Sorting the random array*******************************
        Arrays.sort(samArray);
//        System.out.println("Sorted Array " +Arrays.toString(samArray));

//***********filling array with particular number*********************
        Arrays.fill(samArray, 5);
//        System.out.println("Filled array "+Arrays.toString(samArray));

//****************Copying an array*************************************
        int[] secondArray = getRandomArray(13);
//        System.out.println("Second array "+Arrays.toString(secondArray));

        int[] thirdArray = Arrays.copyOf(secondArray, secondArray.length);
//        System.out.println("Third array "+Arrays.toString(thirdArray));
//        System.out.println("Binary "+binarySearch(thirdArray, 10));
        Arrays.sort(thirdArray);
//        System.out.println("Sorted third array "+Arrays.toString(thirdArray));
//***************References vs value types: Understanding array memory and method call****
        int[] myIntArray = new int[5];
        int[] anotherArray = myIntArray;
//        System.out.println("myIntArray" +Arrays.toString(myIntArray));
//        System.out.println("anotherArray" +Arrays.toString(anotherArray));

        anotherArray[0] = 1;
        modifyArray(myIntArray);
//        System.out.println("myIntArray" +Arrays.toString(myIntArray));
//        System.out.println("anotherArray" +Arrays.toString(anotherArray));

//**********************example of ArrayList starts here************************
        GroceryItems[] groceryItems = new GroceryItems[3];
        groceryItems[0] = new GroceryItems("milk");
        groceryItems[1] = new GroceryItems("Apple", "Product", 6);
        groceryItems[2] = new GroceryItems("Orange", "Product", 10);
//        System.out.println("Grocery Items"+Arrays.toString(groceryItems));

        ArrayList<GroceryItems> objectList = getGroceryItems(groceryItems);
        System.out.println("Object list "+objectList);
//        for(GroceryItems item: objectList){
//            System.out.println("Items are: "+item);
//        }
        System.out.println("Third element in the objectList " + objectList.get(2));

        List<Fruit> list = List.of(new Fruit("Apple"), new Fruit("Banana"));
        ArrayList<Fruit> objectListFruit = new ArrayList<>(list);

        list.get(0).name = "Changed"; // modify original object
//        list.add(new Fruit("Kiwi")); // we can not add entire element like this
        objectListFruit.add(new Fruit("Kiwi"));

        System.out.println("List "+list);
        System.out.println("ArrayList "+objectListFruit); // [Changed, Banana] ❌ (shallow copy)

        // Sliding window example
        List<Integer> nums = new ArrayList<>();
        nums = List.of(-2,1,-3,4,-1,2,1,-5,4);
//        maxSumSubSet(nums);
//        findMinSumSubArr(nums);
        List<Integer> samNums = List.of(2,7,11,15, 5,4);
        towSum(samNums,9);

    }

    private static ArrayList<GroceryItems> getGroceryItems(GroceryItems [] groceryItems) {

//********Here is the difference between List.of(array) and Arrays.asList(array)*************
        // ArrayList<GroceryItems> objectList = new ArrayList<>();
        // converting groceryItems which is an Array to an immutable list
        // (cannot add, remove, or replace elements).
        // No nulls allowed → if any element is null, it throws NullPointerException.
        // immutable, modern, safe for constants.
        // List<GroceryItems> list = List.of(groceryItems);
        // This is how we can make it mutable by converting the immutable list to mutable ArrayList<>()
        // ArrayList<GroceryItems> objectList = new ArrayList<>(list);
        // or
        // ArrayList<GroceryItems> objectList = new ArrayList<>(java.util.List.of(groceryItems));
        //example of ******* Arrays.asList() ******************************
        // Creates a fixed-size list backed by the array.
        // We can update the list using set(index, new GroceryItems()).
        // But you cannot change the size (no add/remove)
        // fixed-size, but elements replaceable, tied to the array.
        List<GroceryItems> list = Arrays.asList(groceryItems);
        ArrayList<GroceryItems> objectList = new ArrayList<>(list);
        objectList.add(new GroceryItems("Curd"));
        objectList.add(new GroceryItems("Banana", "PRODUCT", 50));
        objectList.add(new GroceryItems("Coconut", "PRODUCT", 100));
        return objectList;
    }


    public static int[] getRandomArray(int len){
        Random random = new Random();
        int[] newInt = new int[len];
        for(int i=0;i<len;i++){
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }

    public static int binarySearch(int[] nums, int element){
        int left = 0;
        int right = nums.length -1;
        while(left<right){
            // start from left and go half the distance
            // of total considered length (right - left)/2.
            int mid = left + (right - left) / 2;
            System.out.println("Mid "+mid);
            if(element == nums[mid]){
                return mid;
            }else if(element<nums[mid]){
                right = mid - 1;
            }else{
                left = mid +  1;
            }
        }
        return -1;
    }

    public static void modifyArray(int[] arr){
        arr[1] = 2;
    }

    // Sliding window patterns
    // 1. Fixed Sliding window (commonly used if the required window size is know in advanced)
    // commonly asked find sub_array or sub_strings of a fixed length where window_size = 3 or some other number.
    // 2. Dynamic sliding window
    // Find longest or shortest subArray/subString that satisfy the condition
    // (maximum sum of sub array)
    // Input : 3,2,-1,6,7,5);
    // Below is the example of Dynamic Sliding window.
//    public static void subSet(List<Integer> nums) {
//        int maxSum = nums.get(0);
//        List<Integer> maxArr = new ArrayList<>();
//
//        for (int i = 0; i < nums.size(); i++) {
//            int currentSum = 0;
//            List<Integer> tempArr = new ArrayList<>();
//
//            for (int j = i; j < nums.size(); j++) {
//                currentSum += nums.get(j);
//                tempArr.add(nums.get(j));
//
//                if (currentSum > maxSum) {
//                    maxSum = currentSum;
//                    maxArr = new ArrayList<>(tempArr);
//                }
//            }
//        }
//
//        System.out.println("Max Subset Array: " + maxArr);
//        System.out.println("Max Subset Sum: " + maxSum);
//    }

    // here is the generic template to solve fixed sliding window related problems for a
    // window of size k.
    // --------------------------------
    // initialize window_sum = 0;
    // initialize max_result (or other required value)
    // setup initial window
    // for i from 0 to k-1;
    //      window_sum += arr[i];
    // max_result = window_sum // initialize result
    // slide the window across the array
    // for i from k to arr.length - 1
    //      window_sum += arr[i] - arr[i-k] // add new element and remove old element
    //      update max_result (or other computation)
    // return max_result;


//---------------Kadane'S ALGORITHM--------------------------------------------------
    // (Kadane's Algorithm) :
    // Prefer below solution when it comes to maximum sum of sub-array or minimum sum
    // of contiguous sub-array
    // for maximum sum of contiguous sub-array reset the currentSum<0;
    // for minimum sum of contiguous sub-array reset the currentSum>0;

    // Input: -2,1,-3,4,-1,2,1,-5,4
    public static void maxSumSubSet(List<Integer> nums){
        int maxSum = nums.get(0); // initialize to max sum to 1st element
        int currentSum = 0;
        List<Integer> tempArr = new ArrayList<>();
        for(int i=0;i<nums.size();i++){
            currentSum += nums.get(i);
            tempArr.add(nums.get(i));
            if(maxSum<currentSum){
                maxSum = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
                tempArr.clear();
            }
            System.out.println("Temp Array "+tempArr);
            System.out.println("Current Sum "+currentSum);
            System.out.println("max Sum "+maxSum);
        }
        System.out.println("MaxSubset sum "+maxSum);
    }

    public static void findMinSumSubArr(List<Integer> nums){
        int minSum = nums.get(0);
        int currentSum = 0;
        ArrayList<Integer> subArr = new ArrayList<>();
        for(var i=0; i<nums.size(); i++){
            currentSum += nums.get(i);
            subArr.add(nums.get(i));
            if(currentSum<minSum){
                minSum = currentSum;
            }
            if(currentSum>0){
                currentSum = 0;
                subArr.clear();
            }
            System.out.println("Temp Array "+subArr);
            System.out.println("Current Sum "+currentSum);
            System.out.println("min Sum "+minSum);
        }
        System.out.println("Min Subset sum "+minSum);
    }
    // Two Sum problem using java;
    // Input : List<Integer> samNums = List.of(2,7,11,15,5,4); target = 9;
    public static void towSum(List<Integer> nums, int target){
        Map<Integer, Integer> hash = new HashMap<>();
        List<int[]>  resultPairs = new ArrayList<>();
        for(int i=0; i<nums.size(); i++){
            int diff = target - nums.get(i);
            if(hash.containsKey(diff)){
                resultPairs.add(new int[]{hash.get(diff),i});
                System.out.println(resultPairs);
            }
            hash.put(nums.get(i), i);
        }
        System.out.println("Final Array is: "+resultPairs);
    }
}