package ru.practicum.shareit.item.dto;

import org.springframework.lang.NonNull;
import ru.practicum.shareit.item.model.Item;

import java.util.Optional;

public class ItemDtoMapper {
    public static ItemDto toItemDto(@NonNull Item item) {
        return new ItemDto.ItemDtoBuilder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .available(item.getIsAvailable())
                .build();
    }

    public static Item toItemFromDto(@NonNull ItemDtoFromRequest itemDto) {
        Item item = new Item();
        Optional.ofNullable(itemDto.getName()).ifPresent(item::setName);
        Optional.ofNullable(itemDto.getDescription()).ifPresent(item::setDescription);
        Optional.ofNullable(itemDto.getAvailable()).ifPresent(item::setIsAvailable);
        return item;
    }
}
