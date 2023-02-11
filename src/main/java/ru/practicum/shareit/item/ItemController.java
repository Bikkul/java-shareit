package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.item.dto.*;
import ru.practicum.shareit.item.service.ItemService;

import javax.validation.Valid;
import java.util.List;

/**
 * TODO Sprint add-controllers.
 */
@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto saveItem(@RequestHeader("X-Sharer-User-Id") Long ownerId,
                            @Valid @RequestBody ItemDtoFromRequest itemDto) {
        log.info("the item has been saved");
        return itemService.saveItem(itemDto, ownerId);
    }

    @PatchMapping("/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDto updateItem(@RequestHeader("X-Sharer-User-Id") Long ownerId,
                              @RequestBody ItemDtoFromRequest itemDto,
                              @PathVariable Long itemId) {
        log.info("the item with id={} has been saved", itemId);
        return itemService.updateItem(itemDto, itemId, ownerId);
    }

    @DeleteMapping("/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long itemId) {
        log.info("the item with id={} has been deleted", itemId);
        itemService.deleteItem(itemId);
    }

    @GetMapping("/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDetailedDto findItemById(@RequestHeader("X-Sharer-User-Id") Long userId,
                                        @PathVariable Long itemId) {
        log.info("the item with id={} has been got", itemId);
        return itemService.getItemById(itemId, userId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDetailedDto> getUserItemsById(@RequestHeader("X-Sharer-User-Id") Long ownerId) {
        log.info("the user item's has been got");
        return itemService.getUserItemsById(ownerId);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getUserItemByText(@RequestHeader("X-Sharer-User-Id") Long ownerId,
                                           @RequestParam String text) {
        log.info("the user item's has been got");
        return itemService.getUserItemByText(ownerId, text);
    }

    @PostMapping("/{itemId}/comment")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto addCommentToItem(@RequestHeader("X-Sharer-User-Id") Long ownerId,
                                       @PathVariable Long itemId,
                                       @RequestBody @Valid CommentDtoFromRequest commentDto) {
        log.info("comment to item with id={} added", itemId);
        return itemService.addCommentToItem(ownerId, itemId, commentDto);
    }
}
