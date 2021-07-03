package co.com.mercadolibre.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseExceptionHandler.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> manejarTodasExcepciones(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(true));
		LOGGER.error("Inicio retrySourceContentMessage en controller Request:"+ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(ModeloNotFoundException.class)
	public final ResponseEntity<Object> manejarModeloExcepciones(ModeloNotFoundException ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		LOGGER.error("Inicio retrySourceContentMessage en controller Request:"+ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(IllegalArgumentException.class)
	public final ResponseEntity<Object> manejoIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		LOGGER.error("Inicio retrySourceContentMessage en controller Request:"+ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String errores = "";
		for (ObjectError e : ex.getBindingResult().getAllErrors()) {
			errores += e.getObjectName();
		}
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), errores);
		LOGGER.error("Inicio retrySourceContentMessage en controller Request:"+ex.getMessage());
		
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
