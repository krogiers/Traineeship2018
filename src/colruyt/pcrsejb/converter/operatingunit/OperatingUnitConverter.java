package colruyt.pcrsejb.converter.operatingunit;

import colruyt.pcrsejb.bo.operatingunit.OperatingUnitBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.operatingunit.OperatingUnit;

public class OperatingUnitConverter implements GenericConverter<OperatingUnitBo, OperatingUnit> {

    @Override
    public OperatingUnitBo convertTo(OperatingUnit from) {
        return new OperatingUnitBo(from.getId(), from.getOperatingUnitName());
    }
}
