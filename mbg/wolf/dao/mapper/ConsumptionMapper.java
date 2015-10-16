package mbg.wolf.dao.mapper;

import mbg.wolf.model.Consumption;

public interface ConsumptionMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Consumption record);

    int insertSelective(Consumption record);

    Consumption selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Consumption record);

    int updateByPrimaryKey(Consumption record);
}