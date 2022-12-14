/**
 *苦心人，天不负
 */
package ltd.mxb.mall.service;

import ltd.mxb.mall.api.mall.vo.MallIndexConfigGoodsVO;
import ltd.mxb.mall.entity.IndexConfig;
import ltd.mxb.mall.util.PageQueryUtil;
import ltd.mxb.mall.util.PageResult;

import java.util.List;

public interface MallIndexConfigService {

    /**
     * 返回固定数量的首页配置商品对象(首页调用)
     *
     * @param number
     * @return
     */
    List<MallIndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number);

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getConfigsPage(PageQueryUtil pageUtil);

    String saveIndexConfig(IndexConfig indexConfig);

    String updateIndexConfig(IndexConfig indexConfig);

    IndexConfig getIndexConfigById(Long id);

    Boolean deleteBatch(Long[] ids);
}
