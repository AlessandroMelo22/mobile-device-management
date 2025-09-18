package com.alessandromelo.exceptionhandler;

import com.alessandromelo.exception.ApiError;
import com.alessandromelo.exception.agente.AgenteNaoEncontradoException;
import com.alessandromelo.exception.comando.ComandoNaoEncontradoException;
import com.alessandromelo.exception.departamento.DepartamentoNaoEncontradoException;
import com.alessandromelo.exception.departamento.NomeJaCadastradoException;
import com.alessandromelo.exception.departamento.SiglaJaCadastradaException;
import com.alessandromelo.exception.dispositivo.DispositivoNaoEncontradoException;
import com.alessandromelo.exception.dispositivo.NumeroDeSerieJaCadastradoException;
import com.alessandromelo.exception.global.EntidadeEmUsoException;
import com.alessandromelo.exception.usuario.EmailJaCadastradoException;
import com.alessandromelo.exception.usuario.MatriculaJaCadastradaException;
import com.alessandromelo.exception.usuario.UsuarioNaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

///////USUARIO:

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

    @ExceptionHandler(MatriculaJaCadastradaException.class)
    public ResponseEntity<ApiError> handleMatriculaJaCadastradaException (MatriculaJaCadastradaException ex,
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



//////AGENTE:

    @ExceptionHandler(AgenteNaoEncontradoException.class)
    public ResponseEntity<ApiError> handleAgenteNaoEncontradoException (AgenteNaoEncontradoException ex,
                                                                        HttpServletRequest request){
        //400
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST,ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


//////AGENTEOPERACOES:

    




//////COMANDO:

    @ExceptionHandler(ComandoNaoEncontradoException.class)
    public ResponseEntity<ApiError> handleComandoNaoEncontradoException(ComandoNaoEncontradoException ex,
                                                                                    HttpServletRequest request){
        //400
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }



//////GLOBAL:

    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<ApiError> handleEntidadeEmUsoException(EntidadeEmUsoException ex,
                                                                 HttpServletRequest request){
        //409
        ApiError error = new ApiError(HttpStatus.CONFLICT, ex.getMessage(),request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }


///////VALIDAÇÃO:

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex,
                                                              HttpServletRequest request){

        String mensagensDeErros = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError
                        .getDefaultMessage()).collect(Collectors.joining(" | "));

        //400
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, request.getRequestURI());
        error.setMessage(mensagensDeErros);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


}
