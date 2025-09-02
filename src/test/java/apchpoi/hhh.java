package apchpoi;

	abstract class Animal {
		  abstract void makeSound(); // abstract method

		  void sleep() {
		    System.out.println("Sleeping...");
		  }
		}

		class Dog extends Animal {
		  void makeSound() {
		    System.out.println("Dog barks");
		  }
		

		
		  public static void main(String[] args) {
		    Animal a = new Dog();
		    a.makeSound();  // Output: Dog barks
		    a.sleep();      // Output: Sleeping...
		  }
		}



