package com.KiranaStore.KiranaStore.service;

import com.KiranaStore.KiranaStore.Response.ReportResponse;

public interface ReportService {
    ReportResponse getWeeklyTransaction();

    ReportResponse getMonthlyTransaction();

    ReportResponse getYearlyTransaction();
}
