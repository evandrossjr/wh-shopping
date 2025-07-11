package com.essj.wh_shopping.services;

import com.essj.wh_shopping.DTO.ShopDTO;
import com.essj.wh_shopping.entities.Shop;
import com.essj.wh_shopping.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<ShopDTO> getShopsByFilter(Date dataInicio, Date dataFim, Float valorMinimo) {

        List<Shop> shops = reportRepository.getShopByFilters(dataInicio, dataFim, valorMinimo);
        return null;
    }
}
