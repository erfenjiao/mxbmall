/**
 *苦心人，天不负
 */
package ltd.mxb.mall.service;

import ltd.mxb.mall.api.mall.vo.MallIndexCarouselVO;
import ltd.mxb.mall.entity.Carousel;
import ltd.mxb.mall.util.PageQueryUtil;
import ltd.mxb.mall.util.PageResult;

import java.util.List;

public interface MallCarouselService {

    /**
     * 返回固定数量的轮播图对象(首页调用)
     *
     * @param number
     * @return
     */
    List<MallIndexCarouselVO> getCarouselsForIndex(int number);

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getCarouselPage(PageQueryUtil pageUtil);

    String saveCarousel(Carousel carousel);

    String updateCarousel(Carousel carousel);

    Carousel getCarouselById(Integer id);

    Boolean deleteBatch(Long[] ids);
}
