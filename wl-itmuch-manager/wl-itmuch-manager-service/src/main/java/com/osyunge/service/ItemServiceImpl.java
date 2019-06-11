package com.osyunge.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.osyunge.dao.TbItemMapper;
import com.osyunge.dataobject.EasyUIDataGridResult;
import com.osyunge.pojo.TbItem;
import com.osyunge.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(Long itemId) {
        //TbItem item = itemMapper.selectByPrimaryKey(itemId);
        TbItemExample example = new TbItemExample();
        //创建查询条件
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list = itemMapper.selectByExample(example);
        //判断list中是否为空
        TbItem item = null;
        if (list != null && list.size() > 0) {
            item = list.get(0);
        }
        return item;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        //执行查询
        TbItemExample example=new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        //获取分页信息
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        //返回处理结果
        EasyUIDataGridResult result=new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }

}

