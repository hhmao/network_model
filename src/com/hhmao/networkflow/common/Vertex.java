package com.hhmao.networkflow.common;

import java.util.*;

public class Vertex<V> {

    // entry of vertex, e.g. task
    protected V entry;
    protected List<Edge<V>> edges;

    public Vertex(V v) {
        this.entry = v;
        this.edges = new LinkedList<>();
    }

    public boolean addEdge(Edge<V> e) {
        if(getEdge(e.getDestination()) == null) {
            edges.add(e);
            return true;
        }
        return false;
    }

    public Edge<V> getEdge(Vertex<V> dest) {
        Edge<V> ret = null;
        if(dest != null) {
            for(Edge<V> edge : edges) {
                if(edge.getDestination() != null &&
                        dest.equals(edge.getDestination())) {
                    ret = edge;
                    break;
                }
            }
        }
        return ret;
    }


    public Edge<V> removeEdge(Vertex<V> dest) {
        Edge<V> ret = getEdge(dest);
        if( ret == null ){
            return null;
        }
        edges.remove(ret);
        return ret;
    }
}