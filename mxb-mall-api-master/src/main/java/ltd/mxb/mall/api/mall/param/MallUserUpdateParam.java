/**
 *苦心人，天不负
 */
package ltd.mxb.mall.api.mall.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * 用户修改param
 */
@Data
public class MallUserUpdateParam implements Serializable {

    /**
     *  定义了 MallUserUpdateParam 对象来接收用户修改的信息字段，需要修改的字段主要有昵称、密码、个性签名，
     *  并使用 @RequestBody 注解来接收，之后调用业务层的 updateUserInfo() 方法来进行入库操作，将这些字段 update 掉
     * */
    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("用户密码(需要MD5加密)")
    private String passwordMd5;

    @ApiModelProperty("个性签名")
    private String introduceSign;

}
