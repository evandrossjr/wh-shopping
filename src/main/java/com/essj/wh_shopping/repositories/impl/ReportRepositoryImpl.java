package com.essj.wh_shopping.repositories.impl;

import com.essj.wh_shopping.DTO.ShopReportDTO;
import com.essj.wh_shopping.entities.Shop;
import com.essj.wh_shopping.repositories.ReportRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class ReportRepositoryImpl implements ReportRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo) {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT s ");
        sb.append("FROM Shop s ");
        sb.append("WHERE s.date >= :dataInicio");

        if (dataFim != null){
            sb.append(" AND s.date <= :dataFim");
        }

        if (valorMinimo != null){
            sb.append(" AND s.total <= :valorMinimo");
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
    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT count(sp.id), sum(sp.total),m avg(sp.total) ");
        sb.append("FROM shopping.Shop sp ");
        sb.append("WHERE sp.date >= :dataInicio ");
        sb.append("AND sp.date <= :dataFim ");

        Query query = entityManager.createNativeQuery(sb.toString());
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);

        Object[] result = (Object[]) query.getSingleResult();
        ShopReportDTO shopReportDTO= new ShopReportDTO();
        shopReportDTO.setCount(((BigInteger) result[0]).intValue());
        shopReportDTO.setTotal((Double) result[1]);
        shopReportDTO.setMean((Double) result[2]);

        return shopReportDTO;
    }

}
