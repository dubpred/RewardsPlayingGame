package com.pnc.apifest2019.rewardsplayinggameservice.controller;

import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.EventDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.TransactionDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.TransactionResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.UserItemResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.service.TransactionService;
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
    public ResponseEntity<TransactionResponseDto> postTransaction(@RequestBody TransactionDto transactionDto){
        return ResponseEntity.ok(transactionService.postTransaction(transactionDto));
    }

    /*
    @PostMapping(value = "/event")
    public ResponseEntity<UserItemResponseDto> postEvent(@RequestBody @Valid EventDto eventDto,
                                                         @RequestParam long itemId){
        return ResponseEntity.ok(transactionService.postEvent(itemId, eventDto));
    }
    */



}
