package com.Areteans.Hackathon.controller;

import com.Areteans.Hackathon.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="savings")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(path="create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> create(@RequestBody Map<String,Object> customer){
            return customerService.create(customer);
    }

    @GetMapping(path = "balance")
    public Long getbalance(@RequestParam("accountid") Long accountid)  {
        return customerService.getbalance(accountid);
    }

    @PostMapping(path = "deposit" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long deposit(@RequestBody Map<String, Object> map) {
        return customerService.deposit(Long.valueOf((String)map.get("amount")) ,Long.valueOf((String)map.get("accountid")), (String)map.get("date"));
    }

    @PostMapping(path = "withdraw" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long withdraw(@RequestBody Map<String, Object> map) {
        return customerService.withdraw(Long.valueOf((String)map.get("amount")) ,Long.valueOf((String)map.get("accountid")), (String)map.get("date"));
    }

    @GetMapping(path = "details")
    public List getdetails(@RequestParam("accountid") Long accountid)  {
        return customerService.getdetails(accountid);
    }
}
