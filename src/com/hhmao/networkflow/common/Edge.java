package com.hhmao.networkflow.common;

public class Edge<V> {
    protected V from;
    protected V to;
    protected double weight;

    public Edge(V from, V to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Edge(V from, V to) {
        this(from, to, 0);
    }

    public V getSource() {
        return this.from;
    }

    public V getDestination() {
        return this.to;
    }

    public double getWeight() {
        return this.weight;
    }
}