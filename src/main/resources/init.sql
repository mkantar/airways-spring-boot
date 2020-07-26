insert into AIRLINE(id, company)
			values(1, 'Muharrem Airline - 1');

insert into AIRLINE(id, company)
			values(2, 'Muharrem Airline - 2');
			
insert into AIRLINE(id, company)
			values(3, 'Muharrem Airline - 3');
			
insert into AIRPORT(id, name, city)
			values(1, 'Adnan Menderes', 'İzmir');
			
insert into AIRPORT(id, name, city)
			values(2, 'Sabiha Gökçen', 'İstanbul');

insert into AIRPORT(id, name, city)
			values(3, 'Esenboğa', 'Ankara');

insert into COURSE(id, origin_id, destination_id)
			values(1, 1, 2);
			
insert into COURSE(id, origin_id, destination_id)
			values(2, 1, 3);
			
insert into COURSE(id, origin_id, destination_id)
			values(3, 2, 1);
			
insert into COURSE(id, origin_id, destination_id)
			values(4, 2, 3);
			
insert into FLIGHT(id, total_Seat, available_Seat, fee, factor, date, airline_id, course_id)
			values(1, 100, 100, 100.0, 0.1, sysdate, 1, 1);
			
insert into FLIGHT(id, total_Seat, available_Seat, fee, factor, date, airline_id, course_id)
			values(2, 300, 200, 200.0, 0.3, sysdate, 2, 4);
			
insert into PASSENGER(id, name, surname) 
			values(1001, 'Muharrem', 'Kantar');
			
insert into PASSENGER(id, name, surname)
			values(1002, 'John', 'Wick');
			
insert into PASSENGER(id, name, surname) 
			values(1003, 'Bruce', 'Wayne');
			
insert into TICKET(id, flight_id, passenger_id)
			values(1, 1, 1001);
			
insert into TICKET(id, flight_id, passenger_id)
			values(2, 2, 1002);
			
insert into PAYMENT(id, charge_amount, credit_card_number, passenger_id)
			values(1, 100.0, '421421******4121', 1001);
			
insert into PAYMENT(id, charge_amount, credit_card_number, passenger_id)
			values(2, 200.0, '421421******4121', 1002);
