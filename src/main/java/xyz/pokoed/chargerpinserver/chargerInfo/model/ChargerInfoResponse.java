package xyz.pokoed.chargerpinserver.chargerInfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargerInfoResponse {
    private Header header;
    private Body body;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Header {
        private String resultCode;
        private String resultMsg;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Body {
        private List<Item> items;
        private int numOfRows;
        private int pageNo;
        private int totalCount;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Item {
        private String addr;
        private int chargeTp;
        private int cpId;
        private String cpNm;
        private int cpStat;
        private int cpTp;
        private int csId;
        private int csNm;
        private int lat;
        private int longi;
        private Timestamp statUpdateDatetime;
    }
}
