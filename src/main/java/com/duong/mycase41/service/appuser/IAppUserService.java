package com.duong.mycase41.service.appuser;


import com.duong.mycase41.model.AppUser;
import com.duong.mycase41.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAppUserService extends IGeneralService<AppUser>, UserDetailsService {
    AppUser findByName(String name);
}
