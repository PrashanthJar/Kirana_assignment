package com.KiranaStore.KiranaStore.controller;

import com.KiranaStore.KiranaStore.Response.ReportResponse;
import com.KiranaStore.KiranaStore.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class ReportController {
    public final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
        @GetMapping("/Weekly")
        public ResponseEntity<ReportResponse> getWeekly(){
            System.out.println("inside Weekly report");
            return new ResponseEntity<ReportResponse>(reportService.getWeeklyTransaction(), HttpStatus.CREATED);
        }


        @GetMapping("/Monthly")
        public ResponseEntity<ReportResponse> getMontly(){
            System.out.println("inside Monthly report");
            return new ResponseEntity<ReportResponse>(reportService.getMonthlyTransaction(), HttpStatus.CREATED);
        }

        @GetMapping("/Yearly")
        public ResponseEntity<ReportResponse> getYearly(){
            System.out.println("inside Yearly report");
            return new ResponseEntity<ReportResponse>(reportService.getYearlyTransaction(), HttpStatus.CREATED);

        }

    }
