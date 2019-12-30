package com.mbicycle.dockertest.controller;


import com.mbicycle.dockertest.service.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VisitController {

    private final VisitService visitService;

    @GetMapping("/visit")
    public ResponseEntity<Long> visits() {
        return ResponseEntity.ok(visitService.increaseAndReturn().getAmount());
    }
}
