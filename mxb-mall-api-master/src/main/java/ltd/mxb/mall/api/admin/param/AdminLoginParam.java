/**
 *苦心人，天不负
 */
package ltd.mxb.mall.api.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 添加 @Data，省去定义 set get 方法的步骤
 **/
@Data
public class AdminLoginParam implements Serializable {

    /**
     * @NotEmpty 为参数验证的注解，message 中定义当对应参数为空时提示的异常信息。
     **/
    @ApiModelProperty("登录名")
    @NotEmpty(message = "登录名不能为空")
    private String userName;

    @ApiModelProperty("用户密码(需要MD5加密)")
    @NotEmpty(message = "密码不能为空")
    private String passwordMd5;
}
