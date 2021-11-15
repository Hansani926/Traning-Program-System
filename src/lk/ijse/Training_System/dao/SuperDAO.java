package lk.ijse.Training_System.dao;

import lk.ijse.Training_System.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface SuperDAO <Entity extends SuperEntity,ID extends Serializable>{
    public boolean save(Entity entity)throws Exception;

    public boolean delete(Entity entity)throws Exception;

    public boolean update(Entity entity)throws Exception;

    public List<Entity> getAll()throws Exception;

    public Entity getOne(ID Id)throws Exception;
}
