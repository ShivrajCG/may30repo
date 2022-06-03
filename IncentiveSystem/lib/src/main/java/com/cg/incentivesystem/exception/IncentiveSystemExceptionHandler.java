package com.cg.incentivesystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IncentiveSystemExceptionHandler {
	@ExceptionHandler(value = BookingIdNotFoundException.class)
	public ResponseEntity<Object> exception(BookingIdNotFoundException exception){
		return new ResponseEntity<>("BookingIdNotFound...." , HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = CarCompanyNotFoundException.class)
	public ResponseEntity<Object> exception(CarCompanyNotFoundException exception){
		return new ResponseEntity<>("CarCompanyNotFound....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = CarCompanyAlreadyExistException.class)
	public ResponseEntity<Object> exception(CarCompanyAlreadyExistException exception){
		return new ResponseEntity<>("CarCompanyAlreadyExists....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = CarDetailsNotFoundException.class)
	public ResponseEntity<Object> exception(CarDetailsNotFoundException exception){
		return new ResponseEntity<>("CarDetailsNotFoundException....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = ChassisNumberAlreadyBookedException.class)
	public ResponseEntity<Object> exception(ChassisNumberAlreadyBookedException exception){
		return new ResponseEntity<>("ChassisNumberAlreadyBooked....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = CustomerAlreadyExistException.class)
	public ResponseEntity<Object> exception(CustomerAlreadyExistException exception){
		return new ResponseEntity<>("CustomerAlreadyExists....", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerNotFoundException exception){
		return new ResponseEntity<>("CustomerNotFound....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = DealerAlreadyExistException.class)
	public ResponseEntity<Object> exception(DealerAlreadyExistException exception){
		return new ResponseEntity<>("DealerAlreadyExists....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = DealerNotFoundException.class)
	public ResponseEntity<Object> exception(DealerNotFoundException exception){
		return new ResponseEntity<>("DealerNotFound....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = IncentiveForThisBookingIDAlreadyExistException.class)
	public ResponseEntity<Object> exception(IncentiveForThisBookingIDAlreadyExistException exception){
		return new ResponseEntity<>("IncentiveForThisBookingIDAlreadyExists....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = NotEligibleForIncentiveException.class)
	public ResponseEntity<Object> exception(NotEligibleForIncentiveException exception){
		return new ResponseEntity<>("NotEligibleForIncentives....", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = IncentiveDetailsNotFoundException.class)
	public ResponseEntity<Object> exception(IncentiveDetailsNotFoundException exception){
		return new ResponseEntity<>("IncentiveDetailsNotFound....", HttpStatus.NOT_FOUND);
	}

}
