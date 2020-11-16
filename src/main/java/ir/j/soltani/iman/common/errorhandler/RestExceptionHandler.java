///**
// * @author I.Soltani
// */
//
//package ir.tourism.tit.darya.common;
//
//import ir.tourism.tit.darya.controller.handler.BaseError;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import javax.management.ReflectionException;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//
//@RestControllerAdvice
//public class RestExceptionHandler extends ResponseEntityExceptionHandler {
//
////    static Logger logger = LogManager.getLogger();
//
//    /**
//     * Handle MethodArgumentNotValidException. Triggered when an object fails @Valid validation.
//     *
//     * @param exp the MethodArgumentNotValidException that is thrown when @Valid validation fails
//     * @param headers HttpHeaders
//     * @param status  HttpStatus
//     * @param request WebRequest
//     * @return the ResponseEntity object
//     */
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException exp,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
////        logger.error(TITResponseCode.INVALID_INPUT_ERROR.getMessage(), exp);
//        BaseError error = new BaseError(TITResponseCode.INVALID_INPUT_ERROR.getCode(), LocalDateTime.now(), TITResponseCode.INVALID_INPUT_ERROR.getMessage());
//        error.addValidationErrors(exp.getBindingResult().getFieldErrors());
//        error.addValidationError(exp.getBindingResult().getGlobalErrors());
//        TITResponseBody body = new TITResponseBody(TITResponseCode.INVALID_INPUT_ERROR, error);
//        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//    }
//
//    /**
//     * Handles javax.validation.ConstraintViolationException. Thrown when @Validated fails.
//     *
//     * @param exp the ConstraintViolationException
//     * @return the ResponseEntity object
//     */
//    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
//    protected ResponseEntity<Object> handleConstraintViolation(
//            javax.validation.ConstraintViolationException exp) {
////        logger.error(TITResponseCode.INVALID_INPUT_ERROR.getMessage(), exp);
//        BaseError error = new BaseError(TITResponseCode.INVALID_INPUT_ERROR.getCode(), LocalDateTime.now(), TITResponseCode.INVALID_INPUT_ERROR.getMessage());
//        error.addValidationErrors(exp.getConstraintViolations());
//        TITResponseBody body = new TITResponseBody(TITResponseCode.INVALID_INPUT_ERROR, error);
//        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    protected ResponseEntity<TITResponseBody> handleIllegalArgumentException(IllegalArgumentException exp) {
////        logger.error(TITResponseCode.INVALID_INPUT_ERROR.getMessage(), exp);
//        BaseError error = new BaseError(TITResponseCode.INVALID_INPUT_ERROR.getCode(), LocalDateTime.now(), TITResponseCode.INVALID_INPUT_ERROR.getMessage());
//        TITResponseBody body = new TITResponseBody(TITResponseCode.INVALID_INPUT_ERROR, error);
//        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(SQLException.class)
//    protected ResponseEntity<TITResponseBody> handleSQLException(SQLException exp) {
////        logger.error(TITResponseCode.DATABASE_ERROR.getMessage(), exp);
//        BaseError error = new BaseError(TITResponseCode.DATABASE_ERROR.getCode(), LocalDateTime.now(), TITResponseCode.DATABASE_ERROR.getMessage());
//        TITResponseBody body = new TITResponseBody(TITResponseCode.DATABASE_ERROR, error);
//        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(ReflectionException.class)
//    protected ResponseEntity<TITResponseBody> handleReflectionException(ReflectionException exp) {
////        logger.error(TITResponseCode.INTERNAL_ERROR.getMessage(), exp);
//        BaseError error = new BaseError(TITResponseCode.INTERNAL_ERROR.getCode(), LocalDateTime.now(), TITResponseCode.INTERNAL_ERROR.getMessage());
//        TITResponseBody body = new TITResponseBody(TITResponseCode.INTERNAL_ERROR, error);
//        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
//
//
//
