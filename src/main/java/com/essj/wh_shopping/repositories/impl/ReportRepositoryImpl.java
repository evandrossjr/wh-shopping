package com.essj.wh_shopping.repositories.impl;

import com.essj.wh_shopping.DTO.ShoReportDTO;
import com.essj.wh_shopping.entities.Shop;
import com.essj.wh_shopping.repositories.ReportRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.Date;
import java.util.List;

public class ReportRepositoryImpl implements ReportRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo) {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT s ");
        sb.append("FROM shop s ");
        sb.append("WHERE s.date >= :dataInicio");

        if (dataFim != null){
            sb.append("AND s.date <= :dataFim");
        }

        if (valorMinimo != null){
            sb.append("AND s.total <= :valorMinimo");
        }

        Query query = entityManager.createQuery(sb.toString());
        query.setParameter("dataInicio", dataInicio);

        if (dataFim != null){
            query.setParameter("dataFim", dataFim);
        }

        if (valorMinimo != null){
            query.setParameter("valorMinimo", valorMinimo);
        }

        return query.getResultList();
    }

    @Override
    public ShoReportDTO getReportByDate(Date dataInicio, Date dataFim) {
        return null;
    }

}
