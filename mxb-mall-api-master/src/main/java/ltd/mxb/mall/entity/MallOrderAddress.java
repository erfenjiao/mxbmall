/**
 *苦心人，天不负
 */
package ltd.mxb.mall.entity;

import lombok.Data;

@Data
public class MallOrderAddress {
    private Long orderId;

    private String userName;

    private String userPhone;

    private String provinceName;

    private String cityName;

    private String regionName;

    private String detailAddress;
}