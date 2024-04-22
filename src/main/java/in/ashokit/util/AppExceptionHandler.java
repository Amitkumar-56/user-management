package in.ashokit.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class AppExceptionHandler {
	   @ExceptionHandler({Exception.class})
	   public String exHandler(Exception e) {
	      return "errorPage";
	   }

}
