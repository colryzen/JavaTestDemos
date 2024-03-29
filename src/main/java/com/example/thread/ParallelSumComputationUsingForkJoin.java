package com.example.thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ParallelSumComputationUsingForkJoin {
    private static final int[] LARGE_ARR = largeArr();

    private static final int LENGTH = LARGE_ARR.length;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RecursiveSumTask recursiveTask = new RecursiveSumTask(0, LENGTH, LARGE_ARR);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        long start = System.currentTimeMillis();
//        long sum = forkJoinPool.invoke(recursiveTask);
//        System.out.println("The sum is : "
//                + sum
//                + ", Time Taken by Parallel(Fork/Join) Execution: "
//                + (System.currentTimeMillis() - start) + " millis");

        ParallelSumComputationUsingForkJoin forkJoin= new ParallelSumComputationUsingForkJoin();
        forkJoin.sumUsingParallel();

    }

    private static int[] largeArr() {
        return new Random().ints(500000000, 10, 1000).toArray();
    }

    static class RecursiveSumTask extends RecursiveTask<Long> {

        private static final int SEQUENTIAL_COMPUTE_THRESHOLD = 4000;
        private final int startIndex;
        private final int endIndex;
        private final int[] data;

        RecursiveSumTask(int startIndex, int endIndex, int[] data) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.data = data;
        }

        @Override
        protected Long compute() {
            if (SEQUENTIAL_COMPUTE_THRESHOLD >= (endIndex - startIndex)) {
                long sum = 0;
                for (int i = startIndex; i < endIndex; i++) {
                    sum += data[i];
                }
                return sum;
            }
            int mid = startIndex + (endIndex - startIndex) / 2;
            RecursiveSumTask leftSumTask = new RecursiveSumTask(startIndex, mid, data);
            RecursiveSumTask rightSumTask = new RecursiveSumTask(mid, endIndex, data);
            leftSumTask.fork(); // Fork the Left Task in a Separate Execution
            long rightSum = rightSumTask.compute(); // Compute the Right Part
            long leftSum = leftSumTask.join(); // Wait for the results from the Left Part
            return leftSum + rightSum; // Return Both
        }
    }


    public long sumUsingParallel() {
        return LongStream.rangeClosed(1L, 10L)
                .parallel()
                .peek(this::printThreadName)
                .reduce(0L, this::printSum);
    }

    public void printThreadName(long l) {
        String tName = Thread.currentThread().getName();
        System.out.println("---- "+ tName + "--- offers:" + l);
    }

    public long printSum(long i, long j) {
        long sum = i + j;
        String tName = Thread.currentThread().getName();
        String sptf=String.format("==> %s has: %d; plus: %d; result: %d ",tName, i, j, sum);
        System.out.println(sptf);
        return sum;
    }

}
/**
 * Output:
 * The sum is : 252235235953, Time Taken by Parallel(Fork/Join) Execution: 139 millis
 */



