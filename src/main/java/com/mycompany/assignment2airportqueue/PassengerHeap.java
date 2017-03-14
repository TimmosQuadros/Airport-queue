/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2airportqueue;



/**
 *
 * @author TimmosQuadros
 */
public class PassengerHeap implements PriorityQueue<Passenger> {

    private Passenger[] data;
    private int size = 0;

    public PassengerHeap(int capacity) {
        data = new Passenger[capacity];
    }

    public Passenger[] getData() {
        return data;
    }

    public void setData(Passenger[] data) {
        this.data = data;
    }

    private int parrentOf(int p) {
        return p / 2;
    }

    private int leftOf(int p) {
        return 2 * p;
    }

    private int rightOf(int p) {
        return 2 * p + 1;
    }

    private void swap(int n, int m) {
        data[0] = data[m];
        data[m] = data[n];
        data[n] = data[0];
    }

    @Override
    public void enqueue(Passenger item) {
        data[++size] = item;
        int index = size;
        while (parrentOf(index) > 0 && data[parrentOf(index)].compareTo(data[index]) > 0) {
            swap(parrentOf(index), index);
            index = parrentOf(index);
        }
    }

    private boolean isLeaf(int position) {
        if (position > size / 2) {
            return true;
        }
        return false;
    }

    private void heapify(int position) {
        if (isLeaf(position)) {
            return;
        }

        if (data[position].compareTo(data[leftOf(position)]) > 0 || data[position].compareTo(data[rightOf(position)]) > 0) {
            if (data[leftOf(position)].compareTo(data[rightOf(position)]) < 0) {
                swap(position, leftOf(position));
                heapify(leftOf(position));
            } else {
                swap(position, rightOf(position));
                heapify(rightOf(position));
            }
        }
    }

    @Override
    public Passenger dequeue() {
        Passenger removedPassenger = data[1];
        data[1] = data[size--];
        heapify(1);
        return removedPassenger;
    }

    @Override
    public Passenger peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return size;
    }

}
