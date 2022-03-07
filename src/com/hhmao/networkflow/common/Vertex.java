package com.hhmao.networkflow.common;

import java.util.*;

public class Vertex<V> {
    // entry of vertex, e.g. task
    protected V entry;
    protected Set<Edge<V>> outEdges;
    protected Set<Edge<V>> inEdges;

    public Vertex(V v) {
        this.entry = v;
        this.inEdges = new HashSet<>();
        this.outEdges = new HashSet<>();
    }

    public boolean addEdge(Edge<V> e) {
        boolean status = false;
        if(e.from == entry) {
            outEdges.add(e);
        }else if(e.to == entry){
            inEdges.add(e);
        }
        return status;
    }

    public void removeEdge(Edge<V> e) {
        inEdges.remove( e );
        outEdges.remove(e);
    }
}