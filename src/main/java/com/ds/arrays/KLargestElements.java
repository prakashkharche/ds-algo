package com.ds.arrays;

/**
 * Created by prakash.vijay on 22/08/17.
 */
public class KLargestElements {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(4);
        int[] array = {10, 4, 5 ,1 ,2, 3, 7, 9, 11, 12 ,13, 0, 1 , 1 ,2 ,3};
        for (int a : array) {
            if (minHeap.isFull() && a > minHeap.peek()) {
                minHeap.delete();
            }
            if (a > minHeap.peek()) {
                minHeap.insert(a);
            }
        }
        minHeap.print();
    }


    static class MinHeap {
        private int[] elements;
        private int size;
        private int capacity;

        public MinHeap(int capacity) {
            this.capacity = capacity;
            this.elements = new int[capacity];
        }

        public int peek() {
            return elements[0];
        }

        public void print() {
            for (int i=0; i<size; i++) {
                System.out.println(elements[i]);
            }
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void insert(int element) {
            if (size == capacity) {
                return;
            }
            elements[size] = element;
            heapifyUp(size);
            size++;
        }

        private void heapifyUp(int index) {
            if (index == 0) {
                return;
            }
            int parentIndex = parentIndex(index);
            if (parentIndex < 0) {
                return;
            }
            if (elements[parentIndex] < elements[index]) {
                return;
            }
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }

        private void swap(int i1, int i2) {
            int temp = elements[i1];
            elements[i1] = elements[i2];
            elements[i2] = temp;
        }

        private int parentIndex(int index) {
            return (index - 1) / 2;
        }

        private int leftChildIndex(int index) {
            return (2 * index) + 1;
        }

        private int rightChildIndex(int index) {
            return (2 * index) + 2;
        }

        public int delete() {
            if (size == 0) {
                return -1;
            }
            int temp = elements[0];
            elements[0] = elements[size - 1];
            size--;
            heapifyDown(0);
            return temp;
        }

        private void heapifyDown(int index) {
            int leftChildIndex = leftChildIndex(index);
            int rightChildIndex = rightChildIndex(index);
            if (leftChildIndex > size && rightChildIndex > size) {
                return;
            }
            if (rightChildIndex > size) {
                if (elements[leftChildIndex] < elements[index]) {
                    swap(leftChildIndex, index);
                    heapifyDown(leftChildIndex);
                    return;
                }
                return;
            }

            if (elements[index] < elements[rightChildIndex] && elements[index] < elements[leftChildIndex]) {
                return;
            }

            if (elements[index] > elements[leftChildIndex] && elements[index] > elements[rightChildIndex]) {
                int smallestIndexAmongChildren = elements[leftChildIndex] < elements[rightChildIndex] ? leftChildIndex : rightChildIndex;
                swap(index, smallestIndexAmongChildren);
                heapifyDown(smallestIndexAmongChildren);
                return;
            }
            if (elements[index] < elements[leftChildIndex]) {
                swap(index, leftChildIndex);
                heapifyDown(leftChildIndex);
            } else {
                swap(index, rightChildIndex);
                heapifyDown(rightChildIndex);
            }
        }
    }
}
