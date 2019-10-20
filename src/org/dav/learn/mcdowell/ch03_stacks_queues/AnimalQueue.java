package org.dav.learn.mcdowell.ch03_stacks_queues;

import java.util.LinkedList;

public class AnimalQueue {
	private LinkedList<Dog> dogs = new LinkedList<>();
	private LinkedList<Cat> cats = new LinkedList<>();
	private int order = 0;

	public void enqueue(Animal animal) {
		animal.setOrder(order);
		order++;

		if (animal instanceof Dog)
			dogs.addLast((Dog) animal);
		else if (animal instanceof Cat)
			cats.addLast((Cat) animal);
	}

	public Animal dequeue() {
		if (dogs.isEmpty())
			return dequeueCats();
		else if (cats.isEmpty())
			return dequeueDogs();

		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if (dog.isOlderThan(cat))
			return dequeueDogs();
		else
			return dequeueCats();
	}

	public Dog dequeueDogs() {
		return dogs.poll();
	}

	public Cat dequeueCats() {
		return cats.poll();
	}
}
