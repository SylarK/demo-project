package pt.amado.maindemoproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.amado.maindemoproject.dto.MenuDTO;
import pt.amado.maindemoproject.entity.Menu;
import pt.amado.maindemoproject.exception.MenuException;
import pt.amado.maindemoproject.mapper.MenuMapper;
import pt.amado.maindemoproject.repository.MenuRepository;

import java.util.List;
import java.util.Objects;

@Service
public class MenuService {

    private MenuRepository menuRepository;

    @Autowired
    MenuService(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    public MenuDTO save(MenuDTO menuDTO){
        Menu menu = menuRepository.save(MenuMapper.INSTANCE.toEntity(menuDTO));
        return MenuMapper.INSTANCE.toDTO(menu);
    }

    public List<Menu> findAll(){
        return menuRepository.findAll();
    }

    public Menu findItemById(int id) throws MenuException {

        Menu menu = menuRepository.findItemById(id);
        if(Objects.isNull(menu))
            throw new MenuException(String.format("Error: Menu with id %d not found.", id));

        return menu;
    }

    public String deleteMenu(int id) throws MenuException {

        if(menuRepository.deleteMenu(id) == 0)
            throw new MenuException(String.format("Error: Menu with id %d not found.", id));

        return "Menu deleted successfully!";
    }

    public String deleteAllMenus(){
        menuRepository.deleteAllMenus();
        return "All menus was deleted.";
    }
}
