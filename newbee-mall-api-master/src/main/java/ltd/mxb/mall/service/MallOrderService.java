/**
 *苦心人，天不负
 */
package ltd.mxb.mall.service;

import ltd.mxb.mall.entity.MallUser;
import ltd.mxb.mall.api.mall.vo.MallOrderDetailVO;
import ltd.mxb.mall.api.mall.vo.MallOrderItemVO;
import ltd.mxb.mall.api.mall.vo.MallShoppingCartItemVO;
import ltd.mxb.mall.entity.MallUserAddress;
import ltd.mxb.mall.entity.MallOrder;
import ltd.mxb.mall.util.PageQueryUtil;
import ltd.mxb.mall.util.PageResult;

import java.util.List;

public interface MallOrderService {
    /**
     * 获取订单详情
     *
     * @param orderId
     * @return
     */
    MallOrderDetailVO getOrderDetailByOrderId(Long orderId);

    /**
     * 获取订单详情
     *
     * @param orderNo
     * @param userId
     * @return
     */
    MallOrderDetailVO getOrderDetailByOrderNo(String orderNo, Long userId);

    /**
     * 我的订单列表
     *
     * @param pageUtil
     * @return
     */
    PageResult getMyOrders(PageQueryUtil pageUtil);

    /**
     * 手动取消订单
     *
     * @param orderNo
     * @param userId
     * @return
     */
    String cancelOrder(String orderNo, Long userId);

    /**
     * 确认收货
     *
     * @param orderNo
     * @param userId
     * @return
     */
    String finishOrder(String orderNo, Long userId);

    String paySuccess(String orderNo, int payType);

    String saveOrder(MallUser loginMallUser, MallUserAddress address, List<MallShoppingCartItemVO> itemsForSave);

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getNewBeeMallOrdersPage(PageQueryUtil pageUtil);

    /**
     * 订单信息修改
     *
     * @param mallOrder
     * @return
     */
    String updateOrderInfo(MallOrder mallOrder);

    /**
     * 配货
     *
     * @param ids
     * @return
     */
    String checkDone(Long[] ids);

    /**
     * 出库
     *
     * @param ids
     * @return
     */
    String checkOut(Long[] ids);

    /**
     * 关闭订单
     *
     * @param ids
     * @return
     */
    String closeOrder(Long[] ids);

    List<MallOrderItemVO> getOrderItems(Long orderId);
}
