package com.lcwork.multishop.wx.service;

import com.lcwork.multishop.db.domain.generate.LitemallRegion;
import com.lcwork.multishop.db.service.LitemallRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhy
 * @date 2019-01-17 23:07
 **/
@Component
public class GetRegionService {

    private static List<LitemallRegion> litemallRegions;
    @Autowired
    private LitemallRegionService regionService;

    protected List<LitemallRegion> getLitemallRegions() {
        if (litemallRegions == null) {
            createRegion();
        }
        return litemallRegions;
    }

    private synchronized void createRegion() {
        if (litemallRegions == null) {
            litemallRegions = regionService.getAll();
        }
    }
}