package web_2.data;

import java.util.ArrayList;
import java.util.List;

public class RequestDataList {

    List<RequestObj> dataList = new ArrayList<>();

    public List<RequestObj> getDataList() {
        return dataList;
    }

    public void addEntry(RequestObj obj) {
        this.dataList.add(0, obj);
    }

}
