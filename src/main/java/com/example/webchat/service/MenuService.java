package com.example.webchat.service;

import com.example.webchat.constant.MenuTypeEnum;
import com.example.webchat.entity.Menu;
import com.example.webchat.entity.MenuExample;
import com.example.webchat.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public int deleteById(String id){
        return menuMapper.deleteByPrimaryKey(id);
    }

    public int insert(Menu menu){
       return menuMapper.insert(menu);

    }

    public Menu selectById(String id){
       return menuMapper.selectByPrimaryKey(id);
    }

    public int  update(Menu menu){
        return menuMapper.updateByPrimaryKey(menu);
    }

    public List<Menu> selectAll(){
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        criteria.andMenuTypeEqualTo(MenuTypeEnum.TYPE_1.getCode());
        menuExample.setOrderByClause("order_number");
        return menuMapper.selectByExample(menuExample);
    }

    public List<Menu> selectSon(String menuId){
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        criteria.andParentIdEqualTo(menuId);
        menuExample.setOrderByClause("order_number");
        return menuMapper.selectByExample(menuExample);
    }
}