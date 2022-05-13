package com.duong.mycase41.service.approle;


import com.duong.mycase41.model.AppRole;
import com.duong.mycase41.service.IGeneralService;

public interface IAppRoleService extends IGeneralService<AppRole> {
    AppRole findByName(String name);
}
