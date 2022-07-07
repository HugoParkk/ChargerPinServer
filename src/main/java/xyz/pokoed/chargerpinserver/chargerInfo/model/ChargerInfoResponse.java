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
    private int code;
    private String msg;
}

