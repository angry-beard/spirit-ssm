package org.angrybeard.spiritssm.bo;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by angry_beary on 2019/6/30.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private String photo;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
