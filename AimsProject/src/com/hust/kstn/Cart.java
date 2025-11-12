package com.hust.kstn;

public class Cart {
	private static final int MAX_NUMBER_ORDERED = 20;

	private DigitalVideoDisc[] itemsInCart = new DigitalVideoDisc[MAX_NUMBER_ORDERED];

	private int qtyOrdered;

	public void addDVD(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBER_ORDERED) {
			System.out.println("The cart is almost full");
			return;
		}
		itemsInCart[qtyOrdered] = disc;
		qtyOrdered++;
		System.out.println("The disc has been added successfully");
	}

	public void removeDVD(DigitalVideoDisc disc) {
		if (qtyOrdered == 0) {
			System.out.println("The cart is empty");
			return;
		}
		for (int i = 0; i < qtyOrdered; i++) {
			// This check only checks the address of the variable
			// Since the problem statement does not mention when
			// two discs are considered equal, I figure we can just
			// do it the bare minimum effort way.
			if (disc == itemsInCart[i]) {
				for (int j = i; j + 1 < qtyOrdered; j++) {
					itemsInCart[j] = itemsInCart[j + 1];
				}
				qtyOrdered--;
				break;
			}
		}
		// There may be a case where the disc is not found,
		// but in that case qtyOrdered does not change. And in
		// fact, after this call, the given `disc` will have been
		// removed anyway. So this message might make sense?
		System.out.println("The disc has been removed successfully");
	}

	public double calculateTotalCost() {
		double totalCost = 0.0;
		for (int i = 0; i < qtyOrdered; i++) {
			totalCost += itemsInCart[i].getCost();
		}
		return totalCost;
	}

	public void print() {
		System.out.println("=== Total items in cart: " + qtyOrdered + " ===");
		System.out.println("=== All items in cart ===");

		for (int i = 0; i < qtyOrdered; i++) {
			DigitalVideoDisc item = itemsInCart[i];
			System.out.println("[Title]: " + item.getTitle() + ", " + "[Cost]: " + item.getCost());
		}
	}
}
