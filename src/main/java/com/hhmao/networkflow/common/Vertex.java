package com.hhmao.networkflow.common;

import java.util.HashSet;
import java.util.Set;

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

    Set<Edge<V>> getInEdges(){
        return inEdges;
    }

    Set<Edge<V>> getOutEdges(){
        return outEdges;
    }

    // todo: implement a method return a iterator with all edges
    Set<Edge<V>> getAllEdges(){
        Set<Edge<V>> allEdges = new HashSet<>(inEdges);
        allEdges.addAll(outEdges);
        return allEdges;
    }
}