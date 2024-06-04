package local.wpr.start.sios.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TempObj extends Temp {
        public TempObj(Long tempId, int tempValue1, int tempValue2, int tempValue3, int tempValue4, int tempValue5, int tempValue6, int tempValue7, int tempValue8, int tempValue9, List<Temp> temps) {
                super(tempId, tempValue1, tempValue2, tempValue3, tempValue4, tempValue5, tempValue6, tempValue7, tempValue8, tempValue9);
                this.temps = temps;
        }

        private List<Temp> temps;
}
