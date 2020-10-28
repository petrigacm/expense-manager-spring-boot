package sk.stopangin.expensemanager;

public interface CrudResource<ReadDto, CreateDto, UpdateDto, ID> {

    ReadDto create(CreateDto dto);

    ReadDto update(ID id, UpdateDto dto);

    void delete(ID id);

    ReadDto getById(ID id);
}
