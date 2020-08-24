# Design Parking Lot System


## Functional Requirements

1. A Customer should be able to generate a ticket
2. A Customer should be able to pay ticket
3. A parking lot should contain multiple parking floors
4. Each Parking floor contains multiple parking slot types
5. Each Parking floor must display available parking slots of each type
6. Parking floor should contains slots with electric panels. Customer should be able to use and pay
7. A parking lot should contain multiple entry and exit panels
8. A parking attendant should do all customer can perform.
9. The parking lot should have hourly system to calculate rate
10. The System should accept card, cash payments
11. Customer should pay ticket at CusotmerInfo Panel available on each parking floor


##
 Use Cases
### Actors
	1. Customer
	2. Parking Attendant
	3. Admin
	4. System
### Use cases
	1. Add/update/delete parking floor
	2. Add/update/delete entrance/exit panels
	3. scan ticket
	4. generate ticket
	5. pay ticket
	6. Display parking slots on each floor
	7. Display parking lot full/available

## Class Diagram
### Core Objects
	1. ParkingLot
	2. ParkingFloor
	3. ParkingSpot
	5. Ticket
	6. Account
	7. Payment
	8. Vechile
	9. EntrancePanel
	10. ExitPanel
	11. ParkingDisplay
	12. CustomerInfo
	13. TicketRate
	14. ParkingAttendantPortal

### Class Diagram
