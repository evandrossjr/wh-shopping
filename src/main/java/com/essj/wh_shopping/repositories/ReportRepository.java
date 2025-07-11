package com.essj.wh_shopping.repositories;

import com.essj.wh_shopping.DTO.ShopReportDTO;
import com.essj.wh_shopping.entities.Shop;

import java.util.Date;
import java.util.List;

public interface ReportRepository {

    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);
}
