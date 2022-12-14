/**
 *苦心人，天不负
 */
package ltd.mxb.mall.dao;

import ltd.mxb.mall.entity.MallOrderAddress;

public interface MallOrderAddressMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(MallOrderAddress record);

    int insertSelective(MallOrderAddress record);

    MallOrderAddress selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(MallOrderAddress record);

    int updateByPrimaryKey(MallOrderAddress record);
}