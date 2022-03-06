package com.hhmao.networkflow.common;

public class Edge<V> {
    protected Vertex<V> from;
    protected Vertex<V> to;
    protected double weight;

    public Edge(Vertex<V> from, Vertex<V> to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Edge(Vertex<V> from, Vertex<V> to) {
        this(from, to, 0);
    }

    public Vertex<V> getSource() {
        return this.from;
    }

    public Vertex<V> getDestination() {
        return this.to;
    }

    public double getWeight() {
        return this.weight;
    }
}