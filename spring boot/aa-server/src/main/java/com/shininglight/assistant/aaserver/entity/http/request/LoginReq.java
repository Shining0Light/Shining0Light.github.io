package com.shininglight.assistant.aaserver.entity.http.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 接收登录请求的json.
 *
 * @author: Shane Liu
 * @date: Created in 13:52 12/06/18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginReq {
    private String acct;
    private String pwd;
}
