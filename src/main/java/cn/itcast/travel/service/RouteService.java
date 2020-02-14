package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface RouteService {
    /**
     *
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize);
}
