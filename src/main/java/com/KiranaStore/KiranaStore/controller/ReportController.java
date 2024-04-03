package com.KiranaStore.KiranaStore.controller;

import com.KiranaStore.KiranaStore.Response.ReportResponse;
import com.KiranaStore.KiranaStore.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
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
        public ResponseEntity<ReportResponse> getMonthly(){
            return new ResponseEntity<ReportResponse>(reportService.getMonthlyTransaction(), HttpStatus.CREATED);
        }

        @GetMapping("/Yearly")
        public ResponseEntity<ReportResponse> getYearly(){
            return new ResponseEntity<ReportResponse>(reportService.getYearlyTransaction(), HttpStatus.CREATED);

        }

    }
