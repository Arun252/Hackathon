package com.Areteans.Hackathon.repository;

import com.Areteans.Hackathon.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;


@Repository
@RequiredArgsConstructor
public class CustomerRepository {
    private final JdbcTemplate jdbcTemplate;
    public void create(Map<String,Object> customer, Long accountid) {
        jdbcTemplate.update("insert into customer1(accountholder,address,contact,accountid) values (?,?,?,?)",
                (String)customer.get("accountholder"),
                (String)customer.get("address"),
                (Long)customer.get("contact"),
                accountid);
    }
}
