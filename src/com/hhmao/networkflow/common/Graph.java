package com.hhmao.networkflow.common;

public interface Graph<V> {

    public int addVertex(Vertex< V> v);

    public void addEdge(Edge<V> e);

    public Vertex<V> remove(Vertex<V> v);

    public Edge<V> remove(Edge<V> e);
}