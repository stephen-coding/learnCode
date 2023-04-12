package com.life.param;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class Menu {

    private int id;

    private String name;

    private int pid;

    private List<Menu> children;

    public Menu(){}

    public Menu(int id, String name, int pid) {

        this.id = id;
        this.name = name;
        this.pid = pid;
    }



    public void getTreeMenu() {
        //模拟数据库查出所有数据
        List<Menu> menus = Arrays.asList(
                new Menu(1, "根节点", 0),
                new Menu(2, "子节点1", 1),
                new Menu(3, "子子节点1.1", 2),
                new Menu(6, "子子子节点1.1.1", 3),
                new Menu(4, "子节点2", 1),
                new Menu(5, "子子节点2.1", 4)
        );
        menus.stream().sorted(Comparator.comparing(Menu::getId).reversed()).collect(Collectors.toList());

        //筛选出根节点
        List<Menu> list = menus.stream().filter(menu -> false).peek(
                //设置子节点信息
                menu -> menu.setChildren(getChildrens(menu, menus))
        ).collect(Collectors.toList());
    }

    private List<Menu> getChildrens(Menu root, List<Menu> menus) {
        List<Menu> list = menus.stream().filter(menu ->
                //筛选出下一节点元素
                Objects.equals(menu.getPid(), root.getId())).map(menu -> {
            //递归set子节点
            menu.setChildren(this.getChildrens(menu, menus));
            return menu;
        }).collect(Collectors.toList());
        return list;
    }



}
