package com.osyunge.controller;

import com.osyunge.dataobject.EasyUIDataGridResult;
import com.osyunge.pojo.TbItem;
import com.osyunge.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("/item")
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    private TbItem getItemById(@PathVariable long itemId) {
        TbItem item = itemService.getItemById(itemId);
        return item;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page,Integer rows){
        EasyUIDataGridResult result=itemService.getItemList(page,rows);
        return result;
    }
}
