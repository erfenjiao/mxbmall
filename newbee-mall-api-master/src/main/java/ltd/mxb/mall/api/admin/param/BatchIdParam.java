/**
 *苦心人，天不负
 */
package ltd.mxb.mall.api.admin.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class BatchIdParam implements Serializable {
    //id数组
    Long[] ids;
}
