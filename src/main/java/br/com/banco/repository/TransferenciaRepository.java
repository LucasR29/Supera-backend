package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    List<Transferencia> findByDataTransferenciaBetween(
            @Temporal (TemporalType.TIMESTAMP) Date startDate,
            @Temporal(TemporalType.TIMESTAMP) Date endDate);
}
