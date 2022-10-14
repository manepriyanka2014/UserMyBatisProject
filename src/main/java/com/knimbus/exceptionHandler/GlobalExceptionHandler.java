//package com.knimbus.exceptionHandler;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//
//
//    @Value(value = "${data.exception.message1}")
//    private String message1;
//    
//    @Value(value = "${data.exception.message2}")
//    private String message2;
//
//    @ExceptionHandler(value = UserNotFoundException.class)
//    public ResponseEntity userNotFoundException(UserNotFoundException userNotFoundException) {
//        return new ResponseEntity<String>(message1, HttpStatus.NOT_FOUND);
//    }
//    
//    @ExceptionHandler(value = NullPointerException.class)
//    public ResponseEntity NullPointerException(NullPointerException nullPointerException) {
//    	//nullPointerException.addAttribute("msg", "NullPointerException occoured");
//       
//        return new ResponseEntity<String>(message1, HttpStatus.NOT_FOUND);
//    }
//    
//    @ExceptionHandler(value = UserAlreadyExistException.class)
//    public ResponseEntity UserAlreadyExistException(UserAlreadyExistException userAlreadyExistException) {
//        return new ResponseEntity<String>(message2, HttpStatus.NOT_FOUND);
//    }
//}
