package com.essj.wh_shopping.controllers;


import com.essj.wh_shopping.DTO.ShopDTO;
import com.essj.wh_shopping.DTO.ShopReportDTO;
import com.essj.wh_shopping.entities.Shop;
import com.essj.wh_shopping.services.ReportService;
import com.essj.wh_shopping.services.ShopService;
import jakarta.validation.Valid;
import org.aspectj.lang.annotation.DeclareWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ReportService reportService;


    @GetMapping("/shopping")
    public List<ShopDTO> getShops(){
        List<ShopDTO> produtos = shopService.findAll();
        return produtos;
    }


    @GetMapping("/shopping/shopByUser/{userIdentifier}")
    public List<ShopDTO> getShops(@PathVariable String userIdentifier){
        List<ShopDTO> produtos = shopService.getByUser(userIdentifier);
        return produtos;
    }

    @GetMapping("/shopping/shopByDate")
    public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO) {
        List<ShopDTO> produtos = shopService.getByDate(shopDTO);
        return produtos;
    }

    @GetMapping("/shopping/{id}")
    public ShopDTO findById(@PathVariable Long id){
        return shopService.findById(id);
    }

    @PostMapping("/shopping")
    public ShopDTO newShop(@Valid @RequestBody ShopDTO shopDTO){
        return shopService.save(shopDTO);
    }

    @GetMapping("/shopping/search")
    public List<ShopDTO> getShopsByFilter(
            @RequestParam(name = "dataInicio", required = true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
            @RequestParam(name = "dataFim", required = false)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim,
            @RequestParam(name = "valorMinimo", required = false)
            Float valorMinimo) {
        return reportService.getShopByFilter(dataInicio, dataFim, valorMinimo);
    }

    @GetMapping("shopping/report")
    public ShopReportDTO getReportByDate(
            @RequestParam(name = "dataInicio", required = true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
            @RequestParam(name = "dataFim", required = true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim){
        return reportService.getReportByDate(dataInicio, dataFim);
    }


}

