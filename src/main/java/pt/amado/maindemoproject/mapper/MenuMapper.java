package pt.amado.maindemoproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pt.amado.maindemoproject.dto.MenuDTO;
import pt.amado.maindemoproject.entity.Menu;

@Mapper
public interface MenuMapper {

    MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);

    MenuDTO toDTO(Menu menu);
    Menu toEntity(MenuDTO menuDTO);
}
