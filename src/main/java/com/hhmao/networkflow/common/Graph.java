package com.hhmao.networkflow.common;

public interface Graph<V> {

    public void addVertex(V v);

    public void addEdge(Edge<V> e);

    public V remove(V v);

    public Edge<V> remove(Edge<V> e);
}