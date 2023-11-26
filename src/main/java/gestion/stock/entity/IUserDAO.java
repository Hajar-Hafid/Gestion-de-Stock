package gestion.stock.entity;

import java.util.List;

public interface IUserDAO extends IDAO< User>{
    public List<User> getAll(String type);

}
