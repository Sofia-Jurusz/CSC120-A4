Use this file to record your reflection on this assignment.

- What are your initial impressions of how `Encapsulation` affects your programming?
- What worked, what didn't, what advice would you give someone taking this course in the future?


I like encapsulation because in the end I don't have to write as much code. It takes a little more thinking and planning in the moment because you want to make sure everything can work together. We were given exactly how to implement everything and what methods/variables we needed. I think if I had to do it from scratch I would have struggled more, but after seeing how it was organized I think I have a better understanding of how to start a project like this. For me, the best thing was to follow the steps on the README. 

In my first resubmission, I had to implement the requirements for each respective class. Because I didn't do this originally, I did not realize I implemented some methods and attributes with the wrong names, so I fixed those aswell. I fixed the names of classes, methods, and variables so they were correct java formating. I fixed my silent failure in the passenger class so users would know if a passenger was not added to a car. I also realized that it was possible for the same passenger to be added to two cars. I fixed this by making the passenger's car one of their attributes, and using this to check if they are already on a different car. Lastly, the Train class was repetative because I defined each car's maximum capacity as a attribute of the Train class and the Car class. I fixed this by removing it as an attribute of the Train class. 

Second revision:
- changed curly bracket/if else issue in car class
- fixed capitalization error in Car for manifest_size. 
- fixed train constructor. I changed the attributes for the constructor so it intakes passengerCapacity instead of maxCapacity. Then, I made maxCapacity the passengerCapacity times the number of cars. 
- i got kinda confused on the purpose of interfaces. interfaces are about methods, not attributes. This means i added the attribute seatsRemianing to the car class, when I actually didn't need that. 
- from the car class, passengers could still get on the same car twice because I was not updateing a passenger's car when they boarded a car. I added a method in Passenger which changes the passenger's car. When a passenger successfully boards a car, the car class will call changeCar() and the passsenger gets a new car. 