package com.cooksys.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cooksys.entity.Edge;
import com.cooksys.entity.Vertex;

public class Dijkstra {
	
	private final List<Vertex> nodes;
	private final List<Edge> edges;
	private Set<Vertex> settledNodes;
	private Set<Vertex> unsettledNodes;
	private Map<Vertex, Vertex> predecessors;
	private Map<Vertex, Integer> distance;
	
	public Dijkstra(List<Vertex> nodes, List<Edge> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}
	
	public void execute(Vertex source) {
		settledNodes = new HashSet<Vertex>();
		unsettledNodes = new HashSet<Vertex>();
		distance = new HashMap<Vertex, Integer>();
		predecessors = new HashMap<Vertex, Vertex>();
		distance.put(source,  0);
		unsettledNodes.add(source);
		while(unsettledNodes.size() > 0){
			Vertex node = getMinimum(unsettledNodes);
			settledNodes.add(node);
			unsettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}
	
	private void findMinimalDistances(Vertex node){
		List<Vertex> adjacentNodes = getNeighbors(node);
		for(Vertex target : adjacentNodes){
			if (getShortestDistance(target) > getDistance(node, target)) {
				distance.put(target, getDistance(node, target));
				predecessors.put(target, node);
				unsettledNodes.add(target);
			}
		}
	}
	
	private int getDistance(Vertex node, Vertex target){
		for(Edge edge : edges) {
			if(edge.getSource().equals(node) && edge.getDestination().equals(target)) {
				if(getShortestDistance(node) < edge.getOffset() || getShortestDistance(node) == 0){
					return edge.getWeight() + edge.getOffset();
				} else {
					return Integer.MAX_VALUE;
				}
			}
		}
		
		throw new RuntimeException("Should NEVER happen");		
	}
	
	private List<Vertex> getNeighbors(Vertex node) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		for(Edge edge : edges) {
			if(edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}
	
	private Vertex getMinimum(Set<Vertex> vertexes) {
		Vertex minimum = null;
		for(Vertex vertex : vertexes) {
			if(minimum == null){
				minimum = vertex;
			} else {
				if(getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}
	
	private boolean isSettled(Vertex vertex){
		return settledNodes.contains(vertex);
	}
	
	private int getShortestDistance(Vertex destination){
		Integer d = distance.get(destination);
		if(d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}
	
	/**
	 * This method returns the path from the source to the selected target;
	 * NULL if no such path exists.
	 */
	
	public LinkedList<Vertex> getPath(Vertex target) {
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;
		//check if a path exits
		if(predecessors.get(step) == null){
			return null;
		}
		path.add(step);
		while(predecessors.get(step) != null){
			step = predecessors.get(step);
			path.add(step);
		}
		// arrange properly
		Collections.reverse(path);
		return path;
	}
}
