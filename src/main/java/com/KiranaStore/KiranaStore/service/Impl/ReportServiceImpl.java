package com.KiranaStore.KiranaStore.service.Impl;

import com.KiranaStore.KiranaStore.Response.ReportResponse;
import com.KiranaStore.KiranaStore.model.Transaction;
import com.KiranaStore.KiranaStore.repository.TransactionRepository;
import com.KiranaStore.KiranaStore.service.ReportService;
import org.apache.catalina.Globals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        LocalDateTime CurrentDatetime= LocalDateTime.now();
        LocalDateTime OneWeekAgo = CurrentDatetime.minusDays(7);
        System.out.println("Inside Week");
        List<Transaction> result = transactionRepository.findByTimeStampBetween(OneWeekAgo,CurrentDatetime);

        return getStatistics(result);
    }

    @Override
    public ReportResponse getMonthlyTransaction() {
        LocalDateTime CurrentDatetime = LocalDateTime.now();
        LocalDateTime OneMonthAgo = CurrentDatetime.minusMonths(1);
        System.out.println("Inside Month");

        List<Transaction> result = transactionRepository.findByTimeStampBetween(OneMonthAgo,CurrentDatetime);

        return getStatistics(result);
    }

    @Override
    public ReportResponse getYearlyTransaction() {

        LocalDateTime CurrentDatetime = LocalDateTime.now();
        LocalDateTime OneYearAgo = CurrentDatetime.minusYears(1);
        System.out.println("Inside Year");

        List<Transaction> result = transactionRepository.findByTimeStampBetween(OneYearAgo,CurrentDatetime);

        return getStatistics(result);
    }
}
