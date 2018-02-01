package util;

import java.util.Arrays;
import java.util.Random;

/**
 * Contains tools used to automate the creation of test assets.
 */
public class TestAssetEngine<T> {

    private Random rand = new Random();
    public int upperBoundValue = Integer.MAX_VALUE;
    public int upperBoundSize = 100000;

    public TestAssetEngine() {}

    public TestAssetEngine(int upperBoundValue, int upperBoundSize) throws Exception {
        if(upperBoundValue == upperBoundSize) {
            throw new Exception("Upper bound values and size should not be equivalent.");
        }
        this.upperBoundValue = upperBoundValue;
        this.upperBoundSize = upperBoundSize;
    }

    public TestAssetEngine(TestAssetEngineBuilder builder) throws Exception {
        if(builder.upperBoundValue == builder.upperBoundSize) {
            throw new Exception("Upper bound values and size should not be equivalent.");
        }
        this.upperBoundValue = builder.upperBoundValue;
        this.upperBoundSize = builder.upperBoundSize;
    }

    /**
     * Generates a random signed integer.
     * @return the randomly generated integer.
     */
    public int generateRandomInteger() {
        return generateSign() ? this.rand.nextInt(upperBoundValue) : -1 * this.rand.nextInt(upperBoundValue);
    }

    /**
     * Generates a random signed integer given a specified upper bound.
     * @param bound the upper bound to use during integer generation.
     * @return the randomly generated integer.
     */
    public int generateRandomIntegerWithBound(int bound) {
        return generateSign() ? this.rand.nextInt(bound) : -1 * this.rand.nextInt(bound);
    }

    /**
     * Generates a random integer greater than or equal to 0 given a specified upper bound.
     * @param bound the upper bound to use during integer generation.
     * @return the randomly generated integer.
     */
    public int generateRandomPositiveIntegerWithBound(int bound) {
        return this.rand.nextInt(bound);
    }

    /**
     * Generates an array of randomly-generated unordered integers.
     * @return the generated array.
     */
    public int[] generateUnorderedIntegerArray() {
        int arraySize = 0;
        do {
            arraySize = this.rand.nextInt(this.upperBoundSize);
        } while(arraySize <= 0);
        int[] unorderedArr = new int[arraySize];
        for(int i = 0; i < unorderedArr.length; i++) {
            unorderedArr[i] = generateRandomInteger();
        }
        return unorderedArr;
    }

    /**
     * Generates an array of a given size of randomly-generated unordered integers.
     * @param size the size of the array.
     * @return the generated array.
     */
    public int[] generateUnorderedIntegerArrayOfSize(int size) {
        int[] unorderedArr = new int[size];
        for(int i = 0; i < unorderedArr.length; i++) {
            unorderedArr[i] = generateRandomInteger();
        }
        return unorderedArr;
    }

    /**
     * Generates an array of randomly-generated, unique, unordered integers.
     * @return the generated array.
     */
    public int[] generateUnorderedUniqueIntegerArray() {
        int arraySize = 0;
        do {
            arraySize = this.rand.nextInt(this.upperBoundSize);
        } while(arraySize <= 0);
        int[] unorderedArr = new int[arraySize];
        for(int i = 0; i < unorderedArr.length; i++) {
            int val = generateRandomInteger();
            while(containsInteger(unorderedArr, val)) {
                val = generateRandomInteger();
            }
            unorderedArr[i] = val;
        }
        return unorderedArr;
    }


    /**
     * Generates an array of randomly-generated ordered integers.
     * @return the generated array.
     */
    public int[] generateOrderedIntegerArray() {
        int arraySize = 0;
        do {
            arraySize = this.rand.nextInt(this.upperBoundSize);
        } while(arraySize <= 0);
        int[] orderedArr = new int[arraySize];
        for(int i = 0; i < orderedArr.length; i++) {
            orderedArr[i] = generateRandomInteger();
        }
        Arrays.sort(orderedArr);
        return orderedArr;
    }

    /**
     * Randomly chooses an integer-index pair from a given array.
     * @param arr the array to choose from.
     * @return the randomly chosen ItemIndex value.
     */
    public ItemIndex chooseRandomItemIndexFromArray(T[] arr) {
        int index = this.rand.nextInt(arr.length);
        return new ItemIndex(arr[index], index);
    }

    /**
     * Randomly generates an integer that does not exist in a given array.
     * @param arr the array to use for reference.
     * @return the randomly generated integer.
     */
    public int generateRandomIntegerNotInArray(int[] arr) {
        int value = generateRandomIntegerWithBound(upperBoundValue);
        while(Arrays.asList(arr).contains(value)) {
            value = generateRandomIntegerWithBound(upperBoundValue);
        }
        return value;
    }

    /**
     * Randomly generates a true or false value.
     * @return the generated boolean.
     */
    public boolean generateSign() {
        return this.rand.nextInt(2) == 0 ? true : false;
    }

    /**
     * Determines whether or not an array contains a given integer.
     * @param arr the array to search.
     * @param val the integer value to search for
     * @return true if the array contains the integer, false if otherwise.
     */
    private boolean containsInteger(int[] arr, int val) {
        for(Integer item : arr) {
            if(item == val) {
                return true;
            }
        }
        return false;
    }

    /**
     * Builder class used to quickly instantiate parameter boundaries for test assets.
     */
    public static class TestAssetEngineBuilder {

        public int upperBoundValue = Integer.MAX_VALUE;
        public int upperBoundSize = 100000;

        public TestAssetEngineBuilder upperBoundValue(int upperBoundValue){
            this.upperBoundValue = upperBoundValue;
            return this;
        }

        public TestAssetEngineBuilder upperBoundSize(int upperBoundSize) {
            this.upperBoundSize = upperBoundSize;
            return this;
        }

    }

}
