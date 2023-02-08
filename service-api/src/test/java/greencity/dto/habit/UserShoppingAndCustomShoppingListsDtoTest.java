package greencity.dto.habit;

import greencity.ModelUtils;
import greencity.dto.shoppinglistitem.CustomShoppingListItemResponseDto;
import greencity.enums.ShoppingListItemStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserShoppingAndCustomShoppingListsDtoTest {

    void testValid(UserShoppingAndCustomShoppingListsDto dto) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();

        Set<ConstraintViolation<UserShoppingAndCustomShoppingListsDto>> constraintViolations =
            validator.validate(dto);

        assertTrue(constraintViolations.isEmpty());
    }

    void testInvalid(UserShoppingAndCustomShoppingListsDto dto) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();

        Set<ConstraintViolation<UserShoppingAndCustomShoppingListsDto>> constraintViolations =
            validator.validate(dto);

        assertFalse(constraintViolations.isEmpty());
    }

    @Test
    void validTest() {
        var dto = ModelUtils.getUserShoppingAndCustomShoppingListsDto();

        testValid(dto);
    }

    @Test
    void invalidTestWithInvalidUserShoppingList() {
        var userDto = ModelUtils.getUserShoppingListItemResponseDto();
        userDto.setId(-1L);
        var dto = ModelUtils.getUserShoppingAndCustomShoppingListsDto();
        dto.setUserShoppingListItemDto(List.of(userDto));

        testInvalid(dto);
    }

    @Test
    void invalidTestWithInvalidCustomShoppingList() {
        var customDto = ModelUtils.getCustomShoppingListItemResponseDto();
        customDto.setId(-1L);
        var dto = ModelUtils.getUserShoppingAndCustomShoppingListsDto();
        dto.setCustomShoppingListItemDto(List.of(customDto));

        testInvalid(dto);
    }
}
