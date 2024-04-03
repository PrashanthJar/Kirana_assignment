package com.KiranaStore.KiranaStore.service.Impl;

import com.KiranaStore.KiranaStore.Response.ReportResponse;
import com.KiranaStore.KiranaStore.model.Transaction;
import com.KiranaStore.KiranaStore.repository.TransactionRepository;
import com.KiranaStore.KiranaStore.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private TransactionRepository transactionRepository;


    public ReportResponse getStatistics(List<Transaction> transactions) {
        float totalCredit = 0,totalDebit=0 , netTransaction =0;
        for(Transaction transaction:transactions){
            if(Objects.equals(transaction.getType(), "credit")){
                totalCredit += transaction.getAmountToDollar();
            }
            else {
                totalDebit += transaction.getAmountToDollar();
            }
            netTransaction = totalCredit-totalDebit;
        }

        return new ReportResponse(totalCredit,totalDebit,netTransaction);
    }

    @Override
    public ReportResponse getWeeklyTransaction() {
        return getStatistics();
    }

    @Override
    public ReportResponse getMonthlyTransaction() {
        return getStatistics();
    }

    @Override
    public ReportResponse getYearlyTransaction() {
        return getStatistics();
    }
}
