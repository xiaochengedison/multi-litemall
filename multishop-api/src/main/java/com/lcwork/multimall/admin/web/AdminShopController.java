package com.lcwork.multimall.admin.web;

import com.lcwork.multimall.admin.service.AdminShopService;
import com.lcwork.multimall.core.annotation.RequiresPermissionsDesc;
import com.lcwork.multimall.core.util.response.DataList;
import com.lcwork.multimall.core.util.response.ResponseData;
import com.lcwork.multimall.core.validator.Order;
import com.lcwork.multimall.core.validator.Sort;
import com.lcwork.multimall.db.domain.generate.MultimallShop;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/shop")
@Validated
public class AdminShopController {
    private final Log logger = LogFactory.getLog(AdminShopController.class);

    @Autowired
    AdminShopService shopService;

    @RequiresPermissions("admin:shop:list")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "查询")
    @GetMapping("/list")
    public ResponseData<DataList<MultimallShop>> list(String name,
                                                     @RequestParam(defaultValue = "1") Integer page,
                                                     @RequestParam(defaultValue = "10") Integer limit,
                                                     @Sort @RequestParam(defaultValue = "add_time") String sort,
                                                     @Order @RequestParam(defaultValue = "desc") String order) {
        return shopService.list(name, page, limit, sort, order);
    }

    @RequiresPermissions("admin:shop:create")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "创建")
    @PostMapping("/create")
    public ResponseData<Object> create(@RequestBody MultimallShop shop) {
        return shopService.create(shop);
    }

    @RequiresPermissions("admin:shop:update")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "更新")
    @PostMapping("/update")
    public ResponseData<Object> update(@RequestBody MultimallShop shop) {
        return shopService.update(shop);
    }

    @RequiresPermissions("admin:shop:delete")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "删除")
    @PostMapping("/delete")
    public ResponseData<Object> delete(@RequestBody MultimallShop shop) {
        return shopService.delete(shop);
    }

    @RequiresPermissions("admin:shop:changeStatus")
    @RequiresPermissionsDesc(menu = {"商铺", "商铺管理"}, button = "禁用")
    @PostMapping("/changeStatus")
    public ResponseData<Object> changeStatus(@RequestBody MultimallShop shop) {
        return shopService.changeStatus(shop.getId(), shop.getStatus());
    }
}
