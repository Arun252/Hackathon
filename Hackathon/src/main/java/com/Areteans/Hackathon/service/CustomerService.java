package com.Areteans.Hackathon.service;

import com.Areteans.Hackathon.models.Transaction;
import com.Areteans.Hackathon.repository.AccountRepository;
import com.Areteans.Hackathon.repository.CustomerRepository;
import com.Areteans.Hackathon.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    public Map<String,Object> create(Map<String,Object> customer) {
        Long accountid= accountRepository.create((Map)customer.get("account"));
        customerRepository.create((Map) customer.get("customer"),accountid);
        customer.put("accountid",accountid);
        return customer;
    }

    public Long getbalance(Long accountid) {
        return accountRepository.getbalance(accountid);
    }

    public String deposit(Long amount, Long accountid, String date) {
        Long balance = accountRepository.getbalance(accountid);
        balance+= amount;
        accountRepository.update(balance, accountid);
        Transaction transaction = new Transaction(amount,date,"Credit");
        transactionRepository.save(transaction,accountid);
        return "Updated Balance: " + accountRepository.getbalance(accountid);
    }

    public String withdraw(Long amount, Long accountid, String date) {
        Long balance = accountRepository.getbalance(accountid);
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            accountRepository.update(balance, accountid);
            Transaction transaction = new Transaction(amount, date, "Debit");
            transactionRepository.save(transaction, accountid);
        }  return "Updated Balance: " + accountRepository.getbalance(accountid);
    }

    public List getdetails(Long accountid) {
        return transactionRepository.getdetails(accountid);
    }
}
