
	ALTER TABLE details
	DROP CONSTRAINT fk_car;
	
	ALTER TABLE details
	ADD CONSTRAINT fk_car
	FOREIGN KEY (car_id)
	REFERENCES cars(id)
	ON DELETE CASCADE;


