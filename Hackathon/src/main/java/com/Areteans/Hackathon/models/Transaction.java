package com.Areteans.Hackathon.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long transactionid;
    private String transactiontype;
    private Long amount;
    private String date;

    public Transaction(Long amount, String date, String transactiontype) {
        this.amount=amount;
        this.date=date;
        this.transactiontype=transactiontype;
    }
}
