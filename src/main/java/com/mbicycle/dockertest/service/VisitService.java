package com.mbicycle.dockertest.service;

import com.mbicycle.dockertest.model.Visit;
import com.mbicycle.dockertest.repository.VisitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Transactional
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VisitService {

    private final VisitRepository visitRepository;

    public Visit increaseAndReturn() {
        Visit visit = visitRepository.findById(1L)
                .orElse(new Visit());
        Long amount = visit.getAmount();

        if (Objects.isNull(amount)) {
            visit.setAmount(1L);
        } else {
            visit.setAmount(amount + 1);
        }
        return visitRepository.save(visit);
    }
}
