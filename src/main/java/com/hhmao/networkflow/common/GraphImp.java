package com.hhmao.networkflow.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphImp<V> implements Graph<V> {

    protected Set<V> vertices;
    protected Map<V, Vertex<V>> entry2Vertex;

    public GraphImp() {
        vertices = new HashSet<>();
        entry2Vertex = new HashMap<>();
    }

    @Override
    public void addVertex(V v) {
        if (v != null) {
            vertices.add(v);
            entry2Vertex.put(v, new Vertex<>(v));
        }
    }

    @Override
    public void addEdge(Edge<V> e) {
        if (e == null) {
            return;
        }
        Vertex<V> ve = getVertex(e.getSource());
        if (ve != null) {
            ve.addEdge(e);
        }
    }

    @Override
    public V remove(V v) {
        Vertex<V> ret = getVertex(v);
        if (ret != null) {
            vertices.remove(ret.entry);
            return v;
        }
        return null;
    }

    @Override
    public Edge<V> remove(Edge<V> e) {
        if (e != null) {
            Vertex<V> ve = getVertex(e.getSource());
            if (ve != null) {
                ve.removeEdge(e);
            }
        }
        return e;
    }

    private Vertex<V> getVertex(V v) {
        if (v != null && entry2Vertex.containsKey(v)) {
            return entry2Vertex.get(v);
        }
        return null;
    }
}