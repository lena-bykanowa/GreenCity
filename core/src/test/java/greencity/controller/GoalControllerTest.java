package greencity.controller;

import greencity.dto.goal.GoalRequestDto;
import greencity.service.GoalService;
import java.util.Collections;
import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.validation.Validator;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class GoalControllerTest {
    private static final String userLink = "/user";
    private MockMvc mockMvc;
    @InjectMocks
    private GoalController goalController;
    @Mock
    private GoalService goalService;
    @Mock
    private Validator mockValidator;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders
            .standaloneSetup(goalController)
            .setValidator(mockValidator)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .build();
    }

    @Test
    void bulkDeleteUserGoalsTest() throws Exception {
        mockMvc.perform(delete(userLink + "/{userId}/userGoals?ids=1,2", 1))
            .andExpect(status().isOk());

        verify(goalService).deleteUserGoals(eq("1,2"));
    }

    @Test
    void updateUserGoalStatusWithLanguageParamTest() throws Exception {
        mockMvc.perform(patch(userLink + "/{userId}/goals/{goalId}", 1, 1)
            .locale(new Locale("ru")))
            .andExpect(status().isCreated());

        verify(goalService).updateUserGoalStatus(eq(1L), eq(1L), eq("ru"));
    }

    @Test
    void updateUserGoalStatusWithoutLanguageParamTest() throws Exception {
        mockMvc.perform(patch(userLink + "/{userId}/goals/{goalId}", 1, 1))
            .andExpect(status().isCreated());

        verify(goalService).updateUserGoalStatus(eq(1L), eq(1L), eq("en"));
    }

    @Test
    void saveUserGoalsWithoutLanguageParamTest() throws Exception {
        String content = "[\n"
            + " {\n"
            + "    \"id\": 1\n"
            + " }\n"
            + "]\n";

        mockMvc.perform(post(userLink + "/{userId}/save-goals?habitId=1&lang=en", 1)
            .contentType(MediaType.APPLICATION_JSON)
            .content(content))
            .andExpect(status().isCreated());

        GoalRequestDto dto = new GoalRequestDto(1L);
        verify(goalService).saveUserGoals(1L, 1L, Collections.singletonList(dto), "en");
    }

    @Test
    void getUserGoalsWithLanguageParamTest() throws Exception {
        mockMvc.perform(get(userLink + "/{userId}//habits/1/shopping-list?lang=en", 1))
            .andExpect(status().isOk());

        verify(goalService).getUserGoals(eq(1L), eq(1L), eq("en"));
    }

    @Test
    void getUserGoalsWithoutLanguageParamTest() throws Exception {
        mockMvc.perform(get(userLink + "/{userId}//habits/1/shopping-list", 1))
            .andExpect(status().isOk());

        verify(goalService).getUserGoals(eq(1L), eq(1L), eq("en"));
    }
}
