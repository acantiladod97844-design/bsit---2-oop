Question 1
Why is the list in RideManager typed ArrayList<Ride> and not ArrayList<Jeepney>?

answer:

Using ArrayList<Ride> leverages polymorphism, allowing the list to store any vehicle type that inherits from Ride (such as Jeepney, Tricycle, and Taxi). If it were typed ArrayList<Jeepney>, the list would strictly accept Jeepney objects and reject all other vehicle types.




Question 2
In showStudentDiscounts(), why must you check instanceof before the cast?

answer:

Checking instanceof ensures that a Ride object actually implements the StudentDiscount interface at runtime before downcasting. Without this check, attempting to downcast an object that does not implement the interface (such as Taxi) would compile successfully but throw a ClassCastException and crash the program at runtime.