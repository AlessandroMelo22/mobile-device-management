package com.alessandromelo.exceptionhandler;

import com.alessandromelo.exception.ApiError;
import com.alessandromelo.exception.departamento.DepartamentoNaoEncontradoException;
import com.alessandromelo.exception.departamento.NomeJaCadastradoException;
import com.alessandromelo.exception.departamento.SiglaJaCadastradaException;
import com.alessandromelo.exception.dispositivo.DispositivoNaoEncontradoException;
import com.alessandromelo.exception.dispositivo.NumeroDeSerieJaCadastradoException;
import com.alessandromelo.exception.usuario.CpfJaCadastradoException;
import com.alessandromelo.exception.usuario.EmailJaCadastradoException;
import com.alessandromelo.exception.usuario.UsuarioNaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

////////////USUARIO:

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ApiError> handleUsuarioNaoEncontradoException (UsuarioNaoEncontradoException ex,
                                                                         HttpServletRequest request){

        ApiError error = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<ApiError> handleEmailJaCadastradoException (EmailJaCadastradoException ex,
                                                                      HttpServletRequest request){
        //400
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(CpfJaCadastradoException.class)
    public ResponseEntity<ApiError> handleCpfJaCadastradoException (CpfJaCadastradoException ex,
                                                                    HttpServletRequest request){
        //400
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

////////DISPOSITIVO:

    @ExceptionHandler(DispositivoNaoEncontradoException.class)
    public ResponseEntity<ApiError> handleDispositivoNaoEncontradoExcetion (DispositivoNaoEncontradoException ex,
                                                                            HttpServletRequest request){

        ApiError error = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NumeroDeSerieJaCadastradoException.class)
    public ResponseEntity<ApiError> handleNumeroDeSerieJaCadastradoException (NumeroDeSerieJaCadastradoException ex,
                                                                    HttpServletRequest request){
        //400
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

///////DEPARTAMENTO:

    @ExceptionHandler(DepartamentoNaoEncontradoException.class)
    public ResponseEntity<ApiError> handleDepartamentoNaoEncontradoException(DepartamentoNaoEncontradoException ex,
                                                                             HttpServletRequest request){

        ApiError error = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(NomeJaCadastradoException.class)
    public ResponseEntity<ApiError> handleNomeJaCadastradoException (NomeJaCadastradoException ex,
                                                                    HttpServletRequest request){
        //400
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(SiglaJaCadastradaException.class)
    public ResponseEntity<ApiError> handleSiglaJaCadastradaException (SiglaJaCadastradaException ex,
                                                                    HttpServletRequest request){
        //400
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }








}
