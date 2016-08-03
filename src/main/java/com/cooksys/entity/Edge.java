package com.cooksys.entity;

public class Edge {
	
	private final String id;
	private final Vertex source;
	private final Vertex destination;
	private final int weight;
	private final int offset;
	
	public Edge(String id, Vertex source, Vertex destination, int weight, int offset) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.offset = offset;
	}

	public String getId() {
		return id;
	}

	public Vertex getSource() {
		return source;
	}

	public Vertex getDestination() {
		return destination;
	}

	public int getWeight() {
		return weight;
	}

	public int getOffset() {
		return offset;
	}

	@Override
	public String toString() {
		return "Edge [source=" + source + ", destination=" + destination + "]";
	}
	
	
	
}
