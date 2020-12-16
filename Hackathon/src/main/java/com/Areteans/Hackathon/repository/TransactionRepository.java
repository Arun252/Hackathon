package com.Areteans.Hackathon.repository;

import com.Areteans.Hackathon.models.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class TransactionRepository {
    private final JdbcTemplate jdbcTemplate;
    public void save(Transaction transaction , Long accountid) {
        jdbcTemplate.update("insert into transaction1 (amount,date,transactiontype,accountid) values(?,?,?,?)",
                transaction.getAmount(),
                transaction.getDate(),
                transaction.getTransactiontype(),
                accountid);
    }

    public List getdetails(Long accountid) {
        List<Map<String,Object>> list= jdbcTemplate.queryForList("select * from transaction1 where accountid=?",
                accountid);
        return list;
    }
}
