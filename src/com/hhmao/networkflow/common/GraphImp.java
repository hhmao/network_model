package com.hhmao.networkflow.common;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class GraphImp<V> implements Graph<V>{

    protected LinkedList<Vertex<V>> vertices;
    protected Set<Edge<V>> edges;

    public GraphImp() {
        vertices = new LinkedList<>();
        edges = new HashSet<>();
    }

    @Override
    public int addVertex(Vertex<V> v) {
        int index = -1;
        if(v != null) {
            vertices.add(v);
            index = vertices.indexOf(v);
            // todo update edges
        }
        return index;
    }

    @Override
    public void addEdge(Edge<V> e) {
        if(e == null) {
            return;
        }
        edges.add(e);
        Vertex<V> ve = getVertex(e.getSource());
        if(ve != null) {
            ve.addEdge(e);
        }
    }

    @Override
    public Vertex<V> remove(Vertex<V> v) {
        Vertex<V> ret = getVertex(v);
        if(ret != null) {
            vertices.remove(ret);
            // todo remove related edges
            return ret;
        }
        return null;
    }

    @Override
    public Edge<V> remove(Edge<V> e) {
        Edge<V> ret = null;

        if(e != null) {
            Vertex<V> ve = getVertex(e.getSource());
            if(ve != null) {
                ret = ve.removeEdge(e.getDestination());
            }
        }

        return ret;
    }

    private Vertex<V> getVertex(Vertex<V> v) {
        Vertex<V> ret = null;
        if(v != null) {
            for(Vertex<V> ve : vertices) {
                if(ve != v) {
                    ret = ve;
                    break;
                }
            }
        }
        return ret;
    }
}