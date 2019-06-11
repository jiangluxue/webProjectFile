package com.osyunge.service;

import com.osyunge.dataobject.EasyUIDataGridResult;
import com.osyunge.pojo.TbItem;

public interface ItemService {
     TbItem getItemById(Long itemId);
/*查询商品列表*/
     EasyUIDataGridResult getItemList(int page, int rows);
}
