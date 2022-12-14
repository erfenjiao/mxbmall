/**
 *苦心人，天不负
 */
package ltd.mxb.mall.config.handler;

import ltd.mxb.mall.common.Constants;
import ltd.mxb.mall.common.MallException;
import ltd.mxb.mall.common.ServiceResultEnum;
import ltd.mxb.mall.config.annotation.TokenToMallUser;
import ltd.mxb.mall.dao.MallUserMapper;
import ltd.mxb.mall.dao.MallUserTokenMapper;
import ltd.mxb.mall.entity.MallUser;
import ltd.mxb.mall.entity.MallUserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class TokenToMallUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private MallUserMapper mallUserMapper;
    @Autowired
    private MallUserTokenMapper mallUserTokenMapper;

    public TokenToMallUserMethodArgumentResolver() {
    }

    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(TokenToMallUser.class)) {
            return true;
        }
        return false;
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        if (parameter.getParameterAnnotation(TokenToMallUser.class) instanceof TokenToMallUser) {
            MallUser mallUser = null;
            /**
             *  获取 token 对象
             * */
            String token = webRequest.getHeader("token");
            if (null != token && !"".equals(token) && token.length() == Constants.TOKEN_LENGTH) {
                MallUserToken mallUserToken = mallUserTokenMapper.selectByToken(token);
                if (mallUserToken == null || mallUserToken.getExpireTime().getTime() <= System.currentTimeMillis()) {
                    MallException.fail(ServiceResultEnum.TOKEN_EXPIRE_ERROR.getResult());
                }
                mallUser = mallUserMapper.selectByPrimaryKey(mallUserToken.getUserId());
                /**
                 *  用户不存在
                 * */
                if (mallUser == null) {
                    MallException.fail(ServiceResultEnum.USER_NULL_ERROR.getResult());
                }
                /**
                 *  是否被封禁
                 * */
                if (mallUser.getLockedFlag().intValue() == 1) {
                    MallException.fail(ServiceResultEnum.LOGIN_USER_LOCKED_ERROR.getResult());
                }
                /**
                 *   返回用户对象供对应的方法使用
                 *   配置方法参数解析器
                 *   最后在 WebMvcConfigurer 中配置 TokenToMallUserMethodArgumentResolver 使其生效，
                 *   代码：ltd.newbee.mall.config;->  MallWebMvcConfigurer
                 * */
                return mallUser;
            } else {
                /**
                 *  登陆失败
                 * */
                MallException.fail(ServiceResultEnum.NOT_LOGIN_ERROR.getResult());
            }
        }
        return null;
    }

//    public static byte[] getRequestPostBytes(HttpServletRequest request)
//            throws IOException {
//        int contentLength = request.getContentLength();
//        if (contentLength < 0) {
//            return null;
//        }
//        byte buffer[] = new byte[contentLength];
//        for (int i = 0; i < contentLength; ) {
//            int readlen = request.getInputStream().read(buffer, i,
//                    contentLength - i);
//            if (readlen == -1) {
//                break;
//            }
//            i += readlen;
//        }
//        return buffer;
//    }

}
