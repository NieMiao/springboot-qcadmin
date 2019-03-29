package qcadmin.auth.model;

import lombok.Data;
import org.springframework.data.domain.PageRequest;

/**
 * @program: springboot-qcadmin
 * @description: 分页对象
 * @author: NieMiao
 * @create: 2019-03-21 10:26
 **/
@Data
public class PageUtils {

    private int page = 0;
    private int rows = 10;

    public PageRequest getInstance(){
        if (0 == page && 0 == rows){
            return null;
        }
        else {
            if (this.page>0){
                page -= 1;
            }
        }
        return PageRequest.of(page, rows);
    }
}
