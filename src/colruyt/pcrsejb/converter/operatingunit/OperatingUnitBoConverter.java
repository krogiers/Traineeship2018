package colruyt.pcrsejb.converter.operatingunit;

import colruyt.pcrsejb.bo.operatingunit.OperatingUnitBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.operatingunit.OperatingUnit;

public class OperatingUnitBoConverter implements GenericConverter<OperatingUnit, OperatingUnitBo> {

    @Override
    public OperatingUnit convertTo(OperatingUnitBo from) {
        OperatingUnit operatingUnit = null;
        if (from != null) {
            operatingUnit = new OperatingUnit(from.getOperatingUnitId(), from.getOperatingUnitName());
        }
        return operatingUnit;
    }

}
