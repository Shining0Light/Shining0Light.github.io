package com.shininglight.assistant.aaserver.entity.http.respon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 相应请求的json.
 *
 * @author: Shane Liu
 * @date: Created in 14:23 12/05/18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RespBean {
    private int code;
    private String msg;
    private Object data;
}
