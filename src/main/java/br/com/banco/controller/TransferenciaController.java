package br.com.banco.controller;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
    final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping
    public ResponseEntity<List<Transferencia>> listTranferencias() {
        final List<Transferencia> allTransferencias = transferenciaService.listTransferencias();

        return new ResponseEntity<List<Transferencia>>(allTransferencias, HttpStatus.OK);
    }

    @GetMapping("/by-date")
    public ResponseEntity<List<Transferencia>> listByDateTransferencia(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<Date> startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<Date> endDate) {

        Date start = startDate.orElse(new Date(0));
        Date end = endDate.orElse(new Date());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(end);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        end = calendar.getTime();

        List<Transferencia> transferencias = transferenciaService.listByDateTransferencia(start, end);

        return new ResponseEntity<List<Transferencia>>(transferencias, HttpStatus.OK);
    }
}
