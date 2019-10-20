package org.dav.learn.mcdowell.ch03_stacks_queues;

public abstract class Animal {
	private int order;
	private String name;

	public Animal(String name) {
		this.name = name;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public boolean isOlderThan(Animal animal) {
		return this.order < animal.order;
	}
}
