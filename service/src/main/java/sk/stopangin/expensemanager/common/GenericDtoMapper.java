package sk.stopangin.expensemanager.common;

import org.mapstruct.MappingTarget;

public interface GenericDtoMapper<ReadDto, CreateDto, UpdateDto, Entity> {

    ReadDto toReadDto(Entity entity);

    Entity fromCreateDto(CreateDto createDto);

    void updateFromDto(UpdateDto updateDto, @MappingTarget Entity entity);

}
