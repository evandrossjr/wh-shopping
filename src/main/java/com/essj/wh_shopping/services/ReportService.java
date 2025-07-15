package com.essj.wh_shopping.services;

import com.essj.wh_shopping.DTO.DTOConverter;
import com.essj.wh_shopping.DTO.ShopDTO;
import com.essj.wh_shopping.DTO.ShopReportDTO;
import com.essj.wh_shopping.entities.Shop;
import com.essj.wh_shopping.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    @Qualifier("reportRepositoryImpl")
    private ReportRepository reportRepository;

    public List<ShopDTO> getShopByFilter(Date dataInicio, Date dataFim, Float valorMinimo) {

        List<Shop> shops = reportRepository.getShopByFilters(dataInicio, dataFim, valorMinimo);
        return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim){
        return reportRepository.getReportByDate(dataInicio,dataFim);
    }
}
