package com.KiranaStore.KiranaStore.service;

import com.KiranaStore.KiranaStore.Response.ReportResponse;
import com.KiranaStore.KiranaStore.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


public interface ReportService {

    ReportResponse getWeeklyTransaction();

    ReportResponse getMonthlyTransaction();

    ReportResponse getYearlyTransaction();
}
