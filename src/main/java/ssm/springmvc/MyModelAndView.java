package ssm.springmvc;

import lombok.Data;

/**
 * @ClassName MyModelAndView
 * @Description
 * @Data 2018/12/6
 * @Author Yien
 */
@Data
public class MyModelAndView {

    private String view;
    private MyModelMap modelMap;

    public MyModelAndView(String view) {
        this.view = view;
    }
}
