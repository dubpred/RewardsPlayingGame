package com.pnc.apifest2019.rewardsplayinggameservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/transaction", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(final TransactionService transactionService){
        this.transactionService = transactionService;
    }


    @PostMapping
    public ResponseEntity<UserItemResponseDto> postTransaction(@RequestBody TransactionDto transactionDto,
                                                               @RequestParam long itemId){
        return ResponseEntity.ok(transactionService.postTransaction(itemId, transactionDto));
    }

    @PostMapping(value = "/event")
    public ResponseEntity<UserItemResponseDto> postEvent(@RequestBody @Valid EventDto eventDto,
                                                         @RequestParam long itemId){
        return ResponseEntity.ok(transactionService.postEvent(itemId, eventDto));
    }


}
