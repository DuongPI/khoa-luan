package tienganhmienphi.com.backend.Springboot.utils;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountTheNumberOfDuplicateElements {
    public int Count(List<Long> list1, List<Long> list2){
        int dem = 0;
        for(int i = 0 ; i< list1.size() ;i++){
            if (list1.get(i) == list2.get(i))
                dem ++;
        }
        return dem;
    }
}
