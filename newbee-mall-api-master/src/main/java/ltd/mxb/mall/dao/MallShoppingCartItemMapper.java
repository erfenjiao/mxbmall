/**
 *苦心人，天不负
 */
package ltd.mxb.mall.dao;

import ltd.mxb.mall.entity.MallShoppingCartItem;
import ltd.mxb.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallShoppingCartItemMapper {
    int deleteByPrimaryKey(Long cartItemId);

    int insert(MallShoppingCartItem record);

    int insertSelective(MallShoppingCartItem record);

    MallShoppingCartItem selectByPrimaryKey(Long cartItemId);

    MallShoppingCartItem selectByUserIdAndGoodsId(@Param("newBeeMallUserId") Long newBeeMallUserId, @Param("goodsId") Long goodsId);

    List<MallShoppingCartItem> selectByUserId(@Param("newBeeMallUserId") Long newBeeMallUserId, @Param("number") int number);

    List<MallShoppingCartItem> selectByUserIdAndCartItemIds(@Param("newBeeMallUserId") Long newBeeMallUserId, @Param("cartItemIds") List<Long> cartItemIds);

    int selectCountByUserId(Long newBeeMallUserId);

    int updateByPrimaryKeySelective(MallShoppingCartItem record);

    int updateByPrimaryKey(MallShoppingCartItem record);

    int deleteBatch(List<Long> ids);

    List<MallShoppingCartItem> findMyNewBeeMallCartItems(PageQueryUtil pageUtil);

    int getTotalMyNewBeeMallCartItems(PageQueryUtil pageUtil);
}