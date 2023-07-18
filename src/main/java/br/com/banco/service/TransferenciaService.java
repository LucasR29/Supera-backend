package br.com.banco.service;

import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;
import br.com.banco.repository.ContaReporitory;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransferenciaService {
    private final TransferenciaRepository transferenciaRepository;
    private final ContaReporitory contaReporitory;

    public TransferenciaService(TransferenciaRepository transferenciaRepository, ContaReporitory contaReporitory) {
        this.transferenciaRepository = transferenciaRepository;
        this.contaReporitory = contaReporitory;
    }

    public List<Transferencia> listByDateTransferencia(Date startDate, Date endDate) {
        return transferenciaRepository.findByDataTransferenciaBetween(startDate, endDate);
    }

    public List<Transferencia> listTransferencias() {
        return transferenciaRepository.findAll();
    }
}
