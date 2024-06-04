package local.wpr.start.sios.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Transient;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Temp {
    @Transient
    private Long tempId;
    @Transient
    private int tempValue1;
    @Transient
    private int tempValue2;
    @Transient
    private int tempValue3;
    @Transient
    private int tempValue4;
    @Transient
    private int tempValue5;
    @Transient
    private int tempValue6;
    @Transient
    private int tempValue7;
    @Transient
    private int tempValue8;
    @Transient
    private int tempValue9;
}
