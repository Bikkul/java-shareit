package ru.practicum.shareit.request.dto;

import lombok.*;
import ru.practicum.shareit.item.dto.ItemDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO Sprint add-item-requests.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ItemRequestDto {
    private Long id;
    private String description;
    private LocalDateTime created;
    private List<ItemDto> items = new ArrayList<>();
}
