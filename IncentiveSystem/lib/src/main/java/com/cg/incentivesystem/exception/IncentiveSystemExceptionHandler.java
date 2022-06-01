package com.cg.incentivesystem.exception;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IncentiveSystemExceptionHandler {
	@ExceptionHandler(value = BookingIdNotFoundException.class)
	public ResponseEntity<Object> exception(BookingIdNotFoundException exception){
		return new ResponseEntity<Object>("BookingIdNotFound...." , HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = CarCompanyNotFoundException.class)
	public ResponseEntity<Object> exception(CarCompanyNotFoundException exception){
		return new ResponseEntity<Object>("CarCompanyNotFound....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = CarCompanyAlreadyExistException.class)
	public ResponseEntity<Object> exception(CarCompanyAlreadyExistException exception){
		return new ResponseEntity<Object>("CarCompanyAlreadyExists....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = CarDetailsNotFoundException.class)
	public ResponseEntity<Object> exception(CarDetailsNotFoundException exception){
		return new ResponseEntity<Object>("CarDetailsNotFoundException....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = ChassisNumberAlreadyBookedException.class)
	public ResponseEntity<Object> exception(ChassisNumberAlreadyBookedException exception){
		return new ResponseEntity<Object>("ChassisNumberAlreadyBooked....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = CustomerAlreadyExistException.class)
	public ResponseEntity<Object> exception(CustomerAlreadyExistException exception){
		return new ResponseEntity<Object>("CustomerAlreadyExists....", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerNotFoundException exception){
		return new ResponseEntity<Object>("CustomerNotFound....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = DealerAlreadyExistException.class)
	public ResponseEntity<Object> exception(DealerAlreadyExistException exception){
		return new ResponseEntity<Object>("DealerAlreadyExists....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = DealerNotFoundException.class)
	public ResponseEntity<Object> exception(DealerNotFoundException exception){
		return new ResponseEntity<Object>("DealerNotFound....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = IncentiveForThisBookingIDAlreadyExistException.class)
	public ResponseEntity<Object> exception(IncentiveForThisBookingIDAlreadyExistException exception){
		return new ResponseEntity<Object>("IncentiveForThisBookingIDAlreadyExists....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = NotEligibleForIncentiveException.class)
	public ResponseEntity<Object> exception(NotEligibleForIncentiveException exception){
		return new ResponseEntity<Object>("NotEligibleForIncentives....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = PSQLException.class)
	public ResponseEntity<Object> exception(PSQLException exception){
		return new ResponseEntity<Object>("IncorrectDetails...... ", HttpStatus.NOT_FOUND);
	}

}
